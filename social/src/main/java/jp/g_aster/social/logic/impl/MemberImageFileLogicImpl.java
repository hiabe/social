/**
 *
 */
package jp.g_aster.social.logic.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import jp.g_aster.social.dao.MemberImageFileDao;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.entity.MemberImageFile;
import jp.g_aster.social.logic.MemberImageFileLogic;
import jp.g_aster.social.util.SocialUtil;

import org.seasar.framework.beans.util.BeanUtil;

/**
 * @author hiroshi-abe
 *
 */
public class MemberImageFileLogicImpl implements MemberImageFileLogic {

	@Resource
	public MemberImageFileDao memberImageFileDao;

	@Override
	public List<MemberImageFileDto> getMemberImageFileList(String facebookId) {
		List<MemberImageFile> fileList = memberImageFileDao.findByFacebookId(facebookId);

		List<MemberImageFileDto> dtoList = new ArrayList<MemberImageFileDto>();
		dtoList.add(SocialUtil.getDefaultMemberImage());

		for (MemberImageFile file: fileList){
			MemberImageFileDto imageFileDto = new MemberImageFileDto();
			BeanUtil.copyProperties(file, imageFileDto);
			dtoList.add(imageFileDto);
		}
		return dtoList;
	}

	@Override
	public void insertImageFileData(MemberImageFileDto memberImageFileDto) {
		MemberImageFile memberImageFile = new MemberImageFile();
		BeanUtil.copyProperties(memberImageFileDto, memberImageFile);
		memberImageFileDao.insert(memberImageFile);
	}

}
