package jp.g_aster.social.logic;

import java.util.List;

import jp.g_aster.social.dto.MemberImageFileDto;

/**
 * 画像ファイルに関するロジックＩＦ
 * @author hiroshi-abe
 *
 */
public interface MemberImageFileLogic {


	List<MemberImageFileDto> getMemberImageFileList(String facebookId);

}
