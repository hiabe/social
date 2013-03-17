package jp.g_aster.social.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jp.g_aster.social.dto.MemberImageFileDto;

public class SocialUtil {

	/**
	 * 引数より、MD5の文字列を生成します。
	 * @param str
	 * @return
	 */
	public static String getMD5String(String str){
		//MD5の生成
		byte[] encript;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			encript = digest.digest(str.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bytesToHexString(encript);
	}

	private static String bytesToHexString(byte[] fromByte) {

	    StringBuilder hexStrBuilder = new StringBuilder();
	    for (int i = 0; i < fromByte.length; i++) {

	        // 16進数表記で1桁数値だった場合、2桁目を0で埋める
	        if ((fromByte[i] & 0xff) < 0x10) {
	            hexStrBuilder.append("0");
	        }
	        hexStrBuilder.append(Integer.toHexString(0xff & fromByte[i]));
	    }

	    return hexStrBuilder.toString();
	}

//	public static MemberImageFileDto getDefaultMemberImage(){
//		MemberImageFileDto dto = new MemberImageFileDto();
//		dto.setFileId(0);
//		dto.setFileName("noimage.png");
//		dto.setImageUrl(SocialProperties.getProps().getProperty("context_path")+"/img/noimage.png");
//		return dto;
//	}


	public static String getCallbackURL(){
		return SocialProperties.getProps().getProperty("context_path") + SocialProperties.getProps().getProperty("callback_URI");
	}
}
