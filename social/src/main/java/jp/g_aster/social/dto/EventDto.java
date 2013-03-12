package jp.g_aster.social.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * ソーシャルイベントのＤＴＯリスト
 * @author hiroshi-abe
 *
 */
public class EventDto {

	private int eventId;

	private String facebookId;

	private String eventName;

	private Date eventDateFrom;

	private Date eventDateTo;

	private String pageUrl;

	private String imageUrl;

	private String qrFilename;

	private Date expiredDate;

	private String place;

	private int stampCount;

	private int memberFileId;

	private String description;

	private String authenticationKey;

	private int fileId;

	private boolean deleted;

	private String creator;

	private Date created;

	private String modifier;

	private Date modified;

	private String memberFileUrl;


	private List<StampDto> stampList = null;



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

	/**
	 * @return stampList
	 */
	public List<StampDto> getStampList() {
		return stampList;
	}

	/**
	 * @param stampList セットする stampList
	 */
	public void setStampList(List<StampDto> stampList) {
		this.stampList = stampList;
	}

	/**
	 * スタンプを追加します。
	 * @param dto
	 */
	public void addStamp(StampDto dto){
		if(CollectionUtils.isEmpty(this.stampList)){
			this.stampList = new ArrayList<StampDto>();
		}
		this.stampList.add(dto);
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * イベント開始日をStringで取得
	 * @return
	 */
	public String getEventDateFromString(){
		return DateFormatUtils.format(getEventDateFrom(), "yyyy/MM/dd");
	}

	/**
	 * イベント終了日をStringで取得
	 * @return
	 */
	public String getEventDateToString(){
		return DateFormatUtils.format(getEventDateTo(), "yyyy/MM/dd");
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

}
