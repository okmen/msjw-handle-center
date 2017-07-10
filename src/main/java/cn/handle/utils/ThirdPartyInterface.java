package cn.handle.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

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
import cn.sdk.bean.BaseBean;
import cn.sdk.webservice.WebServiceClient;

/**
 * 调用第三方封装
 * @author Mbenben
 *
 */
@SuppressWarnings(value="all")
public class ThirdPartyInterface {
	
	private static final String ywlx5 = "5"; //机动车行驶证换领
	private static final String ywlx6 = "6"; //机动车联系方式变更
	private static final String ywlx1 = "1"; //补领机动车行驶证
	private static final String ywlx3 = "3"; //补领机动车号牌
	
	
	/**
	 * 驾驶证年审
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> driverLicenseAnnualVerification(DriverLicenseAnnualVerificationVo driverLicenseAnnualVerificationVo,String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+driverLicenseAnnualVerificationVo.getBusinessType()+"</YWLX><SFZMMC>"+driverLicenseAnnualVerificationVo.getIdentificationNO()+"</SFZMMC><SFZMHM>"+driverLicenseAnnualVerificationVo.getIDcard()+"</SFZMHM><JSZHM>"+driverLicenseAnnualVerificationVo.getIDcard()+"</JSZHM><XM>"+driverLicenseAnnualVerificationVo.getName()+"</XM><HJSZD>"+driverLicenseAnnualVerificationVo.getPlaceOfDomicile()+"</HJSZD><YZBM>"+driverLicenseAnnualVerificationVo.getPostalcode()+"</YZBM><SJRXM>"+driverLicenseAnnualVerificationVo.getReceiverName()+"</SJRXM><SJRSJ>"+driverLicenseAnnualVerificationVo.getReceiverNumber()+"</SJRSJ><LXZSDZ>"+driverLicenseAnnualVerificationVo.getMailingAddress()+"</LXZSDZ><SFZHMA>"+driverLicenseAnnualVerificationVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+driverLicenseAnnualVerificationVo.getIDCardPhoto2()+"</SFZHMB><JZZA>"+driverLicenseAnnualVerificationVo.getLivePhoto1()+"</JZZA><JZZB>"+driverLicenseAnnualVerificationVo.getLivePhoto2()+"</JZZB><JYPXB>"+driverLicenseAnnualVerificationVo.getEducationDrawingtable()+"</JYPXB><PHOTO31>"+driverLicenseAnnualVerificationVo.getForeignersLiveTable()+"</PHOTO31><IP>"+driverLicenseAnnualVerificationVo.getIp()+"</IP><LOGIN_USER>"+driverLicenseAnnualVerificationVo.getLoginUser()+"</LOGIN_USER><RZLY>"+driverLicenseAnnualVerificationVo.getSourceOfCertification()+"</RZLY><LYBZ>"+driverLicenseAnnualVerificationVo.getUserSource()+"</LYBZ></REQUEST>";
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	/**
	 * 驾驶证延期换证
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> renewalDriverLicense(RenewalDriverLicenseVo renewalDriverLicenseVo,String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+renewalDriverLicenseVo.getBusinessType()+"</YWLX><XM>"+renewalDriverLicenseVo.getName()+"</XM><SFZMMC>"+renewalDriverLicenseVo.getIdentificationNO()+"</SFZMMC><SFZMHM>"+renewalDriverLicenseVo.getIDcard()+"</SFZMHM><JSZHM>"+renewalDriverLicenseVo.getDriverLicense()+"</JSZHM><DABH>"+renewalDriverLicenseVo.getFileNumber()+"</DABH><YQZZRQ>"+renewalDriverLicenseVo.getDelayDate()+"</YQZZRQ><YQYY>"+renewalDriverLicenseVo.getDelayReason()+"</YQYY><LYBZ>"+renewalDriverLicenseVo.getSourceOfCertification()+"</LYBZ><LOGIN_USER>"+renewalDriverLicenseVo.getLoginUser()+"</LOGIN_USER><IP>"+renewalDriverLicenseVo.getIp()+"</IP><SFZHMA>"+renewalDriverLicenseVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+renewalDriverLicenseVo.getIDCardPhoto2()+"</SFZHMB><JSZ>"+renewalDriverLicenseVo.getDriverLicensePhoto()+"</JSZ><YQZM>"+renewalDriverLicenseVo.getDelayPhoto()+"</YQZM></REQUEST>";
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	
	/**
	 * 驾驶证转入
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> driverLicenseInto(DriverLicenseIntoVo driverLicenseIntoVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+driverLicenseIntoVo.getBusinessType()+"</YWLX><XM>"+driverLicenseIntoVo.getName()+"</XM><SFZMMC>"+driverLicenseIntoVo.getIdentificationNO()+"</SFZMMC><SFZMHM>"+driverLicenseIntoVo.getIDcard()+"</SFZMHM><JSZHM>"+driverLicenseIntoVo.getDriverLicense()+"</JSZHM><DABH>"+driverLicenseIntoVo.getFileNumber()+"</DABH><FZJG>"+driverLicenseIntoVo.getIssuingLicenceAuthority()+"</FZJG><XPHZBH>"+driverLicenseIntoVo.getPhotoReturnNumberString()+"</XPHZBH><SJRXM>"+driverLicenseIntoVo.getReceiverName()+"</SJRXM><SJRSJ>"+driverLicenseIntoVo.getReceiverNumber()+"</SJRSJ><SJRDZ>"+driverLicenseIntoVo.getMailingAddress()+"</SJRDZ><LYBZ>"+driverLicenseIntoVo.getSourceOfCertification()+"</LYBZ><LOGIN_USER>"+driverLicenseIntoVo.getLoginUser()+"</LOGIN_USER><IP>"+driverLicenseIntoVo.getIp()+"</IP><SFZHMA>"+driverLicenseIntoVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+driverLicenseIntoVo.getIDCardPhoto2()+"</SFZHMB><JSZ>"+driverLicenseIntoVo.getDriverLicensePhoto()+"</JSZ><STTJSBB>"+driverLicenseIntoVo.getBodyConditionForm()+"</STTJSBB></REQUEST>";
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	
	
	/**
	 * 驾驶证自愿降级
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> driverLicenseVoluntaryDemotion(DriverLicenseVoluntaryDemotionVo driverLicenseVoluntaryDemotionVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+driverLicenseVoluntaryDemotionVo.getBusinessType()+"</YWLX><SFZMMC>"+driverLicenseVoluntaryDemotionVo.getIdentificationNO()+"</SFZMMC><LOGIN_USER>"+driverLicenseVoluntaryDemotionVo.getLoginUser()+"</LOGIN_USER><SFZMHM>"+driverLicenseVoluntaryDemotionVo.getIDcard()+"</SFZMHM><JSZHM>"+driverLicenseVoluntaryDemotionVo.getDriverLicense()+"</JSZHM><XM>"+driverLicenseVoluntaryDemotionVo.getName()+"</XM><XPHZBH>"+driverLicenseVoluntaryDemotionVo.getPhotoReturnNumberString()+"</XPHZBH><HJSZD>"+driverLicenseVoluntaryDemotionVo.getPlaceOfDomicile()+"</HJSZD><SJRXM>"+driverLicenseVoluntaryDemotionVo.getReceiverName()+"</SJRXM><SJRSJ>"+driverLicenseVoluntaryDemotionVo.getReceiverNumber()+"</SJRSJ><LXZSDZ>"+driverLicenseVoluntaryDemotionVo.getMailingAddress()+"</LXZSDZ><IP>"+driverLicenseVoluntaryDemotionVo.getIp()+"</IP><RZLY>"+driverLicenseVoluntaryDemotionVo.getSourceOfCertification()+"</RZLY><LYBZ>"+driverLicenseVoluntaryDemotionVo.getUserSource()+"</LYBZ><SFZHMA>"+driverLicenseVoluntaryDemotionVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+driverLicenseVoluntaryDemotionVo.getIDCardPhoto2()+"</SFZHMB><JSZ>"+driverLicenseVoluntaryDemotionVo.getDriverLicensePhoto()+"</JSZ></REQUEST>";
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	
	
	
	/**
	 * 驾驶证补证
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> repairDriverLicense(RepairOrReplaceDriverLicenseVo repairOrReplaceDriverLicenseVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+repairOrReplaceDriverLicenseVo.getBusinessType()+"</YWLX><YWYY>"+repairOrReplaceDriverLicenseVo.getRepairReason()+"</YWYY><SFZMMC>"+repairOrReplaceDriverLicenseVo.getIdentificationNO()+"</SFZMMC><SFZMHM>"+repairOrReplaceDriverLicenseVo.getIDcard()+"</SFZMHM><JSZHM>"+repairOrReplaceDriverLicenseVo.getIDcard()+"</JSZHM><XM>"+repairOrReplaceDriverLicenseVo.getName()+"</XM><SFZHMA>"+repairOrReplaceDriverLicenseVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+repairOrReplaceDriverLicenseVo.getIDCardPhoto2()+"</SFZHMB><XPHZBH>"+repairOrReplaceDriverLicenseVo.getPhotoReturnNumberString()+"</XPHZBH><PHOTO31>"+repairOrReplaceDriverLicenseVo.getForeignersLiveTable()+"</PHOTO31><HJSZD>"+repairOrReplaceDriverLicenseVo.getPlaceOfDomicile()+"</HJSZD><YZBM>"+repairOrReplaceDriverLicenseVo.getPostalcode()+"</YZBM><SJRXM>"+repairOrReplaceDriverLicenseVo.getReceiverName()+"</SJRXM><SJRSJ>"+repairOrReplaceDriverLicenseVo.getReceiverNumber()+"</SJRSJ><LXZSDZ>"+repairOrReplaceDriverLicenseVo.getMailingAddress()+"</LXZSDZ><JZZA>"+repairOrReplaceDriverLicenseVo.getLivePhoto1()+"</JZZA><JZZB>"+repairOrReplaceDriverLicenseVo.getLivePhoto2()+"</JZZB><IP>"+repairOrReplaceDriverLicenseVo.getIp()+"</IP><LOGIN_USER>"+repairOrReplaceDriverLicenseVo.getLoginUser()+"</LOGIN_USER><RZLY>"+repairOrReplaceDriverLicenseVo.getSourceOfCertification()+"</RZLY><LYBZ>"+repairOrReplaceDriverLicenseVo.getUserSource()+"</LYBZ></REQUEST>";
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	
	/**
	 * 驾驶证换证
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> replaceDriverLicense(RepairOrReplaceDriverLicenseVo repairOrReplaceDriverLicenseVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+repairOrReplaceDriverLicenseVo.getBusinessType()+"</YWLX><SFZMMC>"+repairOrReplaceDriverLicenseVo.getIdentificationNO()+"</SFZMMC><SFZMHM>"+repairOrReplaceDriverLicenseVo.getIDcard()+"</SFZMHM><JSZHM>"+repairOrReplaceDriverLicenseVo.getIDcard()+"</JSZHM><XM>"+repairOrReplaceDriverLicenseVo.getName()+"</XM><XPHZBH>"+repairOrReplaceDriverLicenseVo.getPhotoReturnNumberString()+"</XPHZBH><HJSZD>"+repairOrReplaceDriverLicenseVo.getPlaceOfDomicile()+"</HJSZD><SJRXM>"+repairOrReplaceDriverLicenseVo.getReceiverName()+"</SJRXM><SJRSJ>"+repairOrReplaceDriverLicenseVo.getReceiverNumber()+"</SJRSJ><LXZSDZ>"+repairOrReplaceDriverLicenseVo.getMailingAddress()+"</LXZSDZ><SFZHMA>"+repairOrReplaceDriverLicenseVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+repairOrReplaceDriverLicenseVo.getIDCardPhoto2()+"</SFZHMB><JZZA>"+repairOrReplaceDriverLicenseVo.getLivePhoto1()+"</JZZA><JZZB>"+repairOrReplaceDriverLicenseVo.getLivePhoto2()+"</JZZB><PHOTO31>"+repairOrReplaceDriverLicenseVo.getForeignersLiveTable()+"</PHOTO31><IP>"+repairOrReplaceDriverLicenseVo.getIp()+"</IP><LOGIN_USER>"+repairOrReplaceDriverLicenseVo.getLoginUser()+"</LOGIN_USER><RZLY>"+repairOrReplaceDriverLicenseVo.getSourceOfCertification()+"</RZLY><LYBZ>"+repairOrReplaceDriverLicenseVo.getUserSource()+"</LYBZ></REQUEST>"; 
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	
	/**
	 * 驾驶人联系方式变更
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> driverChangeContact(DriverChangeContactVo driverChangeContactVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1001";
		String EZ1001RepXml = "<?xmlversion=\"1.0\"encoding=\"utf-8\"?><REQUEST><YWLX>"+driverChangeContactVo.getBusinessType()+"</YWLX><XM>"+driverChangeContactVo.getName()+"</XM><XB>"+driverChangeContactVo.getGender()+"</XB><SFZMMC>"+driverChangeContactVo.getIdentificationNO()+"</SFZMMC><SFZMHM>"+driverChangeContactVo.getIDcard()+"</SFZMHM><JSZHM>"+driverChangeContactVo.getDriverLicense()+"</JSZHM><LXZSDZ>"+driverChangeContactVo.getMailingAddress()+"</LXZSDZ><YDDH>"+driverChangeContactVo.getMobilephone()+"</YDDH><LOGIN_USER>"+driverChangeContactVo.getLoginUser()+"</LOGIN_USER><LYBZ>"+driverChangeContactVo.getUserSource()+"</LYBZ><IP>"+driverChangeContactVo.getIp()+"</IP><SFZHMA>"+driverChangeContactVo.getIDCardPhoto1()+"</SFZHMA><SFZHMB>"+driverChangeContactVo.getIDCardPhoto2()+"</SFZHMB><JSZ>"+driverChangeContactVo.getDriverLicensePhoto()+"</JSZ></REQUEST>";		
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, EZ1001RepXml, userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	/**
	 * 申请通行证(外地车)
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> applyGatePass(ApplyGatePassVo applyGatePassVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "XWSQ";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
			.append("<HPHM>").append(applyGatePassVo.getAbbreviation()+applyGatePassVo.getNumberPlate()).append("</HPHM>")     //号码号牌
			.append("<HPZL>").append(applyGatePassVo.getPlateType()).append("</HPZL>")  //号牌种类
			.append("<CLLX>").append(applyGatePassVo.getCartype()).append("</CLLX>")  //车辆类型
			.append("<CJH4>").append(applyGatePassVo.getVin()).append("</CJH4>")  //车架号后四位
			.append("<CLSYR>").append(applyGatePassVo.getUserName()).append("</CLSYR>")  //车辆所有人
			.append("<SFZMHM>").append("").append("</SFZMHM>")  //身份证明号码
			.append("<SJHM>").append(applyGatePassVo.getMobilephone()).append("</SJHM>")  //手机号码
			.append("<SQRQ>").append(applyGatePassVo.getApplyDate()).append("</SQRQ>")  //申请日期
			.append("<BZ>").append("").append("</BZ>")  //备注字段
			.append("</REQUEST>");
		
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, sb.toString(), userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	/**
	 * 申请机动车临牌
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> applyCarTemporaryLicence(ApplyCarTemporaryLicenceVo applyCarTemporaryLicenceVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1001 = "EZ1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
			.append("<YWLX>").append("4").append("</YWLX>")     //业务类型-机动车临牌
			.append("<JDCSYR>").append(applyCarTemporaryLicenceVo.getUserName()).append("</JDCSYR>")  //姓名
			.append("<SFZMHM>").append(applyCarTemporaryLicenceVo.getIdentityCard()).append("</SFZMHM>")  //身份证号码
			.append("<CLXH>").append(applyCarTemporaryLicenceVo.getCartModels()).append("</CLXH>")  //车辆型号
			.append("<CLLX>").append(applyCarTemporaryLicenceVo.getCartype()).append("</CLLX>")  //车辆类型
			.append("<FDJH>").append(applyCarTemporaryLicenceVo.getEngineNumber()).append("</FDJH>")  //发动机号
			.append("<CLSBDH>").append(applyCarTemporaryLicenceVo.getVin()).append("</CLSBDH>")  //车辆识别代号
			.append("<GCJK>").append(applyCarTemporaryLicenceVo.getCarOrigin()).append("</GCJK>")  //国产/进口（A是国产B是进口）
			.append("<SJRXM>").append(applyCarTemporaryLicenceVo.getReceiverName()).append("</SJRXM>")  //收件人姓名
			.append("<SJRDZ>").append(applyCarTemporaryLicenceVo.getReceiverAddress()).append("</SJRDZ>")  //收件人地址
			.append("<SJRSJ>").append(applyCarTemporaryLicenceVo.getReceiverNumber()).append("</SJRSJ>")  //收件人手机
			.append("<JZZA>").append("").append("</JZZA>")  //居住证正面图片
			.append("<JZZB>").append("").append("</JZZB>")  //居住证反面图片
			.append("<PHOTO9>").append(applyCarTemporaryLicenceVo.getPHOTO9()).append("</PHOTO9>")  //身份证正面图片
			.append("<PHOTO10>").append(applyCarTemporaryLicenceVo.getPHOTO10()).append("</PHOTO10>")  //身份证反面图片
			.append("<PHOTO26>").append(applyCarTemporaryLicenceVo.getPHOTO26()).append("</PHOTO26>")  //有效的购置发票
			.append("<PHOTO27>").append(applyCarTemporaryLicenceVo.getPHOTO27()).append("</PHOTO27>")  //交强险单据
			.append("<PHOTO28>").append(applyCarTemporaryLicenceVo.getPHOTO28()).append("</PHOTO28>")  //机动车合格证（国产车必传‘进口车不传）
			.append("<PHOTO29>").append(applyCarTemporaryLicenceVo.getPHOTO29()).append("</PHOTO29>")  //进口货物证明书（进口车必传、国产车不传）
			.append("<PHOTO31>").append(applyCarTemporaryLicenceVo.getPHOTO31()).append("</PHOTO31>")  //境外人员临住表
			.append("<WWLRIP>").append(applyCarTemporaryLicenceVo.getIp()).append("</WWLRIP>")  //外网录入ip
			.append("<LYBZ>").append(applyCarTemporaryLicenceVo.getSourceOfCertification()).append("</LYBZ>")  //申请来源（A移动APP C微信Z支付宝E邮政）
			.append("<LOGIN_USER>").append(applyCarTemporaryLicenceVo.getIdentityCard()).append("</LOGIN_USER>")  //登录用户身份证号码
			.append("</REQUEST>");
		
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1001, sb.toString(), userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}
	/**
	* 机动车联系方式变更
	* @param args
	* @throws Exception 
	*/
	public static Map<String, String> iocomotiveCarChangeContact(IocomotiveCarChangeContactVo iocomotiveCarChangeContactVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1002 = "EZ1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
		.append("<YWLX>").append(ywlx6).append("</YWLX>")     //业务类型
		.append("<JDCSYR>").append(iocomotiveCarChangeContactVo.getName()).append("</JDCSYR>")     //车主姓名
		.append("<SFZMMC>").append(iocomotiveCarChangeContactVo.getIdentificationNO()).append("</SFZMMC>")  //证件种类
		.append("<SFZMHM>").append(iocomotiveCarChangeContactVo.getIdentificationNum()).append("</SFZMHM>")  //证件号码
		.append("<HPHM>").append(iocomotiveCarChangeContactVo.getNumberPlate()).append("</HPHM>")  //号牌号码
		.append("<HPZL>").append(iocomotiveCarChangeContactVo.getCartype()).append("</HPZL>")  //车辆种类
		.append("<FJSZD>").append(iocomotiveCarChangeContactVo.getPlaceOfDomicile()).append("</FJSZD>")  //户籍所在地
		.append("<CLSBDH>").append(iocomotiveCarChangeContactVo.getBehindTheFrame4Digits()).append("</CLSBDH>")  //车架号
		.append("<YDDH>").append(iocomotiveCarChangeContactVo.getMobilephone()).append("</YDDH>")  //变更号码
		.append("<ZSXXDZ>").append(iocomotiveCarChangeContactVo.getReceiverAddress()).append("</ZSXXDZ>")  //地址
		.append("<LYBZ>").append(iocomotiveCarChangeContactVo.getSourceOfCertification()).append("</LYBZ>")  //申请来源
		.append("<IP>").append(iocomotiveCarChangeContactVo.getIp()).append("</IP>")  //ip
		.append("<PHOTO9>").append(iocomotiveCarChangeContactVo.getPHOTO9()).append("</PHOTO9>")  //身份证（正面）
		.append("<PHOTO10>").append(iocomotiveCarChangeContactVo.getPHOTO10()).append("</PHOTO10>")  //身份证（反面）
		.append("<JDCXSZ>").append(iocomotiveCarChangeContactVo.getJDCXSZ()).append("</JDCXSZ>")  //机动车登记证书（当户籍选择境外人员时显示）·境外人员临住表
		.append("</REQUEST>");
		String EZ1002RepXml = sb.toString();
		JSONObject EZ1002RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1002, EZ1002RepXml, userId, userPwd, key);
		String code = EZ1002RepJson.getString("CODE");
		String msg = EZ1002RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}
	/**
	 * 换领机动车行驶证
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, String> iocomotiveCarReplace(IocomotiveCarReplaceVo iocomotiveCarReplaceVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , String> map = new HashMap<>();
		String EZ1002 = "EZ1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
		.append("<YWLX>").append(ywlx5).append("</YWLX>")     //业务类型
		.append("<JDCSYR>").append(iocomotiveCarReplaceVo.getName()).append("</JDCSYR>")     //车主姓名
		.append("<SFZMHM>").append(iocomotiveCarReplaceVo.getIdentificationNum()).append("</SFZMHM>")  //证件号码
		.append("<HPHM>").append(iocomotiveCarReplaceVo.getNumberPlate()).append("</HPHM>")  //号牌号码
		.append("<HPZL>").append(iocomotiveCarReplaceVo.getPlateType()).append("</HPZL>")  //号牌种类
		.append("<FJSZD>").append(iocomotiveCarReplaceVo.getPlaceOfDomicile()).append("</FJSZD>")  //户籍所在地
		.append("<ZSXXDZ>").append(iocomotiveCarReplaceVo.getAddress()).append("</ZSXXDZ>")  //住所详细地址
		.append("<SJRXM>").append(iocomotiveCarReplaceVo.getReceiverName()).append("</SJRXM>")  //收件人姓名
		.append("<SJRDZ>").append(iocomotiveCarReplaceVo.getReceiverAddress()).append("</SJRDZ>")  //收件人地址
		.append("<SJRSJ>").append(iocomotiveCarReplaceVo.getReceiverNumber()).append("</SJRSJ>")  //收件人手机
		.append("<JZZA>").append(iocomotiveCarReplaceVo.getJZZA()).append("</JZZA>")  //居住证正面图片
		.append("<JZZB>").append(iocomotiveCarReplaceVo.getJZZB()).append("</JZZB>")  //居住证反面图片
		.append("<PHOTO9>").append(iocomotiveCarReplaceVo.getPHOTO9()).append("</PHOTO9>")  //身份证（正面）
		.append("<PHOTO10>").append(iocomotiveCarReplaceVo.getPHOTO10()).append("</PHOTO10>")  //身份证（反面）
		.append("<DJZSFYJ>").append(iocomotiveCarReplaceVo.getDJZSFYJ()).append("</DJZSFYJ>")  //机动车登记证书（当户籍选择境外人员时显示）·境外人员临住表
		.append("<WWLRIP>").append(iocomotiveCarReplaceVo.getIp()).append("</WWLRIP>")  //外网录入ip
		.append("<LYBZ>").append(iocomotiveCarReplaceVo.getSourceOfCertification()).append("</LYBZ>")  //申请来源
		.append("</REQUEST>");
		String EZ1002RepXml = sb.toString();
		JSONObject EZ1002RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1002, EZ1002RepXml, userId, userPwd, key);
		String code = EZ1002RepJson.getString("CODE");
		String msg = EZ1002RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	

	/**
	 * 补领机动车行驶证
	 * @param args
	 * @throws Exception 
	 */
	public static Map<String, Object> complementTheMotorVehicleDrivingLicense(VehicleDrivingLicenseVo vehicleDrivingLicenseVo, String url,String method,String userId,String userPwd,String key) throws Exception{
		Map<String , Object> map = new HashMap<>();
		String EZ1002 = "EZ1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
		.append("<YWLX>").append(ywlx1).append("</YWLX>")     //业务类型
		.append("<JDCSYR>").append(vehicleDrivingLicenseVo.getName()).append("</JDCSYR>")     //机动车所有人
		.append("<SFZMHM>").append(vehicleDrivingLicenseVo.getIDcard()).append("</SFZMHM>")  //证件号码
		.append("<HPHM>").append(vehicleDrivingLicenseVo.getLicensePlate()).append("</HPHM>")  //号牌号码
		.append("<HPZL>").append(vehicleDrivingLicenseVo.getLicensePlateTpye()).append("</HPZL>")  //号牌种类
		.append("<FJSZD>").append(vehicleDrivingLicenseVo.getPlaceOfDomicile()).append("</FJSZD>")  //户籍所在地
		.append("<ZSXXDZ>").append(vehicleDrivingLicenseVo.getPlaceOfDomicile()).append("</ZSXXDZ>")  //住所详细地址
		.append("<SJRXM>").append(vehicleDrivingLicenseVo.getReceiverName()).append("</SJRXM>")  //收件人姓名
		.append("<SJRDZ>").append(vehicleDrivingLicenseVo.getMailingAddress()).append("</SJRDZ>")  //收件人地址
		.append("<SJRSJ>").append(vehicleDrivingLicenseVo.getReceiverNumber()).append("</SJRSJ>")  //收件人手机
		.append("<XSZZP>").append(vehicleDrivingLicenseVo.getXSZZP()).append("</XSZZP>")  //车辆45°照片
		.append("<JZZA>").append(vehicleDrivingLicenseVo.getLivePhoto1()).append("</JZZA>")  //居住证正面图片
		.append("<JZZB>").append(vehicleDrivingLicenseVo.getLivePhoto2()).append("</JZZB>")  //居住证反面图片
		.append("<PHOTO31>").append(vehicleDrivingLicenseVo.getForeignPeopleLivingOnTheTable()).append("</PHOTO31>")  //境外人员临住表
		.append("<PHOTO9>").append(vehicleDrivingLicenseVo.getIDCardPhoto1()).append("</PHOTO9>")  //身份证（正面）
		.append("<PHOTO10>").append(vehicleDrivingLicenseVo.getIDCardPhoto2()).append("</PHOTO10>")  //身份证（反面）
		.append("<DJZSFYJ>").append(vehicleDrivingLicenseVo.getDriverLicensePhoto()).append("</DJZSFYJ>")  //机动车登记证书
		.append("<WWLRIP>").append(vehicleDrivingLicenseVo.getIp()).append("</WWLRIP>")  //外网录入ip
		.append("<RZLY>").append("").append("</RZLY>")  //从登录接口取，可以为空
		.append("<LYBZ>").append(vehicleDrivingLicenseVo.getSourceOfCertification()).append("</LYBZ>")  //申请来源
		.append("</REQUEST>");
		String EZ1002RepXml = sb.toString();
		JSONObject EZ1002RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1002, EZ1002RepXml, userId, userPwd, key);
		String code = EZ1002RepJson.getString("CODE");
		String msg = EZ1002RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	
	}
	
	
	public static Map<String, String> replaceInspectionMark(ApplyInspectionMarkVo applyInspectionMarkVo, String url,String method,String userId,String userPwd,String key)throws Exception {
		Map<String , String> map = new HashMap<>();
		String EZ1002 = "EZ1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
			.append("<YWLX>").append("2").append("</YWLX>")     //业务类型-机动车临牌
			.append("<JDCSYR>").append(applyInspectionMarkVo.getUserName()).append("</JDCSYR>")  //姓名
			.append("<SFZMHM>").append(applyInspectionMarkVo.getIdentityCard()).append("</SFZMHM>")  //身份证号码
			.append("<HPHM>").append(applyInspectionMarkVo.getLicensePlateNo()).append("</HPHM>")  //车牌号码
			.append("<HPZL>").append(applyInspectionMarkVo.getLicensePlateType()).append("</HPZL>")  //车牌种类
			.append("<FJSZD>").append(applyInspectionMarkVo.getPlaceOfDomicile()).append("</FJSZD>")  //户籍所在地
			.append("<JZZHM>").append("").append("</JZZHM>")  //居住证号码
			.append("<ZSXXDZ>").append("").append("</ZSXXDZ>")  //住所详细地址
			.append("<SJRXM>").append(applyInspectionMarkVo.getRecipientName()).append("</SJRXM>")  //收件人姓名
			.append("<SJRDZ>").append(applyInspectionMarkVo.getRecipientAddress()).append("</SJRDZ>")  //收件人地址
			.append("<SJRSJ>").append(applyInspectionMarkVo.getRecipientPhone()).append("</SJRSJ>")  //收件人手机
			.append("<JZZA>").append(applyInspectionMarkVo.getJZZA()).append("</JZZA>")  //居住证正面图片
			.append("<JZZB>").append(applyInspectionMarkVo.getJZZB()).append("</JZZB>")  //居住证反面图片
			.append("<PHOTO31>").append(applyInspectionMarkVo.getForeignersLiveTable()).append("</PHOTO31>")  //境外人员临住表
			.append("<PHOTO9>").append(applyInspectionMarkVo.getIdCardImgPositive()).append("</PHOTO9>")  //身份证正面图片
			.append("<PHOTO10>").append(applyInspectionMarkVo.getIdCardImgNegative()).append("</PHOTO10>")  //身份证反面图片
			.append("<WWLRIP>").append(applyInspectionMarkVo.getIp()).append("</WWLRIP>")  //外网录入ip
			.append("<LYBZ>").append(applyInspectionMarkVo.getSourceOfCertification()).append("</LYBZ>")  //申请来源（A移动APP C微信Z支付宝E邮政）
			.append("<LOGIN_USER>").append(applyInspectionMarkVo.getIdentityCard()).append("</LOGIN_USER>")  //登录用户身份证号码
			.append("<RZLY>").append("").append("</RZLY>")  			
			.append("</REQUEST>");
		
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1002, sb.toString(), userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}


	
	/**
	 * 机动车委托异地定期检验申报
	 */
	public static Map<String, String> inspectionDeclaration(ApplyRemoteEntrustedBusinessVo applyBusinessVo,String url,String method,String userId,String userPwd,String key)
			throws Exception {
		Map<String , String> map = new HashMap<>();
		String WT1001 = "WT1001";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
			.append("<CLSYQ>").append(applyBusinessVo.getProprietorship()).append("</CLSYQ>")     //车辆所有权(0个人)
			.append("<LRZHLX>").append(applyBusinessVo.getSourceOfCertification()).append("</LRZHLX>")  //申报方式（A移动APP、C微信、Z支付宝,E邮政）
			.append("<LRZH>").append(applyBusinessVo.getIdentityCard()).append("</LRZH>")  //身份证号码
			.append("<HPHM>").append(applyBusinessVo.getLicensePlateNo()).append("</HPHM>")  //车牌号码
			.append("<HPZL>").append(applyBusinessVo.getLicensePlateType()).append("</HPZL>")  //车牌种类
			.append("<CLSBDH>").append(applyBusinessVo.getVehicleIdentifyNoLast4()).append("</CLSBDH>")  //车驾后4
			.append("<SFZMHM>").append(applyBusinessVo.getCarOwnerIdentityCard()).append("</SFZMHM>")  //车主身份证明号码
			.append("<SYR>").append(applyBusinessVo.getName()).append("</SYR>")  //车主姓名
			.append("<STJG>").append(applyBusinessVo.getAssociatedAgency()).append("</STJG>")  //受托机构代码（将提供受托机构字典表，例如：粤A
			.append("<YJ_SJRXM>").append(applyBusinessVo.getRecipientName()).append("</YJ_SJRXM>")//收件人姓名
			.append("<YJ_TDDZ>").append(applyBusinessVo.getRecipientAddress()).append("</YJ_TDDZ>")//邮寄地址，仅限广东省深圳市
			.append("<YJ_YZBM>").append(applyBusinessVo.getPostalcode()).append("</YJ_YZBM>")//邮政编码
			.append("<YJ_LXDH>").append(applyBusinessVo.getRecipientPhone()).append("</YJ_LXDH>")  //收件人手机			
			.append("</REQUEST>");
		
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, WT1001, sb.toString(), userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}


	
	public static Map<String, String> inspectionDeclarationQuery(String identityCard,String sourceOfCertification,String url,String method,String userId,String userPwd,String key)
			throws Exception {
		Map<String , String> map = new HashMap<>();
		String WT1002 = "WT1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
			.append("<LRZHLX>").append(sourceOfCertification).append("</LRZHLX>")  //申报方式（A移动APP、C微信、Z支付宝,E邮政）
			.append("<LRZH>").append(identityCard).append("</LRZH>")  //身份证号码			
			.append("</REQUEST>");
		
		JSONObject EZ1001RepJson = WebServiceClient.getInstance().requestWebService(url, method, WT1002, sb.toString(), userId, userPwd, key);
		String code = EZ1001RepJson.getString("CODE");
		String msg = EZ1001RepJson.getString("MSG");
		map.put("code", code);
		map.put("msg", msg);
		return map;

	}
	
	/**
	 * 补领机动车号牌
	 * @param vo 补领机动车号牌 申请信息
	 * @return
	 * @throws Exception
	 */
	public static JSONObject replaceMotorVehicleLicensePlate(ReplaceMotorVehicleLicensePlateVo vo, String url,
			String method, String userId, String userPwd, String key) throws Exception {
		BaseBean baseBean = new BaseBean();
		String EZ1002 = "EZ1002";
		//拼装xml数据
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST>")
		.append("<YWLX>").append(ywlx3).append("</YWLX>")     									//业务类型
		.append("<JDCSYR>").append(vo.getName()).append("</JDCSYR>")     						//机动车所有人
		.append("<SFZMHM>").append(vo.getCarOwnerIdentityCard()).append("</SFZMHM>")  			//证件号码
		.append("<HPHM>").append(vo.getNumberPlate()).append("</HPHM>")  						//号牌号码
		.append("<HPZL>").append(vo.getPlateType()).append("</HPZL>")  							//号牌种类
		.append("<FJSZD>").append(vo.getPlaceOfDomicile()).append("</FJSZD>")  					//户籍所在地
		.append("<JZZHM>").append(vo.getResidenceNo()).append("</JZZHM>")  						//居住证号码*
		.append("<ZSXXDZ>").append(vo.getAddress()).append("</ZSXXDZ>")  						//住所地址
		.append("<SJRXM>").append(vo.getReceiverName()).append("</SJRXM>")  					//收件人姓名
		.append("<SJRDZ>").append(vo.getReceiverAddress()).append("</SJRDZ>")  					//收件人地址
		.append("<SJRSJ>").append(vo.getReceiverNumber()).append("</SJRSJ>")  					//收件人手机
		.append("<JZZA>").append(vo.getJZZA()).append("</JZZA>")  								//居住证正面图片*
		.append("<JZZB>").append(vo.getJZZB()).append("</JZZB>")  								//居住证反面图片*
		.append("<PHOTO31>").append(vo.getPHOTO31()).append("</PHOTO31>")						//境外人员临住表*
		.append("<PHOTO9>").append(vo.getPHOTO9()).append("</PHOTO9>")  						//身份证（正面）
		.append("<PHOTO10>").append(vo.getPHOTO10()).append("</PHOTO10>")  						//身份证（反面）
		.append("<DJZSFYJ>").append(vo.getDJZSFYJ()).append("</DJZSFYJ>")  						//机动车登记证书
		.append("<WWLRIP>").append(vo.getIp()).append("</WWLRIP>")  							//外网录入ip
		.append("<LYBZ>").append(vo.getSourceOfCertification()).append("</LYBZ>")  				//申请来源
		.append("<LOGIN_USER>").append(vo.getLoginUserIdentityCard()).append("</LOGIN_USER>")	//登录用户身份证号码
		.append("</REQUEST>");
		String EZ1002RepXml = sb.toString();
		JSONObject EZ1002RepJson = WebServiceClient.getInstance().requestWebService(url, method, EZ1002, EZ1002RepXml, userId, userPwd, key);
		return EZ1002RepJson;
	}
}
