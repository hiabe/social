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

/**
 * ソーシャルイベントに関するクラス
 * @author hiroshi-abe
 *
 */
@Entity
@Table(name = "event")
public class Event {

	@Id
	@Column(name="event_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;

	@Column(name="fb_id")
	private String facebookId;

	@Column(name="event_name")
	private String eventName;

	@Temporal(TemporalType.DATE)
	@Column(name="event_date_from")
	private Date eventDateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="event_date_to")
	private Date eventDateTo;

	@Column(name="page_url")
	private String pageUrl;

	@Column(name="image_url")
	private String imageUrl;

	@Column(name="qr_filename")
	private String qrFilename;

	@Temporal(TemporalType.DATE)
	@Column(name="expired_date")
	private Date expiredDate;

	@Column(name="place")
	private String place;

	@Column(name="stamp_count")
	private int stampCount;

	@Column(name="member_file_id")
	private int memberFileId;

	@Column(name="description")
	private String description;

	@Column(name="auth_key")
	private String authenticationKey;

	@Column(name="file_id")
	private int fileId;

	@Column(name="del_flg")
	private boolean deleted;

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
	 * @return eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName セットする eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return eventDateFrom
	 */
	public Date getEventDateFrom() {
		return eventDateFrom;
	}

	/**
	 * @param eventDateFrom セットする eventDateFrom
	 */
	public void setEventDateFrom(Date eventDateFrom) {
		this.eventDateFrom = eventDateFrom;
	}

	/**
	 * @return eventDateTo
	 */
	public Date getEventDateTo() {
		return eventDateTo;
	}

	/**
	 * @param eventDateTo セットする eventDateTo
	 */
	public void setEventDateTo(Date eventDateTo) {
		this.eventDateTo = eventDateTo;
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
	 * @return qrFilename
	 */
	public String getQrFilename() {
		return qrFilename;
	}

	/**
	 * @param qrFilename セットする qrFilename
	 */
	public void setQrFilename(String qrFilename) {
		this.qrFilename = qrFilename;
	}

	/**
	 * @return expiredDate
	 */
	public Date getExpiredDate() {
		return expiredDate;
	}

	/**
	 * @param expiredDate セットする expiredDate
	 */
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	/**
	 * @return place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place セットする place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return stampCount
	 */
	public int getStampCount() {
		return stampCount;
	}

	/**
	 * @param stampCount セットする stampCount
	 */
	public void setStampCount(int stampCount) {
		this.stampCount = stampCount;
	}

	/**
	 * @return memberFileId
	 */
	public int getMemberFileId() {
		return memberFileId;
	}

	/**
	 * @param memberFileId セットする memberFileId
	 */
	public void setMemberFileId(int memberFileId) {
		this.memberFileId = memberFileId;
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
	 * @return deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted セットする deleted
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

}
