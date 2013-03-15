/**
 *
 */
package jp.g_aster.social.logic.impl;

import javax.annotation.Resource;

import jp.g_aster.social.dao.EventMemberDao;
import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.entity.EventMember;
import jp.g_aster.social.logic.EventMemberLogic;

/**
 * @author hiroshi-abe
 *
 */
public class EventMemberLogicImpl implements EventMemberLogic {

	@Resource
	public EventMemberDao eventMemberDao;

	@Override
	public boolean isEntry(int eventId, String facebookId) {
		return eventMemberDao.isEntry(eventId, facebookId);
	}

	@Override
	public void entry(EventDto eventDto, String facebookId) {
		EventMember eventMember = new EventMember();
		eventMemberDao.insertEventMember(eventMember);
	}

}
