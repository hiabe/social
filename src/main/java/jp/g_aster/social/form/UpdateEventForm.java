package jp.g_aster.social.form;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UpdateEventForm {

	private String eventName;

	private String eventDateFrom;

	private String eventDateTo;

	private String place;

	private int stampCount;

	private int memberFileId;

	private String description;

	private List<String> stampId;

	private List<String> stampNo;

	private List<String> message;

	private List<String> postUrl;

	private List<String> caption;

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


	/**
	 * @return stampId
	 */
	public List<String> getStampId() {
		return stampId;
	}

	/**
	 * @param stampId セットする stampId
	 */
	public void setStampId(List<String> stampId) {
		this.stampId = stampId;
	}

	/**
	 * @return stampNo
	 */
	public List<String> getStampNo() {
		return stampNo;
	}

	/**
	 * @param stampNo セットする stampNo
	 */
	public void setStampNo(List<String> stampNo) {
		this.stampNo = stampNo;
	}

	/**
	 * @return message
	 */
	public List<String> getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(List<String> message) {
		this.message = message;
	}

	/**
	 * @return postUrl
	 */
	public List<String> getPostUrl() {
		return postUrl;
	}

	/**
	 * @param postUrl セットする postUrl
	 */
	public void setPostUrl(List<String> postUrl) {
		this.postUrl = postUrl;
	}

	/**
	 * @return caption
	 */
	public List<String> getCaption() {
		return caption;
	}

	/**
	 * @param caption セットする caption
	 */
	public void setCaption(List<String> caption) {
		this.caption = caption;
	}


	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
