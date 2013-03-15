package jp.g_aster.social.service;

import java.util.List;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.exception.DuplicatedException;

/**
 * イベントに関するサービスを提供する
 * @author hiroshi-abe
 */
public interface EventService {


	/**
	 * イベントＩＤに該当するイベントを取得します。
	 *
	 * @param id イベントID
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
	 * @param facebookId facebookリスト
	 * @return
	 */
	List<EventDto> getJoinedSocialEventList(String facebookId);

	/**
	 * 自分が登録した画像一覧を取得します。
	 *
	 * @param facebookId
	 * @return
	 */
	List<MemberImageFileDto> getMemberImageFileList(String facebookId);


	/**
	 * イベントを新規作成します。
	 * @param event
	 */
	void makeEvent(EventDto event);

	/**
	 * イベントに参加登録します。
	 *
	 * @param eventId
	 * @param facebookId
	 */
	EventDto joinEvent(String authKey, String facebookId) throws DataNotFoundException, DuplicatedException;

	/**
	 * ファイルIDに該当するURLを取得します。
	 *
	 * @param stampId
	 * @param eventId
	 * @return
	 * @throws DataNotFoundException
	 */
	StampDto  getQRImageUrl(String facebookId,int eventId,int stampId) throws DataNotFoundException;


	/**
	 * イベント（包含するスタンプ）の更新を行います。
	 * @throws DataNotFoundException
	 */
	void updateEvent(EventDto dto) throws DataNotFoundException;

}
