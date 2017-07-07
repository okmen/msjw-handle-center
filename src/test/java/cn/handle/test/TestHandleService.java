package cn.handle.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

import cn.handle.bean.vo.ApplyInspectionMarkVo;
import cn.handle.bean.vo.ApplyRemoteEntrustedBusinessVo;
import cn.handle.bean.vo.DriverChangeContactVo;
import cn.handle.bean.vo.DriverLicenseAnnualVerificationVo;
import cn.handle.bean.vo.DriverLicenseIntoVo;
import cn.handle.bean.vo.DriverLicenseVoluntaryDemotionVo;
import cn.handle.bean.vo.RenewalDriverLicenseVo;
import cn.handle.bean.vo.RepairOrReplaceDriverLicenseVo;
import cn.handle.bean.vo.VehicleDrivingLicenseVo;
import cn.handle.service.IHandleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:junit-test.xml" })
public class TestHandleService {
	@Autowired
    @Qualifier("handleService")
    private IHandleService handleService;
	 
	/**
	 * 取消六年免检预约
	 * 取消机动车
	 * @param bookerNumber
	 * @param platNumber
	 * @throws Exception DateUtil.formatDateTime(new Date())
	 */
	@Test
	public void testcancelVehicleInspection() throws Exception{
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("bookerNumber", "P170706047");
		map.put("platNumber", "粤B6F7M1");
		JSONObject jsonObject = handleService.cancelVehicleInspection(map);
		System.out.println(jsonObject);
	}
	
	
	/**
	 * 获取机动车预约信息
	 * @throws Exception 
	 */
	@Test
	public void testgetVehicleInspection() throws Exception{
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("bookerNumber", "P170706047");
		map.put("platNumber", "粤B6F7M1");
		map.put("driveLicenseNumber", "");
		JSONObject jsonObject = handleService.getVehicleInspection(map);
		System.out.println(jsonObject);
	}
	
	
	/**
	 * 获取车辆类型列表
	 * @throws Exception
	 */
	@Test
	public void testgetCarTypes() throws Exception {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("arg0", "");
		map.put("arg1", "");
		JSONObject carTypes = handleService.getCarTypes(map);
		System.out.println(carTypes);
	}
	/**
	 * 六年免检预约
	 * @throws Exception
	 */
	@Test
	public void testcreateVehicleInspection() throws Exception{
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("platNumber","粤B6F7M1");
		map.put("name","王玉璞");
		map.put("personType","1");
		map.put("driveLicenseNumber","822198502074110");
		map.put("mobile","15920071829");
		map.put("telno","");
		map.put("recipientsName","王玉璞");
		map.put("recipientsMobile","15920071829");
		map.put("postCode","123456");
		map.put("postAddr","11");
		map.put("effectiveDate","2017-01-01");
		map.put("terminationDate","2017-12-12");
		map.put("inform","1");
		map.put("bookerName","王玉璞");
		map.put("bookerIdNumber","15920071829");
		map.put("bookerType","0");
		map.put("carTypeId","e4e48584399473d20139947fff4e2b2e");
		map.put("arg0","");
		map.put("arg1","");
		map.put("arg2","");
		map.put("arg3","");
		map.put("arg4","");
		JSONObject jsonObject = handleService.createVehicleInspection(map);
		System.out.println(jsonObject);
	} 
	/**
	 * 驾驶人联系方式变更
	 * @throws Exception 
	 */
	@Test
	public void testDriverChangeContact() throws Exception{
		//http://192.168.1.245:8080/web/user/driverChangeContact.html?name=张宇帆&gender=1&identificationNO=A&IDcard=622822198502074110&driverLicense=622822198502074110&mailingAddress=深圳市宝安区&mobilephone=15920050177&loginUser=15920050177&userSource=C&IDCardPhoto1=111&IDCardPhoto2=222&driverLicensePhoto=111 
		DriverChangeContactVo dv = new DriverChangeContactVo();
		dv.setBusinessType("L");
		dv.setDriverLicensePhoto("ddd");
		dv.setGender("1");
		dv.setIDcard("622822198502074110");
		dv.setDriverLicense("622822198502074110");
		dv.setIDCardPhoto1("111");
		dv.setIDCardPhoto2("222");
		dv.setIdentificationNO("A");
		dv.setIp("11");
		dv.setLoginUser("15920050177");
		dv.setMailingAddress("深圳市宝安区");
		dv.setMobilephone("15920050177");
		dv.setName("王玉璞");
		dv.setUserSource("C");
		Map< String, String> map = new HashMap<>();
		map = handleService.driverChangeContact(dv);
		System.out.println(map);
	}
	
	/**
	 * 驾驶证补证
	 * @throws Exception 
	 */
	@Test
	public void testRepairDriverLicense() throws Exception{
		//http://192.168.1.245:8080/web/user/repairDriverLicense.html?repairReason=1&identificationNO=A&IDcard=445222199209020034&name=张宇帆&mobilephone=15920050177&IDCardPhoto1=111&IDCardPhoto2=222&photoReturnNumberString=111&foreignersLiveTable=111&placeOfDomicile=深圳&postalcode=1&receiverName=111&receiverNumber=15920050177&mailingAddress=深圳市宝安区&livePhoto1=111&livePhoto2=222&loginUser=445222199209020034&sourceOfCertification=C&userSource=C                    
		RepairOrReplaceDriverLicenseVo rv = new RepairOrReplaceDriverLicenseVo();
		rv.setBusinessType("B");
		rv.setForeignersLiveTable("111");
		rv.setIDcard("445222199209020034");
		rv.setIDCardPhoto1("111");
		rv.setIDCardPhoto2("222");
		rv.setIdentificationNO("A");
		rv.setIp("11");
		rv.setLivePhoto1("111");
		rv.setLivePhoto2("222");
		rv.setLoginUser("445222199209020034");
		rv.setMailingAddress("深圳市宝安区");
		rv.setName("张宇帆");
		rv.setPhotoReturnNumberString("123456");
		rv.setPlaceOfDomicile("深圳");
		rv.setPostalcode("");
		rv.setReceiverName("333");
		rv.setReceiverNumber("15920050177");
		rv.setRepairReason("");
		rv.setSourceOfCertification("C");
		rv.setUserSource("C");
		Map<String , String> map = new HashMap<>();
		map = handleService.repairDriverLicense(rv);
		System.out.println(map);
	} 
	
	
	/**
	 * 驾驶证换证
	 * @throws Exception 
	 */
	@Test
	public void testReplaceDriverLicense() throws Exception{
		//http://192.168.1.245:8080/web/user/replaceDriverLicense.html?identificationNO=A&IDcard=445222199209020034&name=张宇帆&mobilephone=15920050177&IDCardPhoto1=111&IDCardPhoto2=222&photoReturnNumberString=111&foreignersLiveTable=111&placeOfDomicile=深圳&receiverName=111&receiverNumber=15920050177&mailingAddress=深圳市宝安区&livePhoto1=111&livePhoto2=222&loginUser=445222199209020034&sourceOfCertification=C&userSource=C                    
		RepairOrReplaceDriverLicenseVo rv = new RepairOrReplaceDriverLicenseVo();
		rv.setBusinessType("H");
		rv.setForeignersLiveTable("111");
		rv.setIDcard("445222199209020034");
		rv.setIDCardPhoto1("111");
		rv.setIDCardPhoto2("222");
		rv.setIdentificationNO("A");
		rv.setIp("11");
		rv.setLivePhoto1("111");
		rv.setLivePhoto2("222");
		rv.setLoginUser("445222199209020034");
		rv.setMailingAddress("深圳市宝安区");
		rv.setName("张宇帆");
		rv.setPhotoReturnNumberString("123456");
		rv.setPlaceOfDomicile("深圳");
		rv.setReceiverName("333");
		rv.setReceiverNumber("15920050177");
		rv.setSourceOfCertification("C");
		rv.setUserSource("C");
		Map<String , String> map = new HashMap<>();
		map = handleService.replaceDriverLicense(rv);
		System.out.println(map);
	} 
	
	
	/**
	 * 驾驶证自愿降级
	 * @throws Exception 
	 */
	@Test
	public void testDriverLicenseVoluntaryDemotion() throws Exception{
		//http://192.168.1.245:8080/web/user/driverLicenseVoluntaryDemotion.html?identificationNO=A&loginUser=445222199209020034&IDcard=445222199209020034&driverLicense=445222199209020034&name=张宇帆&photoReturnNumberString=11111&placeOfDomicile=深圳&receiverName=张宇帆&receiverNumber=15920050177&mailingAddress=深圳市宝安区&sourceOfCertification=C&userSource=C&IDCardPhoto1=111&IDCardPhoto2=222&driverLicensePhoto=111      
		DriverLicenseVoluntaryDemotionVo dv = new DriverLicenseVoluntaryDemotionVo();
		dv.setBusinessType("J");
		dv.setDriverLicensePhoto("111");
		dv.setIDcard("445222199209020034");
		dv.setDriverLicense("445222199209020034");
		dv.setIDCardPhoto1("111");
		dv.setIDCardPhoto2("222");
		dv.setIdentificationNO("A");
		dv.setIp("11");
		dv.setLoginUser("445222199209020034");
		dv.setMailingAddress("深圳市宝安区");
		dv.setName("张宇帆");
		dv.setPhotoReturnNumberString("111");
		dv.setReceiverName("张宇帆");
		dv.setReceiverNumber("15920050177");
		dv.setSourceOfCertification("C");
		dv.setUserSource("C");
		dv.setPlaceOfDomicile("1");
		Map<String, String > map = new HashMap<>();
		map = handleService.driverLicenseVoluntaryDemotion(dv);
		System.out.println(map);
	}
	
	
	
	/**
	 * 驾驶证转入
	 * @throws Exception 
	 */
	@Test
	public void testDriverLicenseInto() throws Exception{
		//http://192.168.1.245:8080/web/user/driverLicenseInto.html?name=张宇帆&identificationNO=A&IDcard=445222199209020034&driverLicense=445222199209020034&fileNumber=123456&issuingLicenceAuthority=藏A:拉萨市公安局&photoReturnNumberString=111&receiverName=张宇帆&receiverNumber=15920050177&mailingAddress=深圳市宝安区&sourceOfCertification=C&loginUser=445222199209020034&IDCardPhoto1=111&IDCardPhoto2=222&driverLicensePhoto=111&bodyConditionForm=222    
		DriverLicenseIntoVo dv = new DriverLicenseIntoVo();
		dv.setBodyConditionForm("111");
		dv.setBusinessType("Z");
		dv.setDriverLicensePhoto("111");
		dv.setFileNumber("440304166612");
		dv.setIDcard("445222199209020034");
		dv.setDriverLicense("445222199209020034");
		dv.setIDCardPhoto1("111");
		dv.setIDCardPhoto2("222");
		dv.setIdentificationNO("A");
		dv.setIp("11");
		dv.setIssuingLicenceAuthority("藏A:拉萨市公安局");
		dv.setLoginUser("445222199209020034");
		dv.setMailingAddress("深圳市宝安区");
		dv.setName("张宇帆");
		dv.setPhotoReturnNumberString("111");
		dv.setReceiverName("张宇帆");
		dv.setReceiverNumber("15920050177");
		dv.setSourceOfCertification("C");
		Map<String, String > map = new HashMap<>();
		map = handleService.driverLicenseInto(dv);
		System.out.println(map);
	}
	
	
	/**
	 * 驾驶证延期换证
	 * @throws Exception 
	 */
	@Test
	public void testRenewalDriverLicense() throws Exception{
		//http://192.168.1.245:8080/web/user/renewalDriverLicense.html?name=张宇帆&identificationNO=A&IDcard=445222199209020034&driverLicense=445222199209020034&fileNumber=123456&delayDate=20170701&delayReason=gg&sourceOfCertification=C&loginUser=445222199209020034&IDCardPhoto1=111&IDCardPhoto2=222&driverLicensePhoto=111&delayPhoto=111&receiverName=张宇帆&receiverNumber=15920050177&mailingAddress=深圳市宝安区       
		RenewalDriverLicenseVo rd = new RenewalDriverLicenseVo();
		rd.setBusinessType("Y");
		rd.setDelayDate("20170712");
		rd.setDelayPhoto("111");
		rd.setDelayReason("服兵役");
		rd.setDriverLicensePhoto("111");
		rd.setFileNumber("111");
		rd.setIDcard("622822198502074110");
		rd.setDriverLicense("622822198502074110");
		rd.setIDCardPhoto1("111");
		rd.setIDCardPhoto2("222");
		rd.setIdentificationNO("A");
		rd.setIp("11");
		rd.setLoginUser("622822198502074110");
		rd.setName("王玉璞");
		rd.setSourceOfCertification("C");
		Map<String, String > map = new HashMap<>();
		map = handleService.renewalDriverLicense(rd);
		System.out.println(map);
	}
	
	
	/**
	 * 驾驶证年审
	 * @throws Exception 
	 */
	@Test
	public void testDriverLicenseAnnualVerification() throws Exception{
		//http://192.168.1.245:8080/web/user/driverLicenseAnnualVerification.html?identificationNO=A&name=张宇帆&IDcard=445222199209020034&mobilephone=15920050177&placeOfDomicile=深圳&receiverName=11&receiverNumber=15920050177&mailingAddress=深圳市宝安区&IDCardPhoto1=111&IDCardPhoto2=222&livePhoto1=111&livePhoto2=222 &educationDrawingtable=111&foreignersLiveTable=222&postalcode=1&loginUser=445222199209020034&sourceOfCertification=C&userSource=C
		DriverLicenseAnnualVerificationVo dv = new DriverLicenseAnnualVerificationVo();
		dv.setBusinessType("N");
		dv.setEducationDrawingtable("111");
		dv.setForeignersLiveTable("22");
		dv.setIDcard("445222199209020034");
		dv.setIDCardPhoto1("111");
		dv.setIDCardPhoto2("222");
		dv.setIdentificationNO("A");
		dv.setIp("192.168.1.243");
		dv.setLivePhoto1("");
		dv.setLivePhoto2("");
		dv.setLoginUser("445222199209020034");
		dv.setMailingAddress("深圳市宝安区");
		dv.setMobilephone("15920050177");
		dv.setName("张宇帆");
		dv.setPlaceOfDomicile("深圳");
		dv.setPostalcode("1");
		dv.setReceiverName("111");
		dv.setReceiverNumber("222");
		dv.setSourceOfCertification("C");
		dv.setUserSource("C");
		
		Map<String, String > map = new HashMap<>();
		map = handleService.driverLicenseAnnualVerification(dv);
		System.out.println(map);
	}
	



	/**
	 * 补领机动车行驶证
	 * @throws Exception 
	 */
	@Test
	public void complementTheMotorVehicleDrivingLicense() throws Exception{
		//http://192.168.1.245:8080/web/user/driverLicenseAnnualVerification.html?identificationNO=A&name=张宇帆&IDcard=445222199209020034&mobilephone=15920050177&placeOfDomicile=深圳&receiverName=11&receiverNumber=15920050177&mailingAddress=深圳市宝安区&IDCardPhoto1=111&IDCardPhoto2=222&livePhoto1=111&livePhoto2=222 &educationDrawingtable=111&foreignersLiveTable=222&postalcode=1&loginUser=445222199209020034&sourceOfCertification=C&userSource=C
		VehicleDrivingLicenseVo vehicleDrivingLicenseVo = new VehicleDrivingLicenseVo();
		vehicleDrivingLicenseVo.setName("王玉璞");
		vehicleDrivingLicenseVo.setIDcard("622822198502074110");
		vehicleDrivingLicenseVo.setLicensePlate("粤B8888");
		vehicleDrivingLicenseVo.setLicensePlateTpye("02");
		vehicleDrivingLicenseVo.setPlaceOfDomicile("1");
		vehicleDrivingLicenseVo.setAddress("xxxxxx");
		vehicleDrivingLicenseVo.setReceiverName("XXXX");
		vehicleDrivingLicenseVo.setReceiverNumber("13666666666");
		vehicleDrivingLicenseVo.setMailingAddress("深圳市南山区xxx");
		vehicleDrivingLicenseVo.setLivePhoto1("11111111111111111");
		vehicleDrivingLicenseVo.setLivePhoto2("222222222");
		vehicleDrivingLicenseVo.setIDCardPhoto1("333333333");
		vehicleDrivingLicenseVo.setIDCardPhoto2("44444444444444444");
		vehicleDrivingLicenseVo.setDriverLicensePhoto("555555555555555555555");
		vehicleDrivingLicenseVo.setIp("192.168.1.1");
		vehicleDrivingLicenseVo.setSourceOfCertification("C");
		
		vehicleDrivingLicenseVo.setForeignPeopleLivingOnTheTable("xxxxxxxxxxxxxxxx");
		Map<String,Object> map = new HashMap<>();
		map = handleService.complementTheMotorVehicleDrivingLicense(vehicleDrivingLicenseVo);
		System.out.println(map);
	}
	


	/**
	 * 替换检验合格标志
	 * @throws Exception
	 */
	@Test
	public void testReplaceInspectionMark() throws Exception{
		ApplyInspectionMarkVo vo=new ApplyInspectionMarkVo();
		
		vo.setIdentityCard("445222199209020034");
		vo.setLicensePlateNo("粤B52J54");

		vo.setRecipientAddress("深圳市宝安区");
		vo.setRecipientName("肖乐");
		vo.setRecipientPhone("15920050177");
		vo.setSourceOfCertification("C");
		vo.setUserName("测试");

		vo.setIdCardImgNegative("123");
		vo.setIdCardImgPositive("123");
		vo.setIp("192.0.0.1");
		vo.setMobilephone("13878568562");
		vo.setPlaceOfDomicile("深圳南山区大冲商务中心");
	
		Map<String, String > map = new HashMap<>();
		map = handleService.replaceInspectionMark(vo);
		System.out.println(map);
	}
	
	/**
	 * 异地委托
	 * @throws Exception
	 */
	@Test
	public void testInspectionDeclaration() throws Exception{
		ApplyRemoteEntrustedBusinessVo vo=new ApplyRemoteEntrustedBusinessVo();
		
		vo.setIdentityCard("445222199209020034");
		vo.setAssociatedAgency("藏A");
		vo.setLicensePlateNo("粤B52J54");
		vo.setLicensePlateType("02");
		vo.setPostalcode("240000");
		vo.setProprietorship("0");
		vo.setRecipientAddress("深圳市宝安区");
		vo.setRecipientName("深圳市宝安区");
		vo.setRecipientPhone("15920050177");
		vo.setSourceOfCertification("C");
		vo.setUserName("测试");
		vo.setVehicleIdentifyNoLast4("1234");
		Map<String, String > map = new HashMap<>();
		map = handleService.inspectionDeclaration(vo);
		System.out.println(map);
	}
	
	
	/**
	 * 异地委托查询
	 * @throws Exception
	 */
	@Test
	public void testInspectionDeclarationQuery() throws Exception{
		ApplyRemoteEntrustedBusinessVo vo=new ApplyRemoteEntrustedBusinessVo();
		
		vo.setIdentityCard("445222199209020034");
		vo.setAssociatedAgency("藏A");
		vo.setLicensePlateNo("粤B52J54");
		vo.setLicensePlateType("02");
		vo.setPostalcode("240000");
		vo.setProprietorship("0");
		vo.setRecipientAddress("深圳市宝安区");
		vo.setRecipientName("深圳市宝安区");
		vo.setRecipientPhone("15920050177");
		vo.setSourceOfCertification("C");
		vo.setUserName("测试");
		vo.setVehicleIdentifyNoLast4("1234");
		Map<String, String > map = new HashMap<>();
		map = handleService.inspectionDeclaration(vo);
		System.out.println(map);
	}
}
