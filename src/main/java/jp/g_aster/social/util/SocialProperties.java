package jp.g_aster.social.util;

import java.util.Properties;

import org.seasar.framework.util.PropertiesUtil;
import org.seasar.framework.util.ResourceUtil;

public class SocialProperties {

	private static Properties props=null;

	public  static Properties getProps(){
		if(props==null){
			props = new Properties();
			PropertiesUtil.load(props, ResourceUtil.getResourceAsStream("socialRally.properties"));
		}
		return props;
	}
}
