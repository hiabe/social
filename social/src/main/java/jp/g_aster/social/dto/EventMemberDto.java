package jp.g_aster.social.dto;

import java.util.Date;

public class EventMemberDto {

	private long eventMemberId;

	private String adminFacebookId;

	private long socialEventId;

	private String facebookId;

	private Date entryDateTime;

	private Date cancelDateTime;

	private String creator;

	private Date created;

	private String modifier;

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
	public String getAdminFacebookId() {
		return adminFacebookId;
	}

	/**
	 * @param adminFacebookId セットする adminFacebookId
	 */
	public void setAdminFacebookId(String adminFacebookId) {
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
