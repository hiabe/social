package jp.g_aster.social.form;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CreateEventForm {

	private String eventName;

	private String eventDateFrom;

	private String eventDateTo;

	private String place;

	private int stampCount;

	private int memberFileId;

	private String description;

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
	public String getEventDateFrom() {
		return eventDateFrom;
	}

	/**
	 * @param eventDateFrom セットする eventDateFrom
	 */
	public void setEventDateFrom(String eventDateFrom) {
		this.eventDateFrom = eventDateFrom;
	}

	/**
	 * @return eventDateTo
	 */
	public String getEventDateTo() {
		return eventDateTo;
	}

	/**
	 * @param eventDateTo セットする eventDateTo
	 */
	public void setEventDateTo(String eventDateTo) {
		this.eventDateTo = eventDateTo;
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


	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
