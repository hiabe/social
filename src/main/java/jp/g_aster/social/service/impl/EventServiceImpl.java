package jp.g_aster.social.service.impl;

import java.util.List;

import javax.annotation.Resource;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.exception.DuplicatedException;
import jp.g_aster.social.logic.EventLogic;
import jp.g_aster.social.logic.EventMemberLogic;
import jp.g_aster.social.logic.MemberImageFileLogic;
import jp.g_aster.social.service.EventService;

/**
 * ソーシャルイベントに関するサービスの実装クラス
 * @author hiroshi-abe
 *
 */
public class EventServiceImpl implements EventService {

	@Resource
	public EventLogic eventLogic;

	@Resource
	public EventMemberLogic eventMemberLogic;

	@Resource
	public MemberImageFileLogic memberImageFileLogic;

	@Override
	public List<EventDto> getSocialEventList(String facebookId) {
		return eventLogic.getSocialEventList(facebookId);
	}

	@Override
	public List<EventDto> getJoinedSocialEventList(String facebookId) {
		return eventLogic.getJoinedSocialEventList(facebookId);
	}

	@Override
	public void makeEvent(EventDto event) {
		// イベントの登録
		eventLogic.makeEvent(event);
	}

	@Override
	public EventDto joinEvent(String authKey, String facebookId) throws DuplicatedException, DataNotFoundException {

		EventDto eventDto = eventLogic.getEvent(authKey);
		if(eventDto==null){
			throw new DataNotFoundException("authkey is ["+authKey+"]");
		}
		if(eventMemberLogic.isEntry(eventDto.getEventId(), facebookId)){
			throw new DuplicatedException("");
		}
		eventMemberLogic.entry(eventDto, facebookId);

		return eventDto;

	}

	@Override
	public EventDto getSocialEvent(int socialEventId) throws DataNotFoundException {
		//ソーシャルイベントの取得
		return eventLogic.getSocialEvent(socialEventId);
	}

	@Override
	public List<MemberImageFileDto> getMemberImageFileList(String facebookId) {
		return memberImageFileLogic.getMemberImageFileList(facebookId);
	}

	@Override
	public StampDto getQRImageUrl(String facebookId, int eventId,int stampId)
			throws DataNotFoundException {
		StampDto dto = eventLogic.getStamp(facebookId, eventId, stampId);
		if(dto==null){
			throw new DataNotFoundException("stamp is not found eventId="+eventId+",stampId="+stampId);
		}
		return dto;
	}

	@Override
	public void updateEvent(EventDto dto) throws DataNotFoundException {
		eventLogic.updateEvent(dto);
	}

}
