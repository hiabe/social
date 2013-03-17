package jp.g_aster.social.logic.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import jp.g_aster.social.dao.EventDao;
import jp.g_aster.social.dao.MemberImageFileDao;
import jp.g_aster.social.dao.StampDao;
import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.entity.Event;
import jp.g_aster.social.entity.MemberImageFile;
import jp.g_aster.social.entity.Stamp;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.logic.EventLogic;
import jp.g_aster.social.util.SocialProperties;
import jp.g_aster.social.util.SocialUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.beans.util.BeanUtil;

import com.d_project.qrcode.ErrorCorrectLevel;
import com.d_project.qrcode.QRCode;

public class EventLogicImpl implements EventLogic {

	@Resource
	private EventDao eventDao;

	@Resource
	private StampDao stampDao;

	@Resource
	private MemberImageFileDao memberImageFileDao;

	private Log log = LogFactory.getLog(this.getClass());

	@Override
	public EventDto getSocialEvent(int socialEventId) throws DataNotFoundException {
//		MemberImageFileDto memberImageFileDto =  SocialUtil.getDefaultMemberImage();
		//ソーシャルイベントの取得
		Event event = eventDao.findByPrimary(socialEventId);
		if(event==null){
			throw new DataNotFoundException("event not found id = "+socialEventId);
		}
		EventDto dto = new EventDto();
		BeanUtil.copyProperties(event, dto);

		//スタンプの取得
		List<Stamp> stampList = stampDao.findByEventId(socialEventId);
		for(Stamp stamp:stampList){
			StampDto stampDto = new StampDto();
			BeanUtil.copyProperties(stamp, stampDto);
//			if(StringUtils.isEmpty(stampDto.getMemberFileUrl())){
//				stampDto.setMemberFileUrl(memberImageFileDto.getImageUrl());
//			}
			dto.addStamp(stampDto);
		}

		return dto;
	}


	@Override
	public List<EventDto> getSocialEventList(String facebookId) {

		List<Event> eventList = eventDao.findByFacebookId(facebookId);
		List<EventDto> dtoList = new ArrayList<EventDto>(eventList.size());
		for(Event event:eventList){
			EventDto dto=new EventDto();
			BeanUtil.copyProperties(event, dto);
			//ファイル取得
			if(event.getFileId() > 0){
				MemberImageFile memberImageFile = memberImageFileDao.findByFileId(event.getFileId());
				dto.setMemberFileUrl(memberImageFile.getImageUrl());
			}else{
//				MemberImageFileDto imageFileDto = SocialUtil.getDefaultMemberImage();
//				dto.setMemberFileUrl(imageFileDto.getImageUrl());
			}
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public List<EventDto> getJoinedSocialEventList(String facebookId) {
		List<Event> eventList = eventDao.findByFacebookId(facebookId);
		List<EventDto> dtoList = new ArrayList<EventDto>(eventList.size());
		for(Event event:eventList){
			EventDto dto=new EventDto();
			BeanUtil.copyProperties(event, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public void makeEvent(EventDto eventDto) {

		String contextPath = SocialProperties.getProps().getProperty("context_path");

		Date sysdate = new Date();
		String md5Event = SocialUtil.getMD5String(eventDto.getEventName()+eventDto.getFacebookId()+sysdate.toString());
		String qrEventFileName = md5Event+".jpg";
		String eventUrl = contextPath +"/event/entry?authkey="+md5Event;

		log.debug(eventUrl);

		//イベント用QRコードファイルの生成
		makeQRFile(eventUrl,new File(SocialProperties.getProps().getProperty("qrcode_dir")+"/event/"+qrEventFileName));

		//イベント頁の生成(QRの引数で認証する頁にする）
		//ＤＢへのイベントの登録
		Event event = new Event();
		BeanUtil.copyProperties(eventDto, event);

		event.setPageUrl(eventUrl);
		event.setCreator(this.getClass().getName());
		event.setModifier(this.getClass().getName());
		event.setQrFilename(qrEventFileName);
		event.setAuthenticationKey(md5Event);
		event.setImageUrl(contextPath+"/img/event/"+qrEventFileName);
		event.setExpiredDate(DateUtils.addMonths(new Date(), 1));
		event.setCreator(eventDto.getFacebookId());
		event.setCreated(sysdate);
		event.setModifier(eventDto.getFacebookId());
		event.setModified(sysdate);

		eventDao.insertEvent(event);
		log.debug("eventID="+event.getEventId());

		for(int stampNo=1;stampNo <= event.getStampCount();stampNo++){

			//スタンプファイル生成
			String md5Stamp = SocialUtil.getMD5String(""+eventDto.getEventId()+stampNo);
			String qrStampFileName = md5Stamp+".jpg";

			String stampurl = contextPath + "/event/getstamp?authkey="+md5Stamp;

			//イベント用QRコードファイルの生成
			makeQRFile(stampurl,new File(SocialProperties.getProps().getProperty("qrcode_dir")+"/stamp/"+md5Stamp+".jpg"));

			//スタンプ用データ登録
			Stamp stamp = new Stamp();
			BeanUtil.copyProperties(event, stamp);
			stamp.setCaption("スタンプ"+stampNo);
			stamp.setMessage(stamp.getCaption()+"を取得しました。");
			stamp.setPostUrl("http://www.g-aster.jp");
			stamp.setEventId(event.getEventId());
			stamp.setFileId(0);

			stamp.setStampNo(stampNo);
			stamp.setQrFileName(qrStampFileName);
			stamp.setAuthKey(md5Stamp);
			stamp.setImageUrl(contextPath+"/img/stamp/"+qrStampFileName);

			stamp.setPageUrl(stampurl);
			stamp.setCreator(eventDto.getFacebookId());
			stamp.setCreated(sysdate);
			stamp.setModifier(eventDto.getFacebookId());
			stamp.setModified(sysdate);

			stampDao.insertStamp(stamp);

		}

	}




	/**
	 * QRコードファイルを生成します。
	 * @param url
	 * @param alt
	 * @param fileName
	 */
	private void makeQRFile(String url,File fileName){
		log.debug("★ＵＲＬ is★"+url);
		log.debug("★fileName is★"+fileName);
		QRCode qrCode = QRCode.getMinimumQRCode(url, ErrorCorrectLevel.H);
//		QRCode qrCode = new QRCode();
//		qrCode.addData(url, Mode.MODE_ALPHA_NUM);
//		qrCode.setErrorCorrectLevel(ErrorCorrectLevel.H);
//		qrCode.setTypeNumber(10);
		qrCode.make();
		try {
			BufferedImage image = qrCode.createImage(10, 0);
			ImageIO.write(image, "jpg", fileName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public EventDto getEvent(String authKey) {
		//authkeyを条件に、イベント情報を取得
		EventDto eventDto = eventDao.findByAuthKey(authKey);
//		if(StringUtils.isEmpty(eventDto.getMemberFileUrl())){
//			MemberImageFileDto memberImageFileDto = SocialUtil.getDefaultMemberImage();
//			eventDto.setMemberFileUrl(memberImageFileDto.getImageUrl());
//		}

		return eventDto;

	}


	@Override
	public StampDto getStamp(String facebookId, int eventId, int stampId) {
		return stampDao.findStampAndMemberFileByStampId(eventId, stampId);
	}


	@Override
	public void updateEvent(EventDto eventDto) throws DataNotFoundException {


		//TODO イベントを更新する。（必要か検討中）


		for(StampDto stampDto : eventDto.getStampList()){
			//スタンプを取得
			StampDto fromDb = stampDao.findStampAndMemberFileByStampId(stampDto.getEventId(), stampDto.getStampId());
			Stamp stamp = new Stamp();
			BeanUtil.copyProperties(fromDb, stamp);

			//スタンプを更新
			stamp.setMessage(stampDto.getMessage());
			stamp.setPageUrl(stampDto.getPageUrl());
			stamp.setCaption(stampDto.getCaption());

			if(0 ==stampDao.updateStampByPrimary(stamp)){
				throw new DataNotFoundException("stampId="+stampDto.getStampId());
			}

		}
	}


}
