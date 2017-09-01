package cn.handle.cache.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.handle.cache.IHandleServiceCenterCached;

@Service
public class IHandleServiceCenterCachedImpl implements IHandleServiceCenterCached {
	protected Logger log = Logger.getLogger(this.getClass());
	/**
	 * 用户id
	 */
	@Value("${useridAlipay}")
	private String useridAlipay;
	/**
	 * 用户密码
	 */
	@Value("${userpwdAlipay}")
	private String userpwdAlipay;
	/**
	 * 请求地址
	 */
	@Value("${urlAlipay}")
	private String urlAlipay;
	/**
	 * 方法
	 */
	@Value("${methodAlipay}")
	private String methodAlipay;
	/**
	 * 秘钥
	 */
	@Value("${keyAlipay}")
	private String keyAlipay;

	/**
	 * 用户id
	 */
	@Value("${userid}")
	private String userid;
	/**
	 * 用户密码
	 */
	@Value("${userpwd}")
	private String userpwd;
	/**
	 * 请求地址
	 */
	@Value("${url}")
	private String url;
	/**
	 * 方法
	 */
	@Value("${method}")
	private String method;
	/**
	 * 秘钥
	 */
	@Value("${key}")
	private String key;
	/**
	 * 
	 */
	@Value("${stcUrl}")
	private String stcUrl;

	@Value("${cgsaccount}")
	private String cgsaccount;

	@Value("${cgspassword}")
	private String cgspassword;

	@Value("${stcUrlOld}")
	private String stcUrlOld;

	@Value("${templateSendUrl}")
	private String templateSendUrl;

	public String getUserid(String sourceOfCertification) {
		String string = "";
		if("C".equals(sourceOfCertification)){
			string = userid;
		}else if("Z".equals(sourceOfCertification)){
			string = useridAlipay;
		}else {
			string = userid;
		}
		return string;
	}


	public String getUserpwd(String sourceOfCertification) {
		String string = "";
		if("C".equals(sourceOfCertification)){
			string = userpwd;
		}else if("Z".equals(sourceOfCertification)){
			string = userpwdAlipay;
		}else {
			string = userpwd;
		}
		return string;
	}


	public String getUrl(String sourceOfCertification) {
		String string = "";
		if("C".equals(sourceOfCertification)){
			string = url;
		}else if("Z".equals(sourceOfCertification)){
			string = urlAlipay;
		}else {
			string = url;
		}
		return string;
	}


	public String getMethod(String sourceOfCertification) {
		String string = "";
		if("C".equals(sourceOfCertification)){
			string = method;
		}else  if("Z".equals(sourceOfCertification)){
			string = methodAlipay;
		}else {
			string = method;
		}
		return string;
	}


	public String getKey(String sourceOfCertification) {
		String string = "";
		if("C".equals(sourceOfCertification)){
			string = key;
		}else if("Z".equals(sourceOfCertification)){
			string = keyAlipay;
		}else {
			string = key;
		}
		return string;
	}
	
	public String getStcUrl() {
		return stcUrl;
	}

	public String getTemplateSendUrl() {
		return templateSendUrl;
	}

	public String getCgsaccount() {
		return cgsaccount;
	}

	public String getCgspassword() {
		return cgspassword;
	}

	public String getStcUrlOld() {
		return stcUrlOld;
	}

}
