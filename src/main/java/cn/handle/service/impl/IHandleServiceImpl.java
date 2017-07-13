package cn.handle.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.handle.bean.vo.ApplyCarTemporaryLicenceVo;
import cn.handle.bean.vo.ApplyGatePassVo;
import cn.handle.bean.vo.ApplyInspectionMarkVo;
import cn.handle.bean.vo.ApplyRemoteEntrustedBusinessVo;
import cn.handle.bean.vo.DriverChangeContactVo;
import cn.handle.bean.vo.DriverLicenseAnnualVerificationVo;
import cn.handle.bean.vo.DriverLicenseIntoVo;
import cn.handle.bean.vo.DriverLicenseVoluntaryDemotionVo;
import cn.handle.bean.vo.IocomotiveCarChangeContactVo;
import cn.handle.bean.vo.IocomotiveCarReplaceVo;
import cn.handle.bean.vo.RenewalDriverLicenseVo;
import cn.handle.bean.vo.RepairOrReplaceDriverLicenseVo;
import cn.handle.bean.vo.ReplaceMotorVehicleLicensePlateVo;
import cn.handle.bean.vo.VehicleDrivingLicenseVo;
import cn.handle.cache.impl.IHandleServiceCenterCachedImpl;
import cn.handle.service.IHandleService;
import cn.handle.utils.ThirdPartyInterface;
import cn.sdk.webservice.WebServiceClient;
import cn.sdk.bean.BaseBean;
import cn.sdk.util.MsgCode;


@SuppressWarnings(value="all")
@Service("handleService")
public class IHandleServiceImpl implements IHandleService{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IHandleServiceCenterCachedImpl iAccountCached;
	
	@Override
	public String getTemplateSendUrl() {
		String url = iAccountCached.getTemplateSendUrl();
		logger.info("获取到的域名地址是：" + url);
		return url;
	}
	
	
	@Override
	public Map<String, String> driverLicenseAnnualVerification(
			DriverLicenseAnnualVerificationVo driverLicenseAnnualVerificationVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.driverLicenseAnnualVerification(driverLicenseAnnualVerificationVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("driverLicenseAnnualVerification出错，错误="+ "driverLicenseAnnualVerificationVo=" + driverLicenseAnnualVerificationVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> renewalDriverLicense(RenewalDriverLicenseVo renewalDriverLicenseVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.renewalDriverLicense(renewalDriverLicenseVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("driverLicenseAnnualVerification出错，错误="+ "renewalDriverLicenseVo=" + renewalDriverLicenseVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> driverLicenseInto(DriverLicenseIntoVo driverLicenseIntoVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.driverLicenseInto(driverLicenseIntoVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("driverLicenseInto出错，错误="+ "driverLicenseIntoVo=" + driverLicenseIntoVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> driverLicenseVoluntaryDemotion(
			DriverLicenseVoluntaryDemotionVo driverLicenseVoluntaryDemotionVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.driverLicenseVoluntaryDemotion(driverLicenseVoluntaryDemotionVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("driverLicenseVoluntaryDemotion出错，错误="+ "driverLicenseVoluntaryDemotionVo=" + driverLicenseVoluntaryDemotionVo,e);
			throw e;
		}
		
		return map;
		
	}



	@Override
	public Map<String, String> driverChangeContact(DriverChangeContactVo driverChangeContactVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.driverChangeContact(driverChangeContactVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("driverChangeContact出错，错误="+ "driverChangeContactVo=" + driverChangeContactVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> repairDriverLicense(RepairOrReplaceDriverLicenseVo repairOrReplaceDriverLicenseVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.repairDriverLicense(repairOrReplaceDriverLicenseVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("repairDriverLicense出错，错误="+ "repairOrReplaceDriverLicenseVo=" + repairOrReplaceDriverLicenseVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> replaceDriverLicense(RepairOrReplaceDriverLicenseVo repairOrReplaceDriverLicenseVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.replaceDriverLicense(repairOrReplaceDriverLicenseVo, url, method, userId, userPwd, key);
			 
		} catch (Exception e) {
			logger.error("replaceDriverLicense出错，错误="+ "repairOrReplaceDriverLicenseVo=" + repairOrReplaceDriverLicenseVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> applyGatePass(ApplyGatePassVo applyGatePassVo) throws Exception {
		logger.debug("【办理类服务】申请通行证(外地车)applyGatePass...");
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.applyGatePass(applyGatePassVo, url, method, userId, userPwd, key);
			 
			 logger.debug("【办理类服务】申请通行证(外地车)采集结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】申请通行证(外地车)信息采集异常！ApplyGatePassVo="+ applyGatePassVo,e);
			throw e;
		}
		return map;
	}


	@Override
	public Map<String, String> applyCarTemporaryLicence(ApplyCarTemporaryLicenceVo applyCarTemporaryLicenceVo)
			throws Exception {
		logger.debug("【办理类服务】申请机动车临牌applyCarTemporaryLicence...");
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.applyCarTemporaryLicence(applyCarTemporaryLicenceVo, url, method, userId, userPwd, key);
			 
			 logger.debug("【办理类服务】申请机动车临牌结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】申请机动车临牌异常！ApplyCarTemporaryLicenceVo="+ applyCarTemporaryLicenceVo,e);
			throw e;
		}
		return map;
	}


	/**
	 * 补换检验合格标志
	 */
	public Map<String, String> replaceInspectionMark(ApplyInspectionMarkVo applyInspectionMarkVo)
			throws Exception {
		logger.debug("【办理类服务】补换检验合格标志applyInspectionMarkVo...");
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.replaceInspectionMark(applyInspectionMarkVo, url, method, userId, userPwd, key);
			 
			 logger.debug("【办理类服务】补换检验合格标志结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】补换检验合格标志异常！ApplyInspectionMarkVo="+ applyInspectionMarkVo,e);
			throw e;
		}
		return map;
	}


	/**
	 * 机动车委托异地定期检验申报
	 */
	public Map<String, String> inspectionDeclaration(ApplyRemoteEntrustedBusinessVo applyRemoteEntrustedBusinessVo)
			throws Exception {
		logger.debug("【办理类服务】机动车委托异地定期检验申报 ApplyRemoteEntrustedBusinessVo...");
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.inspectionDeclaration(applyRemoteEntrustedBusinessVo, url, method, userId, userPwd, key);
			 
			 logger.debug("【办理类服务】机动车委托异地定期检验申报结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】机动车委托异地定期检验申报异常！ApplyRemoteEntrustedBusinessVo="+ applyRemoteEntrustedBusinessVo,e);
			throw e;
		}
		return map;
	}


	/**
	 * 机动车委托异地定期检验申报查询
	 */
	public Map<String, String> inspectionDeclarationQuery(String identityCard,String sourceOfCertification)
			throws Exception {
		logger.debug("【办理类服务】机动车委托异地定期检验申报查询 ...");
		Map<String, String> map = new HashMap<>();
		try {
			
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.inspectionDeclarationQuery(identityCard,sourceOfCertification,url, method, userId, userPwd, key);
			 
			 logger.debug("【办理类服务】机动车委托异地定期检验申报查询结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】机动车委托异地定期检验申报查询异常！identityCard="+ identityCard+"  sourceOfCertification="+sourceOfCertification,e);
			throw e;
		}
		return map;
	}
	
	@Override
	public Map<String, String> iocomotiveCarChangeContact(IocomotiveCarChangeContactVo iocomotiveCarChangeContactVo)  throws Exception{
		logger.debug("【办理类服务】机动车联系方式变更iocomotiveCarChangeContact...");
		Map<String, String> map = new HashMap<>();
		try {
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.iocomotiveCarChangeContact(iocomotiveCarChangeContactVo, url, method, userId, userPwd, key);
			 logger.debug("【办理类服务】机动车联系方式变更结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】机动车联系方式变更异常！iocomotiveCarChangeContactVo=" + iocomotiveCarChangeContactVo,e);
			throw e;
		}
		
		return map;
	}
	
	@Override
	public Map<String, String> iocomotiveCarReplace(IocomotiveCarReplaceVo iocomotiveCarReplaceVo)  throws Exception{
		logger.debug("【办理类服务】换领机动车行驶证iocomotiveCarReplace...");
		Map<String, String> map = new HashMap<>();
		try {
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.iocomotiveCarReplace(iocomotiveCarReplaceVo, url, method, userId, userPwd, key);
			 logger.debug("【办理类服务】换领机动车行驶证结果:"+map);
		} catch (Exception e) {
			logger.error("【办理类服务】换领机动车行驶证异常！iocomotiveCarReplaceVo=" + iocomotiveCarReplaceVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, Object> complementTheMotorVehicleDrivingLicense(VehicleDrivingLicenseVo vehicleDrivingLicenseVo)throws Exception {
		logger.debug("【办理类服务】补领机动车行驶证complementTheMotorVehicleDrivingLicense...");
		Map<String, Object> map = new HashMap<>();
		try {
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 map = ThirdPartyInterface.complementTheMotorVehicleDrivingLicense(vehicleDrivingLicenseVo, url, method, userId, userPwd, key);
			 logger.debug("complementTheMotorVehicleDrivingLicense结果:"+map);
		} catch (Exception e) {
			logger.error("complementTheMotorVehicleDrivingLicense异常！vehicleDrivingLicenseVo=" + vehicleDrivingLicenseVo,e);
			throw e;
		}
		return map;
	}
	

	/**
	 * 六年免检预约
	 */
	public JSONObject createVehicleInspection(LinkedHashMap<String, Object> map) throws Exception {
		String method = "createVehicleInspection";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			jsonObject = WebServiceClient.vehicleAdministrationWebService(url, method, map);
		} catch (Exception e) {
			logger.error("createVehicleInspection 失败 ， map = " + map);
			throw e;
		}
		return jsonObject;
	}

	/**
	 * 获取车辆类型列表
	 */
	public JSONObject getCarTypes(LinkedHashMap<String, Object> map) throws Exception {
		String method = "getCarTypes";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			jsonObject = WebServiceClient.vehicleAdministrationWebService(url, method, map);
		} catch (Exception e) {
			logger.error("getCarTypes 失败 ， map = " + map);
			throw e;
		}
		return jsonObject;
	}

	/**
	 * 取消机动车六年免检预约
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public JSONObject cancelVehicleInspection(LinkedHashMap<String, Object> map) throws Exception {
		String method = "cancelVehicleInspection";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			jsonObject = WebServiceClient.vehicleAdministrationWebService(url, method, map);
		} catch (Exception e) {
			logger.error("cancelVehicleInspection 失败， map = " + map);
			throw e;
		}
		return jsonObject;
	}

	/**
	 * 取消机动车六年免检预约
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public JSONObject getVehicleInspection(LinkedHashMap<String, Object> map) throws Exception {
		String method = "getVehicleInspection";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			jsonObject = WebServiceClient.vehicleAdministrationWebService(url, method, map);
		} catch (Exception e) {
			logger.error("getVehicleInspection 失败， map = " + map);
			throw e;
		}
		return jsonObject;
	}

	/**
	 * 补领机动车号牌
	 * @param vo 补领机动车号牌 申请信息
	 * @return
	 * @throws Exception
	 */
	public BaseBean replaceMotorVehicleLicensePlate(ReplaceMotorVehicleLicensePlateVo vo) throws Exception {
		logger.debug("【办理类服务】补领机动车号牌replaceMotorVehicleLicensePlate...");
		BaseBean baseBean = new BaseBean();
		try {
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 
			 JSONObject EZ1002RepJson = ThirdPartyInterface.replaceMotorVehicleLicensePlate(vo, url, method, userId, userPwd, key);
			 logger.info("【办理类服务】补领机动车号牌 xml转换成json：" + JSON.toJSONString(EZ1002RepJson));
			 
			 String code = EZ1002RepJson.getString("CODE");
			 String msg = EZ1002RepJson.getString("MSG");
			 
			 if(MsgCode.success.equals(code)){
				 String cid = EZ1002RepJson.getJSONObject("BODY").getString("CID");
				 baseBean.setData(cid);
			 }
			 
			 baseBean.setCode(code);
			 baseBean.setMsg(msg);
			 
			 logger.debug("replaceMotorVehicleLicensePlate结果:" + JSON.toJSONString(baseBean));
		} catch (Exception e) {
			logger.error("replaceMotorVehicleLicensePlate异常！vo=" + vo, e);
			throw e;
		}
		return baseBean;
	}


	@Override
	public Map<String, Object> getResultOfFirstIllegalImpunity(String numberPlate, String plateType, String illegalNumber,
			String queryType) throws Exception {
		Map<String, Object> map = new HashMap<>();
		try {
			 String url = iAccountCached.getUrl(); //webservice请求url
			 String method = iAccountCached.getMethod(); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(); //webservice登录密码
			 String key = iAccountCached.getKey(); //秘钥
			 
			 map = ThirdPartyInterface.getResultOfFirstIllegalImpunity(numberPlate,plateType, illegalNumber,
						queryType, url, method, userId, userPwd, key);
			 logger.info(map.toString());
		} catch (Exception e) {
			logger.error("getResultOfFirstIllegalImpunity异常！numberPlate=" + numberPlate+"plateType="+plateType+"illegalNumber="+illegalNumber+"queryType="+queryType, e);
			throw e;
		}
		return map;
	}
}
