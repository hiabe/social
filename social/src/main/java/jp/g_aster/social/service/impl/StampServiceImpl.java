/**
 *
 */
package jp.g_aster.social.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import jp.g_aster.social.dto.EventDto;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.dto.StampGetterDto;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.form.TopForm;
import jp.g_aster.social.logic.EventMemberLogic;
import jp.g_aster.social.logic.MemberImageFileLogic;
import jp.g_aster.social.logic.StampLogic;
import jp.g_aster.social.service.StampService;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.User;

/**
 * @author hiroshi-abe
 *
 */
public class StampServiceImpl implements StampService {


	@Resource
	private StampLogic stampLogic;

	@Resource
	private EventMemberLogic eventMemberLogic;

	@Resource
	private MemberImageFileLogic memberImageFileLogic;


	@Override
	public List<EventDto> getJoinedSocialEventList(String facebookId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<MemberImageFileDto> getMemberImageFileList(String facebookId) {
		return memberImageFileLogic.getMemberImageFileList(facebookId);
	}

	@Override
	public void makeStamp(StampDto stampDto) {
		stampLogic.makeStamp(stampDto);
	}




	/* (非 Javadoc)
	 * @see jp.g_aster.social.service.StampService#updateStamp(jp.g_aster.social.dto.StampDto)
	 */
	@Override
	public void updateStamp(StampDto dto) throws DataNotFoundException {
		stampLogic.updateStamp(dto);
	}

	@Override
	public TopForm getStampAndImageList(String facebookId) {
		//スタンプ一覧を取得する
		TopForm topForm = new TopForm();
		topForm.setStampList(stampLogic.getStampList(facebookId));
		topForm.setMemberImageList(memberImageFileLogic.getMemberImageFileList(facebookId));

		return topForm;
	}

	@Override
	public StampDto getStamp(String authKey) throws DataNotFoundException {
		return stampLogic.getStamp(authKey);
	}

	@Override
	public StampDto getStampAndPostFacebook(String authKey, User user,Facebook facebook)
		throws DataNotFoundException, FacebookException {
		//authkeyよりスタンプ情報を取得
		StampDto stampDto = stampLogic.getStamp(authKey);
		if(stampDto==null){
			throw new DataNotFoundException("stamp was not found. authkey is "+authKey);
		}
		//スタンプゲッターの存在チェック、該当データがなければ登録
		if(!stampLogic.isStampGetter(stampDto.getStampId(), user.getId())){
			Date sysDate = new Date();
			StampGetterDto stampGetterDto = new StampGetterDto();
			stampGetterDto.setStampId(stampDto.getStampId());
			stampGetterDto.setFacebookId(user.getId());
			stampGetterDto.setGetDateTime(sysDate);
			stampGetterDto.setCreated(sysDate);
			stampGetterDto.setCreator(user.getName());
			stampGetterDto.setModifier(user.getName());
			stampGetterDto.setModified(sysDate);

			stampLogic.getStamp(stampGetterDto);
		}

		//Facebookeへポスト
		stampLogic.postToFacebook(user, stampDto,facebook);
		return stampDto;
	}

}
