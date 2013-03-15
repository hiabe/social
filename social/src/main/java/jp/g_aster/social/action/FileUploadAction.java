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

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import jp.g_aster.social.service.FileUploadService;
import jp.g_aster.social.util.SocialProperties;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.cubby.action.ActionClass;
import org.seasar.cubby.action.ActionContext;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestParameter;
import org.seasar.cubby.action.Validation;
import org.seasar.cubby.validator.DefaultValidationRules;
import org.seasar.cubby.validator.ValidationRules;
import org.seasar.cubby.validator.validators.FileRegexpValidator;

import facebook4j.User;

@ActionClass
public class FileUploadAction {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private FileUploadService fileUploadService;

	public ActionContext actionContext;

	public Map<String, Object> sessionScope;


	private boolean isLogin(){
		return sessionScope.containsKey("user");
	}

    public ValidationRules validation = new DefaultValidationRules() {
        public void initialize() {
            // (?i)を付けることで大文字小文字を区別しないという意味
            // 正規表現に関しての詳細な情報はjava.util.PatternクラスのJavaDocを参照してください。
            add("imageFile", new FileRegexpValidator(".+\\.(?i)(png|jpg)"));
        }
    };
    @RequestParameter
	public FileItem imageFile;

	@Validation(rules = "validation", errorPage = "index.jsp")
	public ActionResult upload() {

		if(!this.isLogin()){
			actionContext.getFlashMap().put("error", "タイムアウトが発生しました。最初からやり直してください");
			return new  Redirect("/");
		}
		log.debug("imageFileName="+imageFile.getName());
		//ファイルをアップロードする。
		File file = new File(SocialProperties.getProps().getProperty("qrcode_dir")+File.separator+"stamp"+File.separator+imageFile.getName());
		//画像DBへ登録する。：」：＋｝ｚ
		try {
			imageFile.write(file);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			actionContext.getFlashMap().put("error", "エラーが発生しました");
			return new Forward("/common/error.jsp");
		}
		fileUploadService.upload(imageFile, file, (User)this.sessionScope.get("user"));

		actionContext.getFlashMap().put("notice", "画像登録が完了しました。");
	    return new Redirect("/");
	}
}