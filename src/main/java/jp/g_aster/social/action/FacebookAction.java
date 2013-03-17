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

import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.cubby.action.ActionClass;
import org.seasar.cubby.action.ActionContext;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestParameter;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Reading;

@ActionClass
public class FacebookAction {

	private final Log log = LogFactory.getLog(this.getClass());

	public ActionContext actionContext;

	public Map<String, Object> sessionScope;

	@RequestParameter
	public String code;

	/**
	 * facebookからのcallback
	 * @return
	 */
	public ActionResult callback() {

		log.debug("code="+this.code);
		Facebook facebook = (Facebook)sessionScope.get("facebook");
		try {
			facebook.getOAuthAccessToken(this.code);
			log.debug("accessToken()="+facebook.getOAuthAccessToken());
			log.debug("email="+facebook.getMe(new Reading().locale(Locale.JAPAN)).getEmail());
			log.debug("◆redirect◆="+(String)sessionScope.get("redirect"));
			sessionScope.put("user", facebook.getMe(new Reading().locale(facebook.getMe().getLocale())));
		} catch (FacebookException e) {
			log.error(e);
			e.printStackTrace();
			return new Forward("error.jsp");
		}
		return new Redirect((String)sessionScope.get("redirect"));
	}

}