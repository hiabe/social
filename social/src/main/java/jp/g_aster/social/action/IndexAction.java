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

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.service.EventService;
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

	public List<EventDto> eventList;

	public List<EventDto> memberEventList;

	@Resource
	public EventService socialEventService;


	@Form("eventDto")
	public ActionResult index() {

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

		actionContext.getFlashMap().put("notice","既にログイン済みです。");

		return new Forward("index.jsp");
	}



//	/*ログイン後の初期処理*/
//	private void loginInit(){
//		//自分が管理者イベント一覧を取得する。
//
//		//TODO 管理者テーブルに管理者情報の登録
//		$me = $this->facebook->api('/me',array('locale'=>'ja_JP'));
//		$social_event_data = $this->SocialEvent->find('all',array('conditions'=>array('fb_id'=>$me['id'])));
//		$this->set('socialEvents',$social_event_data);
//
//		//自分が参加者のイベント一覧を取得する。
//		$this->SocialEventMember->primaryKey = 'social_event_id';//アソシエーションのための暫定
//		$member_event_data = $this->SocialEventMember->find('all',array('conditions'=>array('SocialEventMember.fb_id'=>$me['id'])));
//		$this->SocialEventMember->primaryKey = 'id';//もとに戻す
//		$this->set('memberEvents',$member_event_data);
//
//		$this->set('adminInfo',$me);
//		$this->Session->write('social_id',$me['id']);
//		$this->Session->write('adminInfo',$me);
//	}

}