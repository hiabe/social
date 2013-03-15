/**
 *
 */
package jp.g_aster.social.service.impl;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;

import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.logic.MemberImageFileLogic;
import jp.g_aster.social.service.FileUploadService;
import jp.g_aster.social.util.SocialProperties;

import org.apache.commons.fileupload.FileItem;

import facebook4j.User;

/**
 * @author hiroshi-abe
 *
 */
public class FileUploadServiceImpl implements FileUploadService {

	@Resource
	private MemberImageFileLogic memberImageFileLogic;

	@Override
	public void upload(FileItem item, File file, User user) {
		Date sysdate = new Date();
		MemberImageFileDto dto = new MemberImageFileDto();
		dto.setFacebookId(user.getId());
		dto.setFileName(item.getName());
		dto.setImageUrl(SocialProperties.getProps().getProperty("context_path")+"/img/stamp/"+file.getName());
		dto.setCreated(sysdate);
		dto.setModified(sysdate);
		dto.setCreator(user.getName());
		dto.setModifier(user.getName());
		memberImageFileLogic.insertImageFileData(dto);
	}

}
