package jp.g_aster.social.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import jp.g_aster.social.dao.StampDao;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.entity.Stamp;

import org.seasar.extension.jdbc.JdbcManager;

public class StampDaoImpl implements StampDao {


	@Resource(name = "jdbcManager")
	private JdbcManager jdbcManager;

	@Override
	public List<Stamp> findByEventId(int eventId) {
		return jdbcManager.from(Stamp.class).where("event_id=?",eventId).getResultList();
	}

	@Override
	public void insertStamp(Stamp stamp) {
		jdbcManager.insert(stamp).execute();
	}

	private String sqlFindStampAndMemberFileList =
		"select s.*,mf.image_url as member_file_url from stamp s left join member_img_file mf on s.file_id = mf.file_id "+
		"where s.event_id = ?";


	@Override
	public List<StampDto> findStampAndMemberFileByEventId(int eventId) {
		return jdbcManager.selectBySql(StampDto.class,sqlFindStampAndMemberFileList,eventId).getResultList();
	}


	private String sqlFindStampAndMemberFile =
		"select s.*,mf.image_url as member_file_url from stamp s left join member_img_file mf on s.file_id = mf.file_id "+
		"where s.event_id = ? and s.stamp_id=? ";


	@Override
	public StampDto findStampAndMemberFileByStampId(int eventId, int stampId) {
		return jdbcManager.selectBySql(StampDto.class,sqlFindStampAndMemberFile,eventId,stampId).getSingleResult();
	}

	@Override
	public int updateStampByPrimary(Stamp stamp) {
		return jdbcManager
				.update(stamp)
				.excludes("created","creator","qrFileName","pageUrl","imageUrl")
				.execute();
	}

	private String sqlFindStampAndMemberFileByFacebookId =
		"select s.*,mf.image_url as member_file_url from stamp s left join member_img_file mf on s.file_id = mf.file_id "+
		"where s.fb_id = ?";

	@Override
	public List<StampDto> findStampAndMemberFileByFacebookId(String facebookId) {
		return jdbcManager.selectBySql(StampDto.class,sqlFindStampAndMemberFileByFacebookId,facebookId).getResultList();
	}

	private String sqlFindByAuthKey =
		"select s.*,mf.image_url as member_file_url from stamp s left join member_img_file mf on s.file_id = mf.file_id "+
		"where s.auth_key = ?";

	@Override
	public StampDto findByAuthKey(String authKey) {
		return jdbcManager.selectBySql(StampDto.class,sqlFindByAuthKey,authKey).getSingleResult();
	}

}
