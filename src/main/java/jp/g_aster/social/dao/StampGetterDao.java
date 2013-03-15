/**
 *
 */
package jp.g_aster.social.dao;

import jp.g_aster.social.entity.StampGetter;

/**
 * スタンプDAO
 * @author hiroshi-abe
 *
 */
public interface StampGetterDao {

	/**
	 * イベントＩＤに該当するデータを取得します。
	 * @param eventId
	 * @return
	 */
	StampGetter findByStampIdAndFacebookId(int stampId,String facebookId);

	/**
	 * イベントを登録します。
	 * @param event
	 */
	void insertStampGetter(StampGetter stampGetter);


}
