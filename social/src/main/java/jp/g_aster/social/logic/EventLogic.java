package jp.g_aster.social.logic;

import java.util.List;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.exception.DataNotFoundException;

/**
 * イベントに関するサービスを提供する
 * @author hiroshi-abe
 */
public interface EventLogic {


	/**
	 * イベントIDに該当するデータを取得します。
	 *
	 * @param socialEventId
	 * @return
	 */
	EventDto getSocialEvent(int socialEventId) throws DataNotFoundException;


	/**
	 * ユーザに該当するイベント一覧を取得します。
	 *
	 * @param id facebookリスト
	 * @return
	 */
	List<EventDto> getSocialEventList(String facebookId);


	/**
	 * 参加中のイベント一覧を取得します。
	 *
	 * @param id facebookリスト
	 * @return
	 */
	List<EventDto> getJoinedSocialEventList(String facebookId);

	/**
	 * イベントを作成します。
	 * @param event
	 */
	void makeEvent(EventDto event);


	/**
	 * イベント情報を取得します。
	 * @param eventId
	 * @param facebookId
	 */
	EventDto getEvent(String authKey);

	/**
	 * @param facebookId
	 * @param eventId
	 * @param stampId
	 * @return
	 */
	StampDto getStamp(String facebookId,int eventId,int stampId);

	/**
	 * イベントの更新を実施します。
	 * @param eventDto
	 */
	void updateEvent(EventDto eventDto) throws DataNotFoundException;

}
