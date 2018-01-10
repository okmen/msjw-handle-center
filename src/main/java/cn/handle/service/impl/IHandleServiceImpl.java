package cn.handle.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
import cn.handle.bean.vo.CarMortgageBean;
import cn.handle.bean.vo.CarMortgageVo;
import cn.handle.bean.vo.CreateVehicleInspectionVo;
import cn.handle.bean.vo.DelegateVehiclesVo;
import cn.handle.bean.vo.DriverChangeContactVo;
import cn.handle.bean.vo.DriverLicenseAnnualVerificationVo;
import cn.handle.bean.vo.DriverLicenseIntoVo;
import cn.handle.bean.vo.DriverLicenseVoluntaryDemotionVo;
import cn.handle.bean.vo.InspectionDeclarationVo;
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
import cn.sdk.util.StringUtil;


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
	public String getMsjwTemplateSendUrl() {
		String url = iAccountCached.getMsjwTemplateSendUrl() + "source=M&";
		logger.debug("获取到的民生警务结果页域名地址是：" + url);
		return url;
	}


	@Override
	public String getMsjwHandleTemplateId() {
		String templateId = iAccountCached.getMsjwHandleTemplateId();
		logger.debug("民生警务templateId：" + templateId);
		return templateId;
	}
	
	@Override
	public String getMsjwSixyearsUrl() {
		String url = iAccountCached.getMsjwSixyearsUrl() + "source=M";
		logger.debug("民生警务六年免检url：" + url);
		return url;
	}


	@Override
	public Map<String, String> driverLicenseAnnualVerification(
			DriverLicenseAnnualVerificationVo driverLicenseAnnualVerificationVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		logger.info("【办理类服务】驾驶证年审driverLicenseAnnualVerification...");
		try {
			 String sourceOfCertification = driverLicenseAnnualVerificationVo.getUserSource();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.driverLicenseAnnualVerification(driverLicenseAnnualVerificationVo, url, method, userId, userPwd, key);
			 logger.info("【办理类服务】驾驶证年审返回结果：" + map);
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
			 String sourceOfCertification = renewalDriverLicenseVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
			 String sourceOfCertification = driverLicenseIntoVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
			 String sourceOfCertification = driverLicenseVoluntaryDemotionVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
			 String sourceOfCertification = driverChangeContactVo.getUserSource();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
		logger.info("【办理类服务】驾驶证补证repairDriverLicense...");
		try {
			 String sourceOfCertification = repairOrReplaceDriverLicenseVo.getUserSource();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.repairDriverLicense(repairOrReplaceDriverLicenseVo, url, method, userId, userPwd, key);
			 logger.info("【办理类服务】驾驶证补证返回结果：" + map);
		} catch (Exception e) {
			logger.error("repairDriverLicense出错，错误="+ "repairOrReplaceDriverLicenseVo=" + repairOrReplaceDriverLicenseVo,e);
			throw e;
		}
		
		return map;
	}


	@Override
	public Map<String, String> replaceDriverLicense(RepairOrReplaceDriverLicenseVo repairOrReplaceDriverLicenseVo)  throws Exception{
		Map<String, String> map = new HashMap<>();
		logger.info("【办理类服务】驾驶证换证replaceDriverLicense...");
		try {
			 String sourceOfCertification = repairOrReplaceDriverLicenseVo.getUserSource();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.replaceDriverLicense(repairOrReplaceDriverLicenseVo, url, method, userId, userPwd, key);
			 logger.info("【办理类服务】驾驶证换证返回结果：" + map);
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
			String sourceOfCertification = "";
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
		logger.info("【办理类服务】申请机动车临牌applyCarTemporaryLicence...");
		Map<String, String> map = new HashMap<>();
		try {
			String sourceOfCertification = applyCarTemporaryLicenceVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.applyCarTemporaryLicence(applyCarTemporaryLicenceVo, url, method, userId, userPwd, key);
			 
			 logger.info("【办理类服务】申请机动车临牌结果:"+map);
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
		logger.info("【办理类服务】补换检验合格标志replaceInspectionMark...");
		Map<String, String> map = new HashMap<>();
		try {
			String sourceOfCertification = applyInspectionMarkVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.replaceInspectionMark(applyInspectionMarkVo, url, method, userId, userPwd, key);
			 
			 logger.info("【办理类服务】补换检验合格标志结果:"+map);
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
		logger.info("【办理类服务】机动车委托异地定期检验申报 inspectionDeclaration...");
		Map<String, String> map = new HashMap<>();
		try {
			String sourceOfCertification = applyRemoteEntrustedBusinessVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.inspectionDeclaration(applyRemoteEntrustedBusinessVo, url, method, userId, userPwd, key);
			 
			 logger.info("【办理类服务】机动车委托异地定期检验申报结果:"+map);
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
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.inspectionDeclarationQuery(identityCard,sourceOfCertification,url, method, userId, userPwd, key);
			 String row=map.get("body");
			 List<InspectionDeclarationVo> infos = new ArrayList<InspectionDeclarationVo>();
			 
		 	 if(!StringUtil.isBlank(row)){		
					if(row.contains("[")){
						infos=(List<InspectionDeclarationVo>) JSON.parseArray(row, InspectionDeclarationVo.class);
					}else{
						InspectionDeclarationVo model=JSON.parseObject(row,InspectionDeclarationVo.class);
						infos.add(model);
					}			 
			 }
		 	 map.put("body", JSON.toJSONString(infos));
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
			 String sourceOfCertification = iocomotiveCarChangeContactVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
			 String sourceOfCertification = iocomotiveCarReplaceVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
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
			String sourceOfCertification = vehicleDrivingLicenseVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 map = ThirdPartyInterface.complementTheMotorVehicleDrivingLicense(vehicleDrivingLicenseVo, url, method, userId, userPwd, key);
			 logger.debug("complementTheMotorVehicleDrivingLicense结果:"+map);
		} catch (Exception e) {
			logger.error("complementTheMotorVehicleDrivingLicense异常！vehicleDrivingLicenseVo=" + vehicleDrivingLicenseVo,e);
			throw e;
		}
		return map;
	}
	

	/**
	 * 补领机动车号牌
	 * @param vo 补领机动车号牌 申请信息
	 * @return
	 * @throws Exception
	 */
	public BaseBean replaceMotorVehicleLicensePlate(ReplaceMotorVehicleLicensePlateVo vo) throws Exception {
		logger.info("【办理类服务】补领机动车号牌replaceMotorVehicleLicensePlate...");
		BaseBean baseBean = new BaseBean();
		try {
			String sourceOfCertification = vo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 
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
			 
			 logger.info("replaceMotorVehicleLicensePlate结果:" + JSON.toJSONString(baseBean));
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
			String sourceOfCertification = "";
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 logger.info("numberPlate = " + numberPlate+"plateType="+plateType+"illegalNumber="+illegalNumber+"queryType="+queryType);
			 map = ThirdPartyInterface.getResultOfFirstIllegalImpunity(numberPlate,plateType, illegalNumber,
						queryType, url, method, userId, userPwd, key);
			 logger.info("1返回的数据为+" + map);
		} catch (Exception e) {
			logger.error("getResultOfFirstIllegalImpunity异常！numberPlate=" + numberPlate+"plateType="+plateType+"illegalNumber="+illegalNumber+"queryType="+queryType, e);
			throw e;
		}
		logger.info("2返回的数据为+" + map);
		return map;
	}
	/**
	 * 获取车辆类型列表
	 */
	public JSONObject getCarTypes() throws Exception {
		String method = "JK07";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			String account = iAccountCached.getCgsaccount();
			String password = iAccountCached.getCgspassword();
			String data = "<root></root>";
			jsonObject = WebServiceClient.vehicleAdministrationWebServiceNew(url, method, data, account, password);
		} catch (Exception e) {
			logger.error("getCarTypes 失败 ");
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
	public JSONObject cancelVehicleInspection(String bookNumber, String numberPlate) throws Exception {
		String method = "JK15";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			String account = iAccountCached.getCgsaccount();
			String password = iAccountCached.getCgspassword();
			StringBuffer sb = new StringBuffer();
			sb.append("<root>")
			.append("<bookNumber>").append(bookNumber).append("</bookNumber>")
			.append("<platNumber>").append(numberPlate).append("</platNumber>")
			.append("</root>");
			jsonObject = WebServiceClient.vehicleAdministrationWebServiceNew(url, method, sb.toString(), account, password);
		} catch (Exception e) {
			logger.error("cancelVehicleInspection 失败");
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
	public JSONObject getVehicleInspection(String bookNumber, String numberPlate, String driveLicenseNumber) throws Exception {
		String method = "JK25";
		JSONObject jsonObject = new JSONObject();
		try {
			String url = iAccountCached.getStcUrl();
			String account = iAccountCached.getCgsaccount();
			String password = iAccountCached.getCgspassword();
			StringBuffer sb = new StringBuffer();
			sb.append("<root>")
			.append("<bookNumber>").append(bookNumber).append("</bookNumber>")
			.append("<platNumber>").append(numberPlate).append("</platNumber>")
			.append("<driveLicenseNumber>").append(driveLicenseNumber).append("</driveLicenseNumber>")
			.append("</root>");
			jsonObject = WebServiceClient.vehicleAdministrationWebServiceNew(url, method, sb.toString(), account, password);
		} catch (Exception e) {
			logger.error("getVehicleInspection 失败");
			throw e;
		}
		return jsonObject;
	}

	@Override
	public BaseBean createVehicleInspection(CreateVehicleInspectionVo createVehicleInspectionVo) throws Exception {
		String method = "JK14";
		BaseBean refBean = new BaseBean();
		try {
			String url = iAccountCached.getStcUrl();
			String account = iAccountCached.getCgsaccount();
			String password = iAccountCached.getCgspassword();
			StringBuffer sb = new StringBuffer();
			sb.append("<root>")
			.append("<platNumber>").append(createVehicleInspectionVo.getPlatNumber()).append("</platNumber>")
			.append("<name>").append(createVehicleInspectionVo.getName()).append("</name>")
			.append("<personType>").append(createVehicleInspectionVo.getPersonType()).append("</personType>")
			.append("<driveLicenseNumber>").append(createVehicleInspectionVo.getDriveLicenseNumber()).append("</driveLicenseNumber>")
			.append("<mobile>").append(createVehicleInspectionVo.getMobile()).append("</mobile>")
			.append("<telno>").append(createVehicleInspectionVo.getTelno()).append("</telno>")
			.append("<recipientsName>").append(createVehicleInspectionVo.getRecipientsName()).append("</recipientsName>")
			.append("<recipientsMobile>").append(createVehicleInspectionVo.getRecipientsMobile()).append("</recipientsMobile>")
			.append("<postCode>").append(createVehicleInspectionVo.getPostCode()).append("</postCode>")
			.append("<postAddr>").append(createVehicleInspectionVo.getPostAddr()).append("</postAddr>")
			.append("<effectiveDate>").append(createVehicleInspectionVo.getEffectiveDate()).append("</effectiveDate>")
			.append("<terminationDate>").append(createVehicleInspectionVo.getTerminationDate()).append("</terminationDate>")
			.append("<inform>").append(createVehicleInspectionVo.getInform()).append("</inform>")
			.append("<bookerName>").append(createVehicleInspectionVo.getBookerName()).append("</bookerName>")
			.append("<bookerIdNumber>").append(createVehicleInspectionVo.getBookerIdNumber()).append("</bookerIdNumber>")
			.append("<bookerType>").append(createVehicleInspectionVo.getBookerType()).append("</bookerType>")
			.append("<carTypeId>").append(createVehicleInspectionVo.getCarTypeId()).append("</carTypeId>")
			.append("</root>");
			JSONObject jsonObject = WebServiceClient.vehicleAdministrationWebServiceNew(url, method, sb.toString(), account, password);
			String code = jsonObject.getString("code");
			String msg = jsonObject.getString("msg");
			String result = jsonObject.getString("result");
			refBean.setCode(code);
			refBean.setMsg(msg);
			refBean.setData(result);
		} catch (Exception e) {
			logger.error("createVehicleInspection 失败 ， createVehicleInspectionVo = " + createVehicleInspectionVo);
			throw e;
		}
		return refBean;
	}


	@Override
	public BaseBean electronicDelegateVehicles(DelegateVehiclesVo delegateVehiclesVo) throws Exception {
		BaseBean baseBean = new BaseBean();
		try {
			 String sourceOfCertification = delegateVehiclesVo.getUserSource();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 baseBean = ThirdPartyInterface.electronicDelegateVehicles(delegateVehiclesVo, url, method, userId, userPwd, key);
		} catch (Exception e) {
			logger.error("【办理类服务】机动车联系方式变更异常！delegateVehiclesVo=" + delegateVehiclesVo,e);
			throw e;
		}
		
		return baseBean;
	}


	@Override
	public BaseBean applyOrCancleCarMortgage(CarMortgageVo carMortgageVo) throws Exception {
		BaseBean baseBean = new BaseBean();
		try {
			 String sourceOfCertification = carMortgageVo.getSourceOfCertification();
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 baseBean = ThirdPartyInterface.applyOrCancleCarMortgage(carMortgageVo, url, method, userId, userPwd, key);
		} catch (Exception e) {
			logger.error("【办理类服务】机动车抵押业务异常！carMortgageVo=" + carMortgageVo,e);
			throw e;
		}
		
		return baseBean;
	}


	@Override
	public BaseBean queryCarMortgage(String loginUser,String sqlx,String sourceOfCertification) throws Exception {
		BaseBean baseBean = new BaseBean();
		try {
			 String url = iAccountCached.getUrl(sourceOfCertification); //webservice请求url
			 String method = iAccountCached.getMethod(sourceOfCertification); //webservice请求方法名称
			 String userId = iAccountCached.getUserid(sourceOfCertification); //webservice登录账号
			 String userPwd = iAccountCached.getUserpwd(sourceOfCertification); //webservice登录密码
			 String key = iAccountCached.getKey(sourceOfCertification); //秘钥
			 baseBean = ThirdPartyInterface.queryCarMortgage(loginUser,sqlx, url, method, userId, userPwd, key);
		} catch (Exception e) {
			logger.error("【办理类服务】机动车抵押业务查询异常！loginUser=" + loginUser,e);
			throw e;
		}
		
		return baseBean;
	}
}
