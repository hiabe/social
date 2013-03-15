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
 * 画像ファイルエンティティ
 * @author hiroshi-abe
 *
 */
@Entity
@Table(name = "member_img_file")
public class MemberImageFile {

	public static final int FILEID_NOIMAGE=0;

	@Id
	@Column(name="file_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fileId;

	@Column(name="fb_id")
	private String facebookId;

	@Column(name="file_name")
	private String fileName;

	@Column(name="image_url")
	private String imageUrl;

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
