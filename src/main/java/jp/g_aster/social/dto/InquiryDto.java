package jp.g_aster.social.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 問い合わせ内容
 * @author hiroshi-abe
 *
 */
public class InquiryDto {

	private String mailAddress;

	private String myName;

	private String comment;

	/**
	 * @return mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress セットする mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @return myName
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * @param myName セットする myName
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}



}
