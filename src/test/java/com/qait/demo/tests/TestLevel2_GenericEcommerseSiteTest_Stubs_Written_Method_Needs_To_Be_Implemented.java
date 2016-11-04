/**
* This is a sample test 
* Step 1 : Open snapdeal.com/amazon.com/flipcart.com
* Step 2 : Search A product - Mobile
* Step 3 : Select First Product
* Step 4 : Add the product to cart
* Step 5 : Verify the product has been added to cart
* 
* Task : Stubs are already written , you have to implement them and run this test
*/

package com.qait.demo.tests;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.utils.YamlReader;

public class TestLevel2_GenericEcommerseSiteTest_Stubs_Written_Method_Needs_To_Be_Implemented {

	TestSessionInitiator test;
	//String baseUrl;
     String base_Url;
     
	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
		initVars();
		//test.launchApplication(baseUrl);
		test.launchApplication(base_Url);
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		test.stepStartMessage(method.getName());
	}

	private void initVars() {
		//baseUrl = getYamlValue("baseUrl");
		base_Url = getYamlValue("base_Url");
	}
	
	@Test()
	public void TestStep01_SearchProduct(){
		test.homePage.enterProductName(getYamlValue("productName"));
		test.homePage.clickSearchIcon();
	}

	@Test()
	public void TestStep2_VerifySearchResult(){
		test.resultPage.verifyResults(getYamlValue("productName"));
	}
	
	@Test()
	public void TestStep3_SelectFirstProduct(){
		test.resultPage.clickFirstProduct();
	}
	
	@Test()
	public void TestStep4_AddProductToCart(){
		test.productDetailsPage.AddTheProductToCart();
	}
	
	@Test()
	public void TestStep5_VerifyCart(){
		test.cartPage.verifyCart();
	}
	

	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() {
		test.closeBrowserSession();
	}


}