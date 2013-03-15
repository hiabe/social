/**
 *
 */
package jp.g_aster.social.dao;

import java.util.List;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.entity.Event;

/**
 * ソーシャルイベントDAO
 * @author hiroshi-abe
 *
 */
public interface EventDao {

	/**
	 * IDに該当するデータを取得します。
	 * @param id
	 * @return
	 */
	Event findByPrimary(int id);


	/**
	 * ソーシャルイベントに該当するデータを取得します。
	 * @param facebookId
	 * @return
	 */
	List<Event> findByFacebookId(String facebookId);

	/**
	 * social_event_membersのfb_idに該当するデータを取得します。
	 * @param facebookId
	 * @return
	 */
	List<Event> findEventMemberByFacebookId(String facebookId);


	/**
	 * イベントを登録します。
	 * @param event
	 */
	void insertEvent(Event event);


	/**
	 * 認証keyに該当するイベントデータを取得します。
	 * @param id
	 * @return
	 */
	EventDto findByAuthKey(String authKey);

}
