package jp.g_aster.social.logic;

import java.util.List;

import jp.g_aster.social.dto.StampDto;

/**
 * イベントに関するサービスを提供する
 * @author hiroshi-abe
 */
public interface MemberStampLogic {


	/**
	 * 獲得したスタンプ一覧を取得します。
	 *
	 * @param id facebookリスト
	 * @return
	 */
	List<StampDto> getStampList(String facebookId);


}
