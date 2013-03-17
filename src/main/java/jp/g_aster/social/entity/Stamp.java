/*
 * copyright G-Aster.ltd All Rights Reserved.
 */
package jp.g_aster.social.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * イベントスタンプエンティティ
 * @author hiroshi-abe
 *
 */
@Entity
@Table(name = "stamp")
public class Stamp {

	@Id
	@Column(name="stamp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stampId;

	@Column(name="event_id")
	private int eventId;

	@Column(name="fb_id")
	private String facebookId;

	@Column(name="stamp_no")
	private int stampNo;

	@Column(name="qr_filename")
	private String qrFileName;

	@Column(name="page_url")
	private String pageUrl;

	@Column(name="image_url")
	private String imageUrl;

	@Column(name="link_name")
	private String linkName;


	@Column(name="caption")
	private String caption;

	@Column(name="post_url")
	private String postUrl;

	@Column(name="message")
	private String message;

	@Column(name="description")
	private String description;

	@Column(name="auth_key")
	private String authKey;

	@Column(name="file_id")
	private int fileId;

	@Column(name="creator")
	private String creator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created")
	private Date created;

	@Column(name="modifier")
	private String modifier;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified")
	private Date modified;



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
	 * @return linkName
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * @param linkName セットする linkName
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
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

	/**
	 * @return authKey
	 */
	public String getAuthKey() {
		return authKey;
	}

	/**
	 * @param authKey セットする authKey
	 */
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
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
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}


}
