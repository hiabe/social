package jp.g_aster.social.dao.impl;

import javax.annotation.Resource;

import jp.g_aster.social.dao.EventMemberDao;
import jp.g_aster.social.entity.EventMember;

import org.seasar.extension.jdbc.JdbcManager;

public class EventMemberDaoImpl implements EventMemberDao {

	@Resource(name = "jdbcManager")
	private JdbcManager jdbcManager;


	@Override
	public boolean isEntry(int eventId, String facebookId) {
		return jdbcManager.from(EventMember.class).where("eventId=? and facebookId=?", eventId,facebookId).getCount() > 0;
	}

	@Override
	public void insertEventMember(EventMember eventMember) {
		jdbcManager.insert(eventMember);
	}

}
