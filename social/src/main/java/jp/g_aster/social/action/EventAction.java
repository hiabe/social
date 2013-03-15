/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package jp.g_aster.social.action;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.entity.Stamp;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.exception.DuplicatedException;
import jp.g_aster.social.form.CreateEventForm;
import jp.g_aster.social.form.UpdateEventForm;
import jp.g_aster.social.service.EventService;
import jp.g_aster.social.util.SocialUtil;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.cubby.action.ActionClass;
import org.seasar.cubby.action.ActionContext;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Form;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestParameter;
import org.seasar.framework.beans.util.BeanUtil;

import com.google.gson.Gson;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.User;

@ActionClass
public class EventAction {

	private Log log = LogFactory.getLog(this.getClass());

	public Map<String, Object> sessionScope;

	public ActionContext actionContext;

	public EventDto event;

	@Resource
	public EventService eventService;

	public CreateEventForm createEventForm = new CreateEventForm();

	public UpdateEventForm updateEventForm = new UpdateEventForm();

	public StampDto stampDto;

	public List<EventDto> memberEventList;

	public List<MemberImageFileDto> memberFileList;

	public @RequestParameter String eventId;

	public @RequestParameter String stampId;

	public @RequestParameter String authkey;

	private boolean isLogin(){
		return sessionScope.containsKey("user");
	}

	/**
	 * イベントへ参加します。
	 * @return
	 * @throws
	 */
	public ActionResult entry() {

		if(!isLogin()){
			log.debug("イベントエントリーのため、callback");
			Facebook facebook = new FacebookFactory().getInstance();
			sessionScope.put("redirect","/event/entry?authKey="+this.authkey);
			String redirectURL = facebook.getOAuthAuthorizationURL(SocialUtil.getCallbackURL());
			sessionScope.put("facebook",facebook);
			return new Redirect(redirectURL);
		}
		User user = (User)this.sessionScope.get("user");
		log.debug("authKey=["+authkey+"]");

		EventDto eventDto=null;
		try {
			eventDto = eventService.joinEvent(this.authkey, user.getId());

		} catch (DuplicatedException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
			return new Forward("error.jsp");
		}catch (DataNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return new Forward("error.jsp");
		}
		//facebookへポストする。
		Facebook facebook = (Facebook)sessionScope.get("facebook");
		PostUpdate post;
		Post.Action action = new Post.Action(){
			private Gson gson = new Gson();
			public String getLink(){
				Map<String,String> map= new HashMap<String,String>();
				map.put("link", "http://www.g-aster.jp");
				return gson.toJson(map);
			}
			public String getName(){
				Map<String,String> map= new HashMap<String,String>();
				map.put("name", "G-aster.ltd");
				return gson.toJson(map);
			}

		};
		List<Post.Action> actionList = new ArrayList<Post.Action>();
		actionList.add(action);
		try {
			if(eventDto.getPageUrl().startsWith("http://localhost")){
				post = new PostUpdate(new URL("http://www.g-aster.jp"));
			}else{
				post = new PostUpdate(new URL(eventDto.getPageUrl()));
			}
			log.debug("◆◆link="+action.getLink());
			log.debug("◆◆name="+action.getName());
//			Gson gson = new Gson();
			post.picture(new URL(eventDto.getMemberFileUrl()))
			.name(eventDto.getEventName())
			.message(user.getName()+"が"+eventDto.getEventName()+"へ参加しました！")
			.caption(eventDto.getEventName())
			.description(eventDto.getDescription())
			.actions(actionList)
			;

			facebook.postFeed(post);
		} catch (FacebookException e){
			e.printStackTrace();
			return new Forward("error.jsp");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return new Forward("error.jsp");
		}

		return new Forward("entryFinished.jsp");
	}

	/**
	 * イベント詳細を表示します。
	 * @return
	 */
	public ActionResult showDetail() {

		if(!this.isLogin()){
			return new Redirect("/");
		}

		try {
			this.event =  eventService.getSocialEvent(Integer.parseInt(eventId));
		} catch (NumberFormatException e) {
			new Forward("error.jsp");
		} catch (DataNotFoundException e) {
			new Forward("error.jsp");
		}

		return new Forward("eventDetail.jsp");
	}


	/**
	 * イベント作成ページを開きます。
	 * @return
	 */
	public ActionResult createevent() {
		if(!this.isLogin()){
			log.info("◆◆ログインしていないため、ＴＯＰへ戻ります◆◆");
			return new Redirect("/");
		}

		User user = (User)this.sessionScope.get("user");
		//イベントの詳細とスタンプ情報を取得する。
		memberFileList =  eventService.getMemberImageFileList(user.getId());
		if(memberFileList == null){
			memberFileList = new ArrayList<MemberImageFileDto>();
		}

		return new Forward("createEvent.jsp");
	}

	/**
	 * イベントを作成します。
	 * @return
	 */
	@Form("createEventForm")
	public ActionResult create() {


		if(!this.isLogin()){
			log.info("◆◆ログインしていないため、ＴＯＰへ戻ります◆◆");
			return new Redirect("/");
		}
		log.debug("★★\n"+createEventForm.toString()+"\n★★");
		EventDto dto = new EventDto();

		BeanUtil.copyProperties(createEventForm, dto);
		try {
			dto.setEventDateFrom(DateUtils.parseDate(createEventForm.getEventDateFrom(), "yyyy/MM/dd"));
			dto.setEventDateTo(DateUtils.parseDate(createEventForm.getEventDateTo(), "yyyy/MM/dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		User user = (User)sessionScope.get("user");
		log.debug("user.id="+user.getId());
		dto.setFacebookId(user.getId());

		//イベントの登録
		eventService.makeEvent(dto);
		actionContext.getFlashMap().put("notice", "イベントの登録が完了しました。");



		return new Redirect("/");
	}

	/**
	 * 画像選択ダイアログを開きます。
	 * @return
	 */
	public ActionResult selectImage() {

		if(!this.isLogin()){
			log.info("◆◆ログインしていないため、ＴＯＰへ戻ります◆◆");
			return new Redirect("/");
		}
		User user = (User)this.sessionScope.get("user");

		this.memberFileList =  eventService.getMemberImageFileList(user.getId());
		return new Forward("selectImage.jsp");
	}


	/**
	 * スタンプ用のQRコード表示用ダイアログを開きます。
	 * @return
	 */
	public ActionResult showQRCode() {

		if(!this.isLogin()){
			return new Redirect("/");
		}
		User user = (User)this.sessionScope.get("user");

		try {
			this.stampDto =  eventService.getQRImageUrl(user.getId(), Integer.parseInt(this.eventId), Integer.parseInt(this.stampId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new Forward("error.jsp");
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			return new Forward("error.jsp");
		}
		return new Forward("viewQRCode.jsp");
	}

	/**
	 * イベントのUPDATEを行います。
	 * @return
	 */
	@Form("updateEventForm")
	public ActionResult update() {
		log.debug(updateEventForm.toString());
		EventDto eventDto = new EventDto();
		BeanUtil.copyProperties(updateEventForm, eventDto);
		for(int i=0;i<updateEventForm.getPostUrl().size();i++){
			Stamp stamp = new Stamp();
			stamp.setCaption(updateEventForm.getCaption().get(i));
			stamp.setMessage(updateEventForm.getMessage().get(i));
			stamp.setPostUrl(updateEventForm.getPostUrl().get(i));
			stamp.setStampId(Integer.parseInt(updateEventForm.getStampId().get(i)));
		}
		try {
			eventService.updateEvent(eventDto);
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "該当データが存在しません。");
			return new Forward("/common/error.jsp");
		}
		actionContext.getFlashMap().put("notice", "更新が完了しました。");
		return new Forward("/event/eventDetail.jsp");
	}
}