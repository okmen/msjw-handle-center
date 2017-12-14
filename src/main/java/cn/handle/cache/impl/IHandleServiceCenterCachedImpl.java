package cn.handle.cache.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.handle.cache.IHandleServiceCenterCached;

@Service
public class IHandleServiceCenterCachedImpl implements IHandleServiceCenterCached {
	protected Logger log = Logger.getLogger(this.getClass());
	
	/**
     * 民生警务参数
     */
    @Value("${useridMsjw}")
    private String useridMsjw;
    @Value("${userpwdMsjw}")
    private String userpwdMsjw;
    @Value("${urlMsjw}")
    private String urlMsjw;
    @Value("${methodMsjw}")
    private String methodMsjw;
    @Value("${keyMsjw}")
    private String keyMsjw;
	
    @Value("${msjwTemplateSendUrl}")
	private String msjwTemplateSendUrl;
    @Value("${msjwHandleTemplateId}")
    private String msjwHandleTemplateId;
    
	public String getMsjwTemplateSendUrl() {
		return msjwTemplateSendUrl;
	}
	public String getMsjwHandleTemplateId() {
		return msjwHandleTemplateId;
	}

	/**
	 * 用户id
	 */
	@Value("${useridGd}")
    private String useridGd;
	/**
	 * 用户密码
	 */
    @Value("${userpwdGd}")
    private String userpwdGd;
    /**
     * 请求地址
     */
    @Value("${urlGd}")
    private String urlGd;
    /**
     * 方法
     */
    @Value("${methodGd}")
    private String methodGd;
    /**
     * 秘钥
     */
    @Value("${keyGd}")
    private String keyGd;
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
		}else if("G".equals(sourceOfCertification)){
			string = useridGd;
		}else if("M".equals(sourceOfCertification)){
			string = useridMsjw;
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
		}else if("G".equals(sourceOfCertification)){
			string = userpwdGd;
		}else if("M".equals(sourceOfCertification)){
			string = userpwdMsjw;
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
		}else if("G".equals(sourceOfCertification)){
			string = urlGd;
		}else if("M".equals(sourceOfCertification)){
			string = urlMsjw;
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
		}else  if("G".equals(sourceOfCertification)){
			string = methodGd;
		}else  if("M".equals(sourceOfCertification)){
			string = methodMsjw;
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
		}else if("G".equals(sourceOfCertification)){
			string = keyGd;
		}else if("M".equals(sourceOfCertification)){
			string = keyMsjw;
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
