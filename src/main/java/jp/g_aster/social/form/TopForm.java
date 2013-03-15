package jp.g_aster.social.form;

import java.util.List;

import jp.g_aster.social.dto.MemberImageFileDto;
import jp.g_aster.social.dto.StampDto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TopForm {


	private List<StampDto>  stampList;


	private List<MemberImageFileDto> memberImageList;



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
	 * @return memberImageList
	 */
	public List<MemberImageFileDto> getMemberImageList() {
		return memberImageList;
	}

	/**
	 * @param memberImageList セットする memberImageList
	 */
	public void setMemberImageList(List<MemberImageFileDto> memberImageList) {
		this.memberImageList = memberImageList;
	}



	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
