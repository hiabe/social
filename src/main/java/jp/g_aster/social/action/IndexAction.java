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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.entity.MemberImageFile;
import jp.g_aster.social.form.TopForm;
import jp.g_aster.social.service.EventService;
import jp.g_aster.social.service.StampService;
import jp.g_aster.social.util.SocialUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.cubby.action.ActionClass;
import org.seasar.cubby.action.ActionContext;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Form;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.Redirect;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.User;

@ActionClass
@Path("/")
public class IndexAction {

	private Log log = LogFactory.getLog(this.getClass());

	public EventDto eventDto = new EventDto();

	public Map<String, Object> sessionScope;

	public ActionContext actionContext;

	/**
	 * イベントリスト、
	 */
	public List<EventDto> eventList;

	public List<StampDto> stampList;


	public List<EventDto> memberEventList;

	@Resource
	public EventService socialEventService;

	@Resource
	public StampService stampService;

	public TopForm topForm;

	public HttpServletRequest servletRequest;


	private String getCallbackURL(){
		return this.servletRequest.getScheme()+"://"+
				this.servletRequest.getServerName()+":"+
				this.servletRequest.getServerPort()+
				this.servletRequest.getContextPath()+
				SocialUtil.getCallbackURL();
	}

	public ActionResult index() {

		//認証していない場合は、FBのOAUTHへ
		if (!this.sessionScope.containsKey("user")) {
			log.debug("認証エラーのため、callback");
			sessionScope.put("redirect","/");

			Facebook facebook = new FacebookFactory().getInstance();
			String redirectURL = facebook.getOAuthAuthorizationURL(this.getCallbackURL());
			sessionScope.put("facebook",facebook);
			return new Redirect(redirectURL);
		}

		//facebook情報取得
		User user = (User)this.sessionScope.get("user");
		log.debug("◆email◆="+user.getEmail());
		log.debug("◆name◆="+user.getName());

		topForm =stampService.getStampAndImageList(user.getId());
		for(StampDto stampDto :topForm.getStampList()){
			if(stampDto.getFileId()==MemberImageFile.FILEID_NOIMAGE){
				//TODO ハードコーディングを修正する。
				stampDto.setMemberFileUrl(servletRequest.getContextPath()+"/img/noimage.png");
			}
		}
		//画像が全くない場合は追加する。
		if(topForm.getMemberImageList().isEmpty()){
			MemberImageFileDto dto = new MemberImageFileDto();
			dto.setFileId(0);
			dto.setFileName("noimage.png");
			dto.setImageUrl(servletRequest.getContextPath()+"/img/noimage.png");
			topForm.getMemberImageList().add(dto);
		}
		//自分が保持しているスタンプを取得する。

		return new Forward("index.jsp");
	}

	/**
	 * 説明についてのアクション
	 * @return
	 */
	public ActionResult about() {
		return new Forward("/commmon/about.jsp");
	}

	/**
	 * お問い合わせフォーム
	 * @return
	 */
	public ActionResult inquiry() {
		return new Forward("/commmon/inquiry.jsp");
	}

	/**
	 * 個人情報保護方針
	 * @return
	 */
	public ActionResult privacy() {
		return new Forward("/commmon/privacy.jsp");
	}

	/**
	 * イベント用、スタンプラリーになったら利用する。
	 * @return
	 */
	@Form("eventDto")
	public ActionResult indexEvent() {

		//認証していない場合は、FBのOAUTHへ
		if (!this.sessionScope.containsKey("user")) {
			log.debug("認証エラーのため、callback");
			sessionScope.put("redirect","/");

			Facebook facebook = new FacebookFactory().getInstance();
			String redirectURL = facebook.getOAuthAuthorizationURL(SocialUtil.getCallbackURL());
			sessionScope.put("facebook",facebook);
			return new Redirect(redirectURL);
		}

		//facebook情報取得
		User user = (User)this.sessionScope.get("user");
		log.debug("◆email◆="+user.getEmail());
		log.debug("◆name◆="+user.getName());

		//自分が管理しているイベントを取得する。
		this.eventList =  socialEventService.getSocialEventList(user.getId());

		//自分が参加しているイベントを取得する。
		this.memberEventList = socialEventService.getSocialEventList(user.getId());

		return new Forward("index.jsp");
	}

}