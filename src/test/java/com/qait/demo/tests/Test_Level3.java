package com.qait.demo.tests;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;

public class Test_Level3 {
	
	TestSessionInitiator test;

     String base_Url;
     
	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
		initVars();
		
		test.launchApplication(base_Url);
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		test.stepStartMessage(method.getName());
	}

	private void initVars() {
	
		base_Url = getYamlValue("base_Url");
	}
	
	@Test()
	public void TestStep01_SearchProduct(){
		test.homePage.enterProductName(getYamlValue("productName"));
		test.homePage.clickSearchIcon();
	}

	@Test() 
	public void TestStep02_Verify_User_Is_Able_To_View_Ratings_Of_The_Product(){
		test.homePage.verify_User_Is_Able_To_View_Ratings();
		
	}
	
	
	@Test() 
	public void TestStep03_Verify_Feilds_Are_Expandable(){
		test.homePage.verify_User_Is_Able_To_Expand_The_BrandOptions();
	}
	
	
	@Test() 
	public void TestStep04_Verify_Select_Dropdown_Is_Present(){
		test.homePage.verify_User_Is_Able_To_View_Select_Disciplin_With_NoDisciplin_Selected_Initaially();
	}

	
	@Test()
	public void TestStep05_Verify_User_Navigates_To_New_Window(){     
		test.homePage.Verify_User_Navigates_To_New_Window();
	}
	
	@Test()
	public void TestStep06_Verify_User_Is_Able_To_Naviagte_On_Clicking_The_Product(){
		test.homePage.verify_User_Navigates_To_Product_Page();
	}
	
	
	                              //*******new test cases***********//
	
	@Test()
	public void TestStep07_Verify_The_User_Is_Able_To_Compare_The_Product(){
		test.cartPage.verify_Checkbox_Is_Initially_Unchecked();
	}
	
	
	@Test()
	public void TestStep08_Verify_User_Is_Able_To_View_Compare_Menu(){
		test.cartPage.verify_User_Is_Able_To_Go_To_Compare_Button();
		
	}
	@Test()
	public void TestStep09_Verify_User_Is_Able_To_View_Pop_Up_After_Clicking_Comapri_Btn(){
		test.cartPage.verify_User_Is_Able_To_check_Pop_Up_On_Cart_Page();
		test.cartPage.verify_User_Navigated_To_Compare_Page();
	}
	
	@Test()
	public void TestStep10_Verify_User_Is_Able_To_Compare_The_Product(){
		test.cartPage.verify_Comparing_Feilds_Are_Empty();
		
	}
	
	@Test()
	public void TestStep11_Verify_User_Is_Able_To_Compare_The_Product(){
		test.cartPage.verify_User_Compares_The_Product();
	}
	
	@Test()
	public void TestStep12_Verify_User_Is_Able_To_Navigate_To_Main_Window(){
		test.cartPage.verify_User_Switches_To_Previous_Window();
	}
	//****//
	
	@Test() 
	public void TestStep13_Verify_User_Is_Able_To_Verify_PinCode(){
		test.cartPage.verify_User_Is_Able_To_View_Pincode_Bar();
	}
	
	@Test  
	public void TestStep14_Verify_Similar_Products_Are_Presnt_For_Product_Details_Page(){
		test.cartPage.Verify_User_Is_Able_To_View_Similar_Items();
	}
	
	@Test() 
	public void TestStep15_Verify_User_Is_Able_To_Buy_The_Product(){
		test.cartPage.verify_User_Is_Able_To_Buy_Product();
	}
	
	@Test() 
	public void TestStep16_Verify_User_Navigated_To_Shipping_Page(){
		test.cartPage.verify_User_Navigated_To_Shipping_Cart_Page();
	}
	
	@Test
	public void TestStep17_Verify_User_Is_Able_To_SignUp_For_Application(){
		test.cartPage.verify_User_Is_Able_To_Enter_EmailAddress("priyankasthapak@gmail.com");
	}
	
	@Test 
	public void TestStep18_Verify_Edit_Button_Appears_After_Entering_EmailAddress(){
		test.cartPage.verify_User_Is_Able_To_Edit_The_Email_Address("xyz@gmail.com");
	}
                                    //****//
	@Test()
	public void TestStep19_Verify_User_Switches_Back_To_Home_Page(){
		test.cartPage.verify_User_Navigates_To_Home_Page();
	}
	
	@Test()
	public void TestStep20_Verify_User_Searches_For_Out_Of_Stock_Product(){
		test.homePage.enterProductName(getYamlValue("productName"));
		test.homePage.clickSearchIcon();
	}
	
	@Test()
	public void TestStep21_Verify_User_Is_Able_To_Select_Out_Of_Stock_Product(){
		test.homePage.verify_User_Chooses_Out_Of_Stock_Product();
	}
	
//	@Test()
//	public void TestStep22_Verify_Suitable_Message_Is_Dispalyed_For_The_Product(){
//		test.homePage.verify_Suitable_Text_Is_Dispalyed();
//	}
	
	
	
}	
	
//	@AfterMethod
//	public void take_screenshot_on_failure(ITestResult result) {
//		test.takescreenshot.takeScreenShotOnException(result);
//	}
//
//	@AfterClass
//	public void close_Test_Session() {
//		test.closeBrowserSession();
//	}
//}
