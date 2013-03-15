package jp.g_aster.social.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import jp.g_aster.social.dao.EventDao;
import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.entity.Event;

import org.seasar.extension.jdbc.JdbcManager;

public class EventDaoImpl implements EventDao {

	@Resource(name = "jdbcManager")
	private JdbcManager jdbcManager;


	@Override
	public List<Event> findByFacebookId(String facebookId) {
		return jdbcManager.from(Event.class).where("fb_id=?",facebookId).getResultList();
	}

	private String sqlFindSocialEventMember =
		"select e.* from event e inner join event_member em on e.event_id = em.event_id "+
		"where em.fb_id = ?";

	@Override
	public List<Event> findEventMemberByFacebookId(String facebookId) {
		return jdbcManager.selectBySql(Event.class,sqlFindSocialEventMember,facebookId).getResultList();
	}

	@Override
	public void insertEvent(Event event) {
		jdbcManager.insert(event).execute();
	}

	@Override
	public Event findByPrimary(int id) {
		return jdbcManager.from(Event.class).where("event_id=?", id).getSingleResult();
	}


	private String sqlFindByAuthKey =
		"select e.* ,mf.file_name as member_file_url from event e left outer join member_img_file mf on e.file_id = mf.file_id "+
		"where e.auth_key = ?";

	@Override
	public EventDto findByAuthKey(String authKey) {
		return jdbcManager.selectBySql(EventDto.class, sqlFindByAuthKey, authKey).getSingleResult();
	}

}
