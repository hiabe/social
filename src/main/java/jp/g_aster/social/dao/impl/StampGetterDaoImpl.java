/**
 *
 */
package jp.g_aster.social.dao.impl;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;

import jp.g_aster.social.dao.StampGetterDao;
import jp.g_aster.social.entity.StampGetter;

/**
 * @author hiroshi-abe
 *
 */
public class StampGetterDaoImpl implements StampGetterDao {

	@Resource
	private JdbcManager jdbcManager;

	@Override
	public StampGetter findByStampIdAndFacebookId(int stampId, String facebookId) {
		return jdbcManager.from(StampGetter.class).where("stampId=? and facebookId=?",stampId,facebookId).getSingleResult();
	}

	@Override
	public void insertStampGetter(StampGetter stampGetter) {
		jdbcManager.insert(stampGetter).execute();
	}

}
