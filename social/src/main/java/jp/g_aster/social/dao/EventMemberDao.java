/**
 *
 */
package jp.g_aster.social.dao;

import jp.g_aster.social.entity.EventMember;

/**
 * スタンプDAO
 * @author hiroshi-abe
 *
 */
public interface EventMemberDao {

	/**
	 * 引数に該当するデータの存在チェック。
	 * @param eventId
	 * @param facebookId
	 * @return 登録済の場合true
	 */
	boolean isEntry(int eventId,String facebookId);

	/**
	 * イベントを登録します。
	 * @param event
	 */
	void insertEventMember(EventMember eventMember);


}
