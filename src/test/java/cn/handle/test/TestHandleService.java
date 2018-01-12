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

import cn.handle.bean.vo.ApplyCarTemporaryLicenceVo;
import cn.handle.bean.vo.ApplyGatePassVo;
import cn.handle.bean.vo.ApplyInspectionMarkVo;
import cn.handle.bean.vo.ApplyRemoteEntrustedBusinessVo;
import cn.handle.bean.vo.CarMortgageVo;
import cn.handle.bean.vo.CreateVehicleInspectionVo;
import cn.handle.bean.vo.DelegateVehiclesVo;
import cn.handle.bean.vo.DriverChangeContactVo;
import cn.handle.bean.vo.DriverLicenseAnnualVerificationVo;
import cn.handle.bean.vo.DriverLicenseIntoVo;
import cn.handle.bean.vo.DriverLicenseVoluntaryDemotionVo;
import cn.handle.bean.vo.RenewalDriverLicenseVo;
import cn.handle.bean.vo.RepairOrReplaceDriverLicenseVo;
import cn.handle.bean.vo.VehicleDrivingLicenseVo;
import cn.handle.service.IHandleService;
import cn.sdk.bean.BaseBean;
import cn.sdk.webservice.WebServiceClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:junit-test.xml" })
public class TestHandleService {
	@Autowired
    @Qualifier("handleService")
    private IHandleService handleService;
	
	
	@Test
	public void testapplyOrCancleCarMortgage()throws Exception{
		CarMortgageVo cv = new CarMortgageVo();
		cv.setBusinessType("A");
		cv.setCarCode("LSGSA52S5AY249094");// <hphm>B6F7M1</hphm>
		cv.setCarNumber("B6F7M1");
		cv.setCarType("0");
		cv.setMainContractNo("123");
		cv.setMortgageContactNo("213");
		cv.setMortgageeAddr("深圳市高老庄");
		cv.setMortgageeIDcard("445222199209020034");
		cv.setMortgageeName("八戒");
		cv.setMortgageeSex("男");
		cv.setMortgagerAddr("花果山");
		cv.setMortgagerIDcard("213");
		cv.setMortgagerName("八小戒");
		cv.setMortgagerSex("男");
		cv.setNumberPlate("02");
		cv.setOwnerPhone("123456");
		cv.setReceiverAddr("深圳市水帘洞");
		cv.setReceiverCode("111111");
		cv.setReceiverName("小八戒");
		cv.setReceiverPhone("12345");
		cv.setRecipientAddr("深圳市火焰山");
		cv.setRecipientCode("222222");
		cv.setRecipientName("猪八戒");
		cv.setRecipientPhone("12345");
		cv.setRegistrationNO("21321");
		cv.setSourceOfCertification("M");
		cv.setSqlx("31");
		BaseBean bean = handleService.applyOrCancleCarMortgage(cv);
		System.out.println(bean.toJson());
		
	}
	
	@Test
	public void testqueryCarMortgage()throws Exception{
		BaseBean bean = handleService.queryCarMortgage("445222199209020034", "31", "M");
		System.out.println(bean.toJson());
	}
	@Test
	public void testelectronicDelegateVehicles() throws Exception{
		DelegateVehiclesVo dv = new DelegateVehiclesVo();
		dv.setBusinessType("jdc");
		dv.setBusinessReason("B");
		dv.setBailerName("张宇帆");
		dv.setBailerIdentityCard("445222199209020034");
		dv.setBailerLicenseNumber("粤B6A42E");
		dv.setBailerNumberPlate("02");
		dv.setBailerValidTime("15");
		dv.setBaileeName("开发测试");
		dv.setBaileeIdentitycard("123456789123456789");
		dv.setBaileeMobilephone("13627267056");
		dv.setUserSource("Z");
		BaseBean baseBean = handleService.electronicDelegateVehicles(dv);
		System.out.println(baseBean);
	}
	/**
	 * 
	 */
	@Test
	public void test1() throws Exception{
		JSONObject jsonObject = handleService.getVehicleInspection("P170907161", "", "");
		System.out.println(jsonObject);
	}
	/**
	 * 六年免检预约
	 * @throws Exception
	 */
	@Test
	public void testcreateVehicleInspection() throws Exception{
		CreateVehicleInspectionVo createVehicleInspectionVo = new CreateVehicleInspectionVo();
		createVehicleInspectionVo.setPlatNumber("粤B6A42E");
		createVehicleInspectionVo.setName("测试");
		createVehicleInspectionVo.setPersonType("1");
		createVehicleInspectionVo.setDriveLicenseNumber("");
		createVehicleInspectionVo.setMobile("15920071829");
		createVehicleInspectionVo.setTelno("");
		createVehicleInspectionVo.setRecipientsName("测试");
		createVehicleInspectionVo.setRecipientsMobile("11");
		createVehicleInspectionVo.setPostCode("11");
		createVehicleInspectionVo.setPostAddr("测试");
		createVehicleInspectionVo.setEffectiveDate("2017-01-01");
		createVehicleInspectionVo.setTerminationDate("2017-08-01");
		createVehicleInspectionVo.setInform("1");
		createVehicleInspectionVo.setBookerName("");
		createVehicleInspectionVo.setBookerIdNumber("");
		createVehicleInspectionVo.setBookerType("0");
		createVehicleInspectionVo.setCarTypeId("e4e48584399473d20139947fff4e2b2e");
		BaseBean createVehicleInspection = handleService.createVehicleInspection(createVehicleInspectionVo);
		System.out.println(createVehicleInspection);
	} 
	/**
	 * 首违免罚查询
	 */
	 @Test
	 public void testgetResultOfFirstIllegalImpunity() throws Exception{
		 String numberPlate = null;
		 String plateType = "";
		 String id = "4403197900206196";
		 String  queryType = "2";
		 Map<String, Object> map = handleService.getResultOfFirstIllegalImpunity(numberPlate, plateType, id, queryType);
		 System.out.println(map);
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
		rv.setIDcard("42138119910422133X");
		rv.setIDCardPhoto1("111");
		rv.setIDCardPhoto2("222");
		rv.setIdentificationNO("A");
		rv.setIp("11");
		rv.setLivePhoto1("111");
		rv.setLivePhoto2("222");
		rv.setLoginUser("42138119910422133X");
		rv.setMailingAddress("深圳市宝安区测试账号");
		rv.setName("张宇帆");
		rv.setPhotoReturnNumberString("123456");
		rv.setPlaceOfDomicile("深圳");
		rv.setPostalcode("");
		rv.setReceiverName("333");
		rv.setReceiverNumber("15920050177");
		rv.setRepairReason("");
		rv.setSourceOfCertification("M");
		rv.setUserSource("M");
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
		rv.setIDcard("42138119910422133X");
		rv.setIDCardPhoto1("111");
		rv.setIDCardPhoto2("222");
		rv.setIdentificationNO("A");
		rv.setIp("11");
		rv.setLivePhoto1("111");
		rv.setLivePhoto2("222");
		rv.setLoginUser("42138119910422133X");
		rv.setMailingAddress("深圳市测试账号");
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
		dv.setSourceOfCertification("M");
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
		dv.setSourceOfCertification("G");
		dv.setUserSource("G");
		
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
		vehicleDrivingLicenseVo.setName("杨明畅");
		vehicleDrivingLicenseVo.setIDcard("440301199002101119");
		vehicleDrivingLicenseVo.setLicensePlate("粤B8885");
		vehicleDrivingLicenseVo.setLicensePlateTpye("02");
		vehicleDrivingLicenseVo.setPlaceOfDomicile("1");
		vehicleDrivingLicenseVo.setAddress("xxxxxx");
		vehicleDrivingLicenseVo.setReceiverName("XXXX");
		vehicleDrivingLicenseVo.setReceiverNumber("13666666666");
		vehicleDrivingLicenseVo.setMailingAddress("深圳市南山区测试数据");
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
		vo.setLicensePlateNo("粤B6A42E");
		vo.setLicensePlateType("02");

		vo.setRecipientAddress("深圳市宝安区");
		vo.setRecipientName("测试");
		vo.setRecipientPhone("15920050177");
		vo.setSourceOfCertification("M");
		vo.setUserName("测试");

		vo.setIdCardImgNegative("data:image/jpeg;base64,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…l3P0aWVjzI57sSTX5ZnOcV83lz4l2tsl+p+lZNlFHLrxwyvfdszfhh8JdH8Cy3GtT3sur+JL9E/tXW7ra1xdsAeOBhEGfupgHAz0rvrGAwLsaUyMM/NgKMZz0HH41LHaQRALGpUKCAAePyp6oqHK9TXytR1qlVTb0PraNKFKHKtxxpKKK2NAo/GiigAooooAXvVK4/1zfh/KrlU7j/XN+H8qALcX+rT/dFOpsf+rT/dH8qdQIKKKSgELmjNJRQMKOKKKAChlV1KOAQwwQfSiigCFLa2gUQwwKi5yAB0NeOfEX4G6dq/ilPGvw910+CvGiIETULKFHiv1AP7q7tn+S4X/a++uc56V7Vx3AoKqSCQCR0OOlFJzpTck9DCvQjWjZnzFeeKdC1qxHwn/af8EaTpN1eSlbe9+0b9Hu5MnEsF3Jho5z2hOCOgyK8E+M/7BHinR473xD8JL5dasYx5zWEvyXKIOTsx9846DvX3t4p8MaD4p0270LxHpFtqGnX6GGa0uYfMikBGORjivEG+EvxQ+F+dT+C2qJq2kJjd4P8AEVzKba2VRz/Z10f3sGQP9W/yHIGQOa9zAZ1iMulz4Z2b3XRnzmOyqjjlyYiN0tmfmdqunPotzLpmpwTxX0fDW1xB5E0B/wBtfWs2v0m8V/8ACjfj86+Dvi/4Sk8JeLSPIih1mOO0vwxPH2e7X91cLj/lmrMeOnevBPin+wN4/wDCr3N58MZoPFWlRjc1lLOsN7HkZHJ4YDGcdTkYr9Cy3jDD4myxsfZP1v8Aoj4PG8L4ijL/AGV+0Xe1v1Z8qUVo65oer+GrsaR4h0640q/EjL9guo2SVemT8wBI6dBWfIvlxGZ+Iwdpc/dB9CfWvrqVSliKftaEk0fO1qE8PP2dVWYlFCp5ihlYEHoc8GjGOPSny1FrJaGbcPsvUKKKKBBRRRQAUUUUAFFFFABRRRQAUUUUAFFIrKxYKwJXqAen1oIVRlmA+potJ/ChrlXxMWikdmhIUQSSSEbkiT77+m0d69z+Ff7G/wAYfiP5d3rmlr4V0WRfNlutSBWRFxlT5TYOD2PSvPxma4XAfx52Z14bL8Ti/wCDBtHhy7C4WSVkDcDam4k9gBXvXwP/AGPPif8AFeT7ZqqweG/DszKo1K+j/wBImQjJWCIjlj/f7V9LaF8F/wBnD9l37DqXibUIdW8UPHusY5Ize310xOMW1jHlnOeN5XaPUV3kVp8d/jBNGk9g3ww8MY3KDOtx4gZD2+X91ZswPDoWdRxgGvhs24sqYi9PBy5Y9/8AgH22U8MU6NqmLhzS7HO2Wk/Bb9l17XwJ8PfDV14m8fXSGa106weObV7pBje0kzDbFFzkiUgAfd7Vv6d8KvFHxHkh1T45X9vLYxP9qs/COnsz2UBJ48+dsG5lGTlG4z04r034e/Cfwn8PLS5h8OaLb2d1qBDXmoOhlvrx+Nz3E55lcnq55P4V3gVSoHlge3HFfB1MViPaOan7z3Z93TwGHlTUXG0ei7GZpemafZW1vDY2UUEUMapEiRBBGuOgUfd47VdTYGCKgChsgAY5qfijj0FcXLNu7kdtKnGkrJAaSiitSwooooAPpRRRQAUUUfhQAVTuP9c34fyq5VO4/wBc34fyoAtxf6tP90U6mx/6pP8AdFLQJBRRRQMWkoooAKKKKACiiigApc0lFABj2/SkZcqRt6jtThRRcVl2OV8UfD3wh430uXS/GPhe01mCVPL2XUSsVB9GGCvrkHNeVSfCP4pfDNfM+E3jl7zSYyDF4d8TyG7S3wOIrK7/ANZErcg7w2MDFfQFQXcbSxBUCk5H3u3v9acLJpz19TGrH3Gqat6HzDrvj7wDrlsugftR/CKbw3KVaM3WoW41DTh/tDUEG6PjH3wo6YJPFee+I/2EPhZ40spPEXwd8fGyt5l8y1aW4TULE55xFKp3Ivtg9+a+zrzREu4Wtph9ogdSJIbjEiSexDAjH4GvKdW/Za8D3OpXWveFTdeCNYuJBINR8K3L2M3uHU7onHt5Yr1aGY1KPu0qjiuyeh4k8thVfNUppvz3PgTxz+x98fvBMUurw6Fb69YRnD3GlXAncKBjcFbDH6AcdK8av7O60uc22pQ3NtODjyryIwzn6xthgfwr9W38PftJ+CPLTSPFvhbx5bR5Bi1mA6bqEidQBPEGR3x3KIK5/XPib4eZJ9N+OnwD1zTo4YPPmvLnTotZtUHos0GZR+CV9VhON8RhoqnWp+0Xk9fxPnMVwbSxEnOnP2b81o/uPzBMLqNzFFGM8uo/rUasjcrIjA85Dgj86/Qm8+Dv7CvxOlWy8NXtloeqkZNpaXj6ZdKT0cwXCh/flcevFY2r/wDBOTwxqU6XXhD4qXMatnbHf2kN4GOO7IyjpntX0dDjLAyV8RTlB9n1PCqcI4mLtSqRn5o+DwwJwM/XHH50tfVesf8ABPj4oW989novi3wbeuoL7GE8E5X1KJG4A5H6c1ymo/sPftE2blbPwnp2pBc5NtqMKY9OJShOfYHpzjivSo8RZRXjz/WFDyktThqcP46jLl9hKXmnp+R8/wBFeyS/sjftHRbgfhRqLFTjCvEc/Q7sH86gH7KX7RGPm+FV+h/uvNArD8C+RW39t5Qt8XH7n/mZ/wBi47/oGn9//APIqK9gi/ZN/aNlkEY+EuqAHneTFt/MNg1qWX7F37R92hkf4eraqvJNzeQJgeuNxJ+gBPtSeeZRFczxcfuf+Y/7Ex70WGn9/wDwDwvk8BWY+igk/pTvKYIzs0aheoaRQfyJya+nNM/4J/8AxpuYUutY1nwppdu33/OubgunpwIQvXj71eg6N/wTrgtUiuvFHxLuAkq7A2m6WpEbnncZCSQuARkhRnHPauCXFmTJXhXUn2Sd2ax4ZzVv3qDiu7asfDqyI+dhLEdQoJP5dafEss8620FtcSzOQBEkLM/12gZx79K/QGf9ln9j34Xslz8QfGa3jyqZXk1HWk/fbewhT5nPPRQfwrqPBni/4DeEJWtfgZ8F9X1aWVm8ttF8MS25Z8D5muLooNuAOQT0NePX41ouXJh43fmerT4PrRh7SvLTyPiXwL+zf8ZfiHcQ2+j+AdSEMyF4r6+drW1RckE5YDfyD93PNfQXw+/4J7Suh1f4pfEMQouUeDSgqxjnkGR+Px619EWs37Sfiy6lbT/DPhnwLZuu1Z9XmfU79cr2jTbC3PbcOwqaH9l7TvEnlX3xj8b6748vVUEQ3chs7FDwcLbQEDAOcAk8d+9eDi+MMXik6SagvLf8z2sJwnh6FqjTk/Pb8jgtDm/Zp+BxHhz4ZeEJvFHiC3cQ+XoNp/bF/GOzXFw4CW65xlmYAV1Fj4b/AGj/AImqIPEVzb/C/Q5tzrbaXejUNbdMkqWuXHl27cDhA4GcV7N4a8C+HPCdrHYeHdGsdMt4guyKzt1iUEeuPmb/AIETW9bxTxqvnSLLISd7njA7ACvl6uKlJvmblfq9T6ujgoOzS5bdFoed/D74H+Bvhu8114e8OxrqNzILi81K4Aubu9l7yyyyHJlJySyhRycAV6KivuZmjUA47fMfrUtGa4X5HpRioqwLnHTFBozSUx2CijmigYUe9FFABRRR+FABRRRQAUUUUAFU7j/XN+H8quGqdz/rm/D+VAFuP/VJ/uj+VLzVITygAB+AMdBS/aJv7/6CgC5RVP7RN/f/AEFH2ib+/wDoKALlFU/tE39/9BR9om/v/oKALlFU/tE39/8AQUfaJv7/AOgoAuUVT+0Tf3/0FH2ib+/+goAuUVT+0Tf3/wBBR9om/v8A6CgC5S1S+0Tf3/0FH2ib+/8AoKALtByelUvtM39/9BR9pm/v/oKTSkrMWxcwaTafWqn2mb+/+go+0zf3/wBBWcaMIu6Kuyc2ytKZJCH6YDKCF+nGf1qOS0laRpEmQEnoV4I9xnmmfaZv7/6Cj7TN/f8A0FU4KXV/eFzn/EPwu8F+LTMPE3hvSNSWeFoJFuLCJyysCDlyvmcgkY3Y5riZf2UPhEjxNoVlq/hxIvuw6FrN3YQ+37uKQKcZ9K9W+0zf3/0FH2mb+/8AoK2jVnFWuc88NTm7tfdoeVW/wD8V6XcPcaD+0H8QLZdnlxW9zcw3kCL/ALs0bEngc7s4+tU7n4a/tE2ErT2Px30O9X+CO98Gwq3/AAKSOQZ/KvYftM39/wDQUx5JJCpaRxt6bWK/y61osRNdF9y/yM3gqb7/AHv/ADPEpdN/a6hTNn4j+GFwQeQ9jfAseOpUkDPp2qru/bVHAT4NAf8ATU6tu/HauPyr3C7iim2zSxI7jChioJxz/iapwxRPGGaJCT/siqVaT6L7kedVwijNpSdvV/5nkbWn7Ys2x/7Z+FMLFRuRbLU3UHvgkdPerEXgn9pnWUCXnxm8K6IDwI9M8NNdqf8AeM0ter+RB/zxT/vkVJJcTtcQ/vnHzdAxAPI7Cn7eS6L/AMBX+RUcPBtJt/8AgT/zPNW+CHxR1JVXXv2kvFarwXj0extNPRsehCMy/g1MX9lTwJfS+b4s17xX4l3DEqatrtzNHKOuGj3BfyA6n1r1z7TN/f8A0FH2mb+/+gqfrM73Vl6JL8kdiy+j1u/WUn+pxfh74DfCvwkYl8NeB9BsIYsHyk0yB8sOh3OpYH6EV2kemCMqqykRoMIilgB7YzjHtR9pm/v/AKCj7TN/f/QVk5ybuzoVCCjy20JUtTGzMshIZt20jheP4R2qYKQMZqp9om/v/oKPtE39/wDQVj7OKbl1Nl7qsi5tPrSmqX2mb+/+go+0zf3/ANBVJWB6lyj+lU/tE39/9BR9om/v/oKYFyiqf2ib+/8AoKPtE39/9BQBcoqn9om/v/oKPtE39/8AQUAXKKp/aJv7/wCgo+0Tf3/0FAFyiqf2ib+/+go+0Tf3/wBBQBco96p/aJv7/wCgo+0Tf3/0FAFyiqf2ib+/+go+0Tf3/wBBQBcqncf65vw/lR9om/v/AKCo2ZnYsxyTQB//2Q==");
		vo.setIdCardImgPositive("data:image/jpeg;base64,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…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");
		vo.setIp("192.0.0.1");
		vo.setMobilephone("15920050177");
		vo.setPlaceOfDomicile("0");
	
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
		vo.setCarOwnerIdentityCard("445222199209020034");
		vo.setAssociatedAgency("藏A");
		vo.setLicensePlateNo("粤B6A42E");
		vo.setLicensePlateType("02");
		vo.setPostalcode("240000");
		vo.setProprietorship("0");
		vo.setRecipientAddress("深圳市宝安区");
		vo.setRecipientName("测试");
		vo.setRecipientPhone("15920050177");
		vo.setSourceOfCertification("M");
		vo.setUserName("测试");
		vo.setName("ceshi");
		vo.setVehicleIdentifyNoLast4("5563");
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
		vo.setSourceOfCertification("C");
		Map<String, String > map = new HashMap<>();
		map = handleService.inspectionDeclarationQuery("440301199002101119","C");
		System.out.println(map);
	}
	
	/**
	 * @Title: testApplyGatePass
	 * @Description: TODO(申请通行证(外地车))
	 * @param @throws Exception    参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public void testApplyGatePass() throws Exception{
		ApplyGatePassVo vo = new ApplyGatePassVo();
		vo.setAbbreviation("粤");
		vo.setNumberPlate("A12345");
		vo.setPlateType("02");
		vo.setCartype("K31");
		vo.setVin("1234");
		vo.setUserName("开发测试");
		vo.setIdentityCard("");
		vo.setMobilephone("13800138000");
		vo.setApplyDate("2017-10-30");
		
		Map<String, String > map = new HashMap<>();
		map = handleService.applyGatePass(vo);
		System.out.println(map);
	}
	
	/**
	 * @Title: testApplyCarTemporaryLicence
	 * @Description: TODO(申请机动车临牌)
	 * @param @throws Exception    参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public void testApplyCarTemporaryLicence() throws Exception{
		ApplyCarTemporaryLicenceVo vo = new ApplyCarTemporaryLicenceVo();
		vo.setUserName("测试张三");
		vo.setIdentityCard("31232123123213123");
		vo.setCartModels("a123");
		vo.setCartype("c1");
		vo.setEngineNumber("123421");
		vo.setVin("2222");
		vo.setCarOrigin("A");
		vo.setReceiverName("测试张三");
		vo.setReceiverAddress("深圳市南山区");
		vo.setReceiverNumber("13111111111");
		vo.setPHOTO9("aa");
		vo.setPHOTO10("aa");
		vo.setPHOTO26("");
		vo.setPHOTO27("");
		vo.setPHOTO28("");
		vo.setPHOTO29("");
		vo.setPHOTO31("");
		vo.setIp("123213");
		vo.setSourceOfCertification("C");
		vo.setPlaceOfDomicile("1");
		
		Map<String, String > map = new HashMap<>();
		map = handleService.applyCarTemporaryLicence(vo);
		System.out.println(map);
	}
}
