package jp.g_aster.social.logic.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import jp.g_aster.social.dao.StampDao;
import jp.g_aster.social.dao.StampGetterDao;
import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;
import jp.g_aster.social.dto.StampGetterDto;
import jp.g_aster.social.entity.MemberImageFile;
import jp.g_aster.social.entity.Stamp;
import jp.g_aster.social.entity.StampGetter;
import jp.g_aster.social.exception.DataNotFoundException;
import jp.g_aster.social.logic.StampLogic;
import jp.g_aster.social.util.SocialProperties;
import jp.g_aster.social.util.SocialUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.beans.util.BeanUtil;

import com.d_project.qrcode.ErrorCorrectLevel;
import com.d_project.qrcode.QRCode;
import com.google.gson.Gson;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.User;

/**
 *
 * @author hiroshi-abe
 *
 */
public class StampLogicImpl implements StampLogic {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private StampDao stampDao;

	@Resource
	private StampGetterDao stampGetterDao;


	@Override
	public List<StampDto> getStampList(String facebookId) {
		List<StampDto> stampDtoList =  stampDao.findStampAndMemberFileByFacebookId(facebookId);
		MemberImageFileDto imageFileDto = SocialUtil.getDefaultMemberImage();

		for(StampDto stampDto:stampDtoList){
			log.debug(stampDto.toString());
			//ファイル取得
			if(stampDto.getFileId() == MemberImageFile.FILEID_NOIMAGE){
				stampDto.setMemberFileUrl(imageFileDto.getImageUrl());
			}
		}
		return stampDtoList;

	}





	/**
	 * QRコードファイルを生成します。
	 * @param url
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
	public StampDto getStamp(int stampId) throws DataNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void makeStamp(StampDto stampDto) {

		Date sysdate = new Date();

		//スタンプ用QRコードファイル生成
		makeQRFile(stampDto.getPageUrl(),new File(SocialProperties.getProps().getProperty("qrcode_dir")+"/stamp/"+stampDto.getQrFileName()));

		//スタンプ用データ登録
		Stamp stamp = new Stamp();
		BeanUtil.copyProperties(stampDto, stamp);

		stamp.setEventId(0);//とりあえず簡易版では不要のため

		//TODO スタンプＮＯの取得
		stamp.setStampNo(0);

		stamp.setCreator(stampDto.getFacebookId());
		stamp.setCreated(sysdate);
		stamp.setModifier(stampDto.getFacebookId());
		stamp.setModified(sysdate);

		stampDao.insertStamp(stamp);
	}

	@Override
	public StampDto getStamp(String authKey) {
		StampDto dto =stampDao.findByAuthKey(authKey);
		if(dto.getFileId()==MemberImageFile.FILEID_NOIMAGE){
			dto.setMemberFileUrl(SocialUtil.getDefaultMemberImage().getImageUrl());
		}
		return dto;
	}

	@Override
	public void updateStamp(StampDto stampDto) throws DataNotFoundException {
		//TODO セキュリティのために認証keyにて取得する。
		Stamp stamp = new Stamp();
		BeanUtil.copyProperties(stampDto, stamp);
		if (0 ==stampDao.updateStampByPrimary(stamp)){
			throw new DataNotFoundException("stamp data not found stamp_id="+stamp.getStampId());
		}

	}

	@Override
	public void postToFacebook(User user, StampDto stampDto,Facebook facebook) throws FacebookException {
		//facebookへポストする。
		PostUpdate post;
		Post.Action action = new Post.Action(){
			private Gson gson = new Gson();
			public String getLink(){
				Map<String,String> map= new HashMap<String,String>();
				map.put("link", "http://www.g-aster.jp");
				return gson.toJson(map);
			}
			public String getName(){
				Map<String,String> map= new HashMap<String,String>();
				map.put("name", "G-aster.ltd");
				return gson.toJson(map);
			}

		};
		List<Post.Action> actionList = new ArrayList<Post.Action>();
		actionList.add(action);
		try{
			if(stampDto.getPageUrl().startsWith("http://localhost")){
				post = new PostUpdate(new URL("http://www.g-aster.jp"));
			}else{
				post = new PostUpdate(new URL(stampDto.getPageUrl()));
			}
			log.debug("◆◆link="+action.getLink());
			log.debug("◆◆name="+action.getName());
//			Gson gson = new Gson();
			post.picture(new URL(stampDto.getMemberFileUrl()))
			.name("名前")
			.message(user.getName()+"が"+stampDto.getMessage())
			.caption(stampDto.getCaption())
			.description("説明文")
//			.actions(actionList)
			;
			facebook.postFeed(post);
		}catch(MalformedURLException e){
				e.printStackTrace();
				throw new IllegalArgumentException(e);
			}
	}


	@Override
	public boolean isStampGetter(int stampId, String facebookId) {
		StampGetter getter = stampGetterDao.findByStampIdAndFacebookId(stampId, facebookId);
		return getter != null;
	}


	@Override
	public void getStamp(StampGetterDto stampGetterDto) {
		StampGetter stampGetter = new StampGetter();
		BeanUtil.copyProperties(stampGetterDto, stampGetter);
		stampGetterDao.insertStampGetter(stampGetter);
	}

}
