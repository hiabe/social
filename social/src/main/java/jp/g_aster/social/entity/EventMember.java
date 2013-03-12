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
@Table(name = "event_member")
public class EventMember {

	@Id
	@Column(name="event_member_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long eventMemberId;

	@Column(name="admin_fb_id")
	private long adminFacebookId;

	@Column(name="social_event_id")
	private long socialEventId;

	@Column(name="fb_id")
	private String facebookId;

	@Temporal(TemporalType.TIME)
	@Column(name="entry_date_time")
	private Date entryDateTime;

	@Temporal(TemporalType.TIME)
	@Column(name="cancel_date_time")
	private Date cancelDateTime;

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
	 * @return eventMemberId
	 */
	public long getEventMemberId() {
		return eventMemberId;
	}

	/**
	 * @param eventMemberId セットする eventMemberId
	 */
	public void setEventMemberId(long eventMemberId) {
		this.eventMemberId = eventMemberId;
	}

	/**
	 * @return adminFacebookId
	 */
	public long getAdminFacebookId() {
		return adminFacebookId;
	}

	/**
	 * @param adminFacebookId セットする adminFacebookId
	 */
	public void setAdminFacebookId(long adminFacebookId) {
		this.adminFacebookId = adminFacebookId;
	}

	/**
	 * @return socialEventId
	 */
	public long getSocialEventId() {
		return socialEventId;
	}

	/**
	 * @param socialEventId セットする socialEventId
	 */
	public void setSocialEventId(long socialEventId) {
		this.socialEventId = socialEventId;
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
	 * @return entryDateTime
	 */
	public Date getEntryDateTime() {
		return entryDateTime;
	}

	/**
	 * @param entryDateTime セットする entryDateTime
	 */
	public void setEntryDateTime(Date entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	/**
	 * @return cancelDateTime
	 */
	public Date getCancelDateTime() {
		return cancelDateTime;
	}

	/**
	 * @param cancelDateTime セットする cancelDateTime
	 */
	public void setCancelDateTime(Date cancelDateTime) {
		this.cancelDateTime = cancelDateTime;
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
