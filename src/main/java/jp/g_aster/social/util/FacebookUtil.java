package jp.g_aster.social.util;

import java.util.Properties;

import org.seasar.framework.util.PropertiesUtil;
import org.seasar.framework.util.ResourceUtil;

public final class FacebookUtil {



	public static final String FACEBOOK_APP_ID="337485833023401";

	public static final String FACEBOOK_SECRET = "36f30c1f8aac101210c643ff5c70b30d";

	public static final String CALLBACK_URI="http://localhost:8080/facebook/callback";


	static{
		Properties props = new Properties();
        PropertiesUtil.load(props, ResourceUtil.getResourceAsStream("hoge.txt"));

	}

}
