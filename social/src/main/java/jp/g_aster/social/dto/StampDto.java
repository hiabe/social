package jp.g_aster.social.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class StampDto {

	private int stampId;

	private int eventId;

	private String facebookId;

	private int stampNo;

	private String qrFileName;

	private String pageUrl;

	private String imageUrl;

	private String caption;

	private String postUrl;

	private String message;

	private String authenticationKey;

	private int fileId;

	private String creator;

	private Date created;

	private String modifier;

	private Date modified;

	private String memberFileUrl;


	/**
	 * @return stampId
	 */
	public int getStampId() {
		return stampId;
	}

	/**
	 * @param stampId セットする stampId
	 */
	public void setStampId(int stampId) {
		this.stampId = stampId;
	}

	/**
	 * @return eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId セットする eventId
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return facebookId
	 */
	public String getFacebookId() {
		return facebookId;
	}

	/**
	 * @param facebookId セットする facebookId
	 */
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	/**
	 * @return stampNo
	 */
	public int getStampNo() {
		return stampNo;
	}

	/**
	 * @param stampNo セットする stampNo
	 */
	public void setStampNo(int stampNo) {
		this.stampNo = stampNo;
	}

	/**
	 * @return qrFileName
	 */
	public String getQrFileName() {
		return qrFileName;
	}

	/**
	 * @param qrFileName セットする qrFileName
	 */
	public void setQrFileName(String qrFileName) {
		this.qrFileName = qrFileName;
	}

	/**
	 * @return pageUrl
	 */
	public String getPageUrl() {
		return pageUrl;
	}

	/**
	 * @param pageUrl セットする pageUrl
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	/**
	 * @return imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl セットする imageUrl
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	/**
	 * @return authenticationKey
	 */
	public String getAuthenticationKey() {
		return authenticationKey;
	}

	/**
	 * @param authenticationKey セットする authenticationKey
	 */
	public void setAuthenticationKey(String authenticationKey) {
		this.authenticationKey = authenticationKey;
	}

	/**
	 * @return fileId
	 */
	public int getFileId() {
		return fileId;
	}

	/**
	 * @param fileId セットする fileId
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator セットする creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created セットする created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return modifier
	 */
	public String getModifier() {
		return modifier;
	}

	/**
	 * @param modifier セットする modifier
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	/**
	 * @return modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified セットする modified
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return memberFileUrl
	 */
	public String getMemberFileUrl() {
		return memberFileUrl;
	}

	/**
	 * @param memberFileUrl セットする memberFileUrl
	 */
	public void setMemberFileUrl(String memberFileUrl) {
		this.memberFileUrl = memberFileUrl;
	}



	/**
	 * @return caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption セットする caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return postUrl
	 */
	public String getPostUrl() {
		return postUrl;
	}

	/**
	 * @param postUrl セットする postUrl
	 */
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}

}
