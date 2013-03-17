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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.entity.MemberImageFile;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.form.CreateEventForm;
import jp.g_aster.social.form.UpdateEventForm;
import jp.g_aster.social.service.StampService;
import jp.g_aster.social.util.SocialUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.cubby.action.ActionClass;
import org.seasar.cubby.action.ActionContext;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Form;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestParameter;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.User;

@ActionClass
public class StampAction {

	private Log log = LogFactory.getLog(this.getClass());

	public Map<String, Object> sessionScope;

	public ActionContext actionContext;

	@Resource
	public StampService stampService;

	public CreateEventForm createEventForm = new CreateEventForm();

	public UpdateEventForm updateEventForm = new UpdateEventForm();

	public StampDto stampDto = new StampDto();

	public List<EventDto> memberEventList;

	public List<MemberImageFileDto> memberFileList;

	public @RequestParameter String eventId;

	public @RequestParameter String stampId;

	public @RequestParameter String authKey;


	public HttpServletRequest servletRequest;

	private boolean isLogin(){
		return sessionScope.containsKey("user");
	}

	private String getCallbackURL(){
		return this.servletRequest.getScheme()+"://"+
				this.servletRequest.getServerName()+":"+
				this.servletRequest.getServerPort()+
				this.servletRequest.getContextPath()+
				SocialUtil.getCallbackURL();
	}

	/**
	 * QR作成ページを開きます。
	 * @return
	 */
	public ActionResult createStamp() {

		if(!this.isLogin()){
			log.info("◆◆ログインしていないため、ＴＯＰへ戻ります◆◆");
			return new Redirect("/");
		}

		User user = (User)this.sessionScope.get("user");
		//イベントの詳細とスタンプ情報を取得する。
		memberFileList =  stampService.getMemberImageFileList(user.getId());
		if(memberFileList == null){
			memberFileList = new ArrayList<MemberImageFileDto>();
		}
		if(memberFileList.isEmpty()){
			MemberImageFileDto dto = new MemberImageFileDto();
			dto.setFileId(0);
			dto.setFileName("noimage.png");
			dto.setImageUrl("/img/noimage.png");
			memberFileList.add(dto);
		}

		return new Forward("createStamp.jsp");
	}

	/**
	 * スタンプデータを生成します。
	 * @return
	 */
	@Form("stampDto")
	public ActionResult create(){

		if(!this.isLogin()){
			return new Redirect("/");
		}

		//URLに関する情報を取得
		Date sysdate = new Date();
		String md5Stamp = SocialUtil.getMD5String(stampDto.getMessage()+stampDto.getFacebookId()+sysdate.toString());
		User user = (User)sessionScope.get("user");
		stampDto.setAuthKey(md5Stamp);
		stampDto.setFacebookId(user.getId());
		stampDto.setQrFileName(md5Stamp+".jpg");
		stampDto.setPageUrl("/stamp/getStamp?authKey="+md5Stamp);
		stampDto.setImageUrl("/img/stamp/"+stampDto.getQrFileName());


		stampService.makeStamp(stampDto);

		actionContext.getFlashMap().put("notice","登録処理が完了しました。");
		return new Redirect("/");
	}

	/**
	 * スタンプ情報の詳細を取得します。
	 * @return
	 */
	public ActionResult showDetail() {

		if(!this.isLogin()){
			actionContext.getFlashMap().put("error", "タイムアウトが発生したため最初からやり直してください");
			return new Redirect("/");
		}

		try {
			log.debug("◆authenticationKey is "+authKey);
			User user = (User)this.sessionScope.get("user");
			this.stampDto =  stampService.getStamp(authKey);
			if(stampDto.getFileId() == MemberImageFile.FILEID_NOIMAGE){
				stampDto.setMemberFileUrl("/img/noimage.png");
			}
			this.memberFileList = stampService.getMemberImageFileList(user.getId());
			if(this.memberFileList == null){
				memberFileList = new ArrayList<MemberImageFileDto>();
			}
			if(this.memberFileList.isEmpty()){
				MemberImageFileDto dto = new MemberImageFileDto();
				dto.setFileId(0);
				dto.setFileName("noimage.png");
				dto.setImageUrl("/img/noimage.png");
				memberFileList.add(dto);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "不正なデータを受信したため、最初からやり直してください。");
			new Forward("error.jsp");
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "不正なデータを受信したため、最初からやり直してください。");
			new Forward("error.jsp");
		}

		return new Forward("stampDetail.jsp");
	}

	/**
	 * スタンプ用のQRコード表示用ダイアログを開きます。
	 * @return
	 */
	public ActionResult showQRCode() {

		if(!this.isLogin()){
			return new Redirect("/");
		}
		try {
			this.stampDto =  stampService.getStamp(authKey);
			if(stampDto.getFileId() == MemberImageFile.FILEID_NOIMAGE){
				stampDto.setMemberFileUrl("/img/noimage.png");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new Forward("/common/error.jsp");
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			return new Forward("/common/error.jsp");
		}
		return new Forward("/event/viewQRCode.jsp");
	}

	/**
	 * スタンプを獲得する。
	 * @return
	 */
	public ActionResult getStamp() {

		if(!isLogin()){
			log.debug("スタンプ獲得のため、callback");
			Facebook facebook = new FacebookFactory().getInstance();
			sessionScope.put("redirect","/stamp/getStamp?authKey="+this.authKey);
			String redirectURL = facebook.getOAuthAuthorizationURL(this.getCallbackURL());
			sessionScope.put("facebook",facebook);
			return new Redirect(redirectURL);
		}
		User user = (User)this.sessionScope.get("user");
		log.debug("authKey=["+this.authKey+"]");

		try {
			log.debug("★-"+servletRequest.getServerName());
			log.debug("★-"+servletRequest.getServerPort());
			log.debug("★-"+servletRequest.getScheme());

			String httpContext = servletRequest.getScheme()+"://"
								+servletRequest.getServerName()+":"
								+servletRequest.getServerPort()
								+servletRequest.getContextPath();

			stampService.getStampAndPostFacebook(authKey, user,(Facebook)sessionScope.get("facebook"),httpContext);
		} catch (FacebookException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "異常終了しました。");
			return new Forward("/common/error.jsp");
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "データ不整合が発生しました。");
			return new Forward("/common/error.jsp");
		}
		actionContext.getFlashMap().put("notice", "スタンプをＧＥＴしました");

		return new Redirect("/");
	}

	/**
	 * スタンプを更新する。
	 * @return
	 */
	@Form("stampDto")
	public ActionResult update() {
		if(!this.isLogin()){
			return new Redirect("/");
		}
		User user = (User)sessionScope.get("user");
		stampDto.setFacebookId(user.getId());
		stampDto.setModifier(user.getName());
		stampDto.setModified(new Date());
		try {
			stampService.updateStamp(stampDto);
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "データ更新でエラーが発生しました。");
			return new Forward("/common/error.jsp");
		}
		actionContext.getFlashMap().put("notice", "更新処理が完了しました。");

		return new Forward("stampDetail.jsp");
	}


}