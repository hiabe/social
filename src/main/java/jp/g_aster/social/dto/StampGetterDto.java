/*
 * copyright G-Aster.ltd All Rights Reserved.
 */
package jp.g_aster.social.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * イベントスタンプエンティティ
 * @author hiroshi-abe
 *
 */
public class StampGetterDto {

	private int stampId;

	private String facebookId;

	private Date getDateTime;

	private String creator;

	private Date created;

	private String modifier;

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
	 * @return getDateTime
	 */
	public Date getGetDateTime() {
		return getDateTime;
	}

	/**
	 * @param getDateTime セットする getDateTime
	 */
	public void setGetDateTime(Date getDateTime) {
		this.getDateTime = getDateTime;
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

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}


}
