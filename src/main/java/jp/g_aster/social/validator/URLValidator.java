package jp.g_aster.social.validator;

import java.net.MalformedURLException;
import java.net.URL;

import org.seasar.cubby.action.MessageInfo;
import org.seasar.cubby.validator.ScalarFieldValidator;
import org.seasar.cubby.validator.ValidationContext;

public class URLValidator implements ScalarFieldValidator {

	/**
	 * メッセージキー。
	 */
	private final String messageKey;

	/**
	 * コンストラクタ
	 */
	public URLValidator() {
		this("valid.url");
	}

	/**
	 * エラーメッセージキーを指定するコンストラクタ
	 *
	 * @param messageKey
	 *            エラーメッセージキー
	 */
	public URLValidator(final String messageKey) {
		this.messageKey = messageKey;
	}


	@Override
	public void validate(ValidationContext context, Object value) {
		if (value instanceof String) {
			final String str = (String) value;
			try {
				new URL(str);
				return;
			} catch (MalformedURLException e) {
			}
		}

		final MessageInfo messageInfo = new MessageInfo();
		messageInfo.setKey(this.messageKey);
		context.addMessageInfo(messageInfo);

	}
}
