package jp.g_aster.social.dao;

import java.util.List;

import jp.g_aster.social.entity.MemberImageFile;

public interface MemberImageFileDao {

	/**
	 * IDに該当するデータを取得します。
	 * @param id
	 * @return
	 */
	List<MemberImageFile> findByFacebookId(String facebookId);

	/**
	 * IDに該当するデータを取得します。
	 * @param id
	 * @return
	 */
	MemberImageFile findByFileId(int fileId);

	/**
	 * 登録を実施します。
	 *
	 * @param memberImageFile
	 */
	void insert(MemberImageFile memberImageFile);

}
