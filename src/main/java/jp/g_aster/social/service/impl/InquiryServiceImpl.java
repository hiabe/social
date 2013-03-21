/**
 *
 */
package jp.g_aster.social.service.impl;

import jp.g_aster.social.dto.InquiryDto;
import jp.g_aster.social.service.InquiryService;
import jp.g_aster.social.util.MailUtil;

/**
 * @author hiroshi-abe
 *
 */
public class InquiryServiceImpl implements InquiryService {

	@Override
	public void postMessage(InquiryDto dto) {
		MailUtil.send("info@g-aster.jp", dto.getMyName(), dto.getComment());

	}

}
