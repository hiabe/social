/**
 *
 */
package jp.g_aster.social.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;

import jp.g_aster.social.dao.MemberImageFileDao;
import jp.g_aster.social.entity.MemberImageFile;

/**
 * @author hiroshi-abe
 *
 */
public class MemberImageFileDaoImpl implements MemberImageFileDao {

	@Resource(name = "jdbcManager")
	private JdbcManager jdbcManager;

	@Override
	public List<MemberImageFile> findByFacebookId(String facebookId) {
		return jdbcManager.from(MemberImageFile.class).where("facebookId=?",facebookId).getResultList();
	}

	@Override
	public MemberImageFile findByFileId(int fileId) {
		return jdbcManager.from(MemberImageFile.class).where("fileId=?",fileId).getSingleResult();
	}

	@Override
	public void insert(MemberImageFile memberImageFile) {
		jdbcManager.insert(memberImageFile).execute();
	}

}
