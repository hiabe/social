package jp.g_aster.social.service;

import java.util.List;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.form.TopForm;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.User;

/**
 * スタンプに関するサービスを提供する
 * @author hiroshi-abe
 */
public interface StampService {


	/**
	 * スタンプkeyに該当するスタンプを取得します。
	 *
	 * @param authKey
	 * @return
	 * @throws DataNotFoundException
	 */
	StampDto getStamp(String authKey) throws DataNotFoundException;


	/**
	 * ユーザに該当するスタンプ一覧及びファイル一覧を取得します。
	 *
	 * @param id facebookリスト
	 * @return
	 */
	TopForm getStampAndImageList(String facebookId);

	/**
	 * 取得したスタンプ一覧を取得します。
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
	 * スタンプを新規作成します。
	 * @param event
	 */
	void makeStamp(StampDto stampDto);

	/**
	 * スタンプをGETして、facebookへポストします。
	 * ゲットした事をDBへ登録します。（何度でも可）
	 *
	 * @param authKey
	 * @param facebookId
	 * @param facebook
	 */
	StampDto getStampAndPostFacebook(String authKey, User user,Facebook facebook) throws DataNotFoundException,FacebookException;


	/**
	 * スタンプのアクションの更新を行います。
	 * @throws DataNotFoundException
	 */
	void updateStamp(StampDto dto) throws DataNotFoundException;

}
