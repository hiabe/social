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
 * イベントスタンプエンティティ
 * @author hiroshi-abe
 *
 */
@Entity
@Table(name = "event_member_stamp")
public class EventMemberStamp {

	@Id
	@Column(name="event_member_stamp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventMemberStampId;

	@Column(name="event_member_id")
	private int eventMemberId;

	@Column(name="event_id")
	private int eventId;

	@Column(name="fb_id")
	private String facebookId;

	@Column(name="stamp_id")
	private int stampId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="get_date_time")
	private Date getDateTime;

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



}
