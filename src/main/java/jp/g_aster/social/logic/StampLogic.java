package jp.g_aster.social.logic;

import java.util.List;

import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.dto.StampGetterDto;
import jp.g_aster.social.exception.DataNotFoundException;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.User;

/**
 * イベントに関するサービスを提供する
 * @author hiroshi-abe
 */
public interface StampLogic {


	/**
	 * ユーザに該当するスタンプ一覧を取得します。
	 *
	 * @param id facebookリスト
	 * @return
	 */
	List<StampDto> getStampList(String facebookId);


	/**
	 * スタンプIDに該当するデータを取得します。
	 *
	 * @param socialEventId
	 * @return
	 */
	StampDto getStamp(int stampId) throws DataNotFoundException;

	/**
	 * スタンプを作成します。
	 * @param stamp
	 */
	void makeStamp(StampDto stampDto);


	/**
	 * 認証keyよりスタンプ情報を取得します。
	 *
	 * @param authKey
	 * @return
	 */
	StampDto getStamp(String authKey);


	/**
	 * スタンプID、facebookUserIdにてスタンプ獲得済であるか存在チェックを実施。
	 *
	 * @param authKey
	 * @return
	 */
	boolean isStampGetter(int stampId,String facebookId);


	/**
	 * スタンプを獲得します。
	 *
	 * @param stampGetterDto
	 */
	void getStamp(StampGetterDto stampGetterDto);


	/**
	 * スタンプの更新を実施します。
	 * @param stampDto
	 */
	void updateStamp(StampDto stampDto) throws DataNotFoundException;


	/**
	 * Facebookへのポストを行います。
	 *
	 * @param user
	 * @param stampDto
	 */
	void postToFacebook(User user,StampDto stampDto,Facebook facebook) throws FacebookException;

}
