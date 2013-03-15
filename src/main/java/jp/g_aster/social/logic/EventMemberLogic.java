package jp.g_aster.social.logic;

import jp.g_aster.social.dto.EventDto;

/*
 * イベント会員に関する
 * @author hiroshi-abe
 *
 */
public interface EventMemberLogic {

	/**
	 * イベントが登録済か判定します。
	 * @param eventId
	 * @param facebookId
	 * @return
	 */
	boolean isEntry(int eventId,String facebookId);

	/**
	 * イベント会員へエントリーします。
	 * @param eventDto
	 * @param facebookId
	 */
	void entry(EventDto eventDto,String facebookId);

}
