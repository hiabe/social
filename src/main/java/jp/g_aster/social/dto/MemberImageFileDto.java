package jp.g_aster.social.dto;

import java.util.Date;

public class MemberImageFileDto {

	private int fileId;

	private String facebookId;

	private String fileName;

	private String imageUrl;

	private String creator;

	private Date created;

	private String modifier;

	private Date modified;

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
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName セットする fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
