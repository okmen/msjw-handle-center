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
    
	public String getUserid() {
		return userid;
	}


	public String getUserpwd() {
		return userpwd;
	}


	public String getUrl() {
		return url;
	}


	public String getMethod() {
		return method;
	}


	public String getKey() {
		return key;
	}


	public String getStcUrl() {
		return stcUrl;
	}

	
}
