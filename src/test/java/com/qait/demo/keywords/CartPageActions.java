package com.qait.demo.keywords;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

public class CartPageActions extends GetPage {

	WebDriver driver;

	public CartPageActions(WebDriver driver) {
		super(driver, "HomePage");
		this.driver = driver;

	}

	public void verifyCart() {
		
   //Assert.assertTrue(element("view_cart").isDisplayed(), "[ASSERT FAILED]: Search Results not Found");
		for(String winHandle : driver.getWindowHandles()){
	        driver.switchTo().window(winHandle);
	   }
   Assert.assertTrue(element("flipkart_place_order").isDisplayed(), "[ASSERT FAILED]: Search Results not Found");
		
	}

	public void verify_User_Is_Able_To_View_Pincode_Bar() {
		Assert.assertTrue(element("pincode_bar").isDisplayed(),"[ASSERT FAILED]: User Is Not Able To View The PinCode Bar");
		
	}

	public void Verify_User_Is_Able_To_View_Similar_Items() {
	  Assert.assertTrue(element("similar_products").isDisplayed(),"[ASSERT FAILED]: User Is Not Able To access the Similar Products");
		
	}

	public void verify_User_Is_Able_To_Buy_Product() {
		element("buy_product").click();
		
	}

	public void verify_User_Navigated_To_Shipping_Cart_Page() {
		boolean response= element("continue_btn").isDisplayed();
		verifyPageTitleContains("Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
		Assert.assertTrue(response,"[ASSERT FAILED]: Shipping Cart Is Displayed with Continue Btn");
	}

	public void verify_User_Is_Able_To_Enter_EmailAddress(String data) {
		element("email_feild").sendKeys(data);
		
	}

	public void verify_User_Is_Able_To_Edit_The_Email_Address(String name) {
	   element("continue_btn").click();
	   boolean response= element("edit_btn").isDisplayed();
	   element("edit_btn").click();
	   wait.hardWait(2);
	   element("email_feild").click();
	   element("email_feild").clear();
	   element("email_feild").sendKeys(name);
	   Assert.assertTrue(response,"[ASSERT FAILED]: User Is Not Able To Edit the Email Address");
		
	}
	
	public void verify_Checkbox_Is_Initially_Unchecked() {
		Assert.assertTrue(element("default_checkbox").isEnabled(),"[ASSERT FAILED]: Checkbox is Enabled");
		
	}

	public void verify_User_Is_Able_To_check_Pop_Up_On_Cart_Page() {
		
   	Assert.assertTrue(element("compare_popup").isDisplayed(),"[ASSERT FAILED]: Compare_Popup Is Not Dispalyed");
  	element("compare_btn").click();
		
	}

	public void verify_User_Navigated_To_Compare_Page() {
		verifyPageTitleContains("Compare Store Online - Buy Compare Products Online at Best Price in India | Flipkart.com");
		
	}

	public void verify_User_Is_Able_To_Go_To_Compare_Button() {
		element("default_checkbox").click();
	}

	public void verify_Comparing_Feilds_Are_Empty() {
	   Assert.assertTrue(element("compare_fields").isDisplayed(),"[ASSERT FAILED]: Comparing Feilds Not Present"); 

	}

	public void verify_User_Compares_The_Product() {
		element("brand_dropdown").click();
		element("brand_name").click();
		wait.hardWait(1);
		element("product_name").click();
		// elements("choose_product").get(elements("choose_product").size()-1).click();
		element("choose_product").click();
		
	}
	
	public void verify_User_Switches_To_Previous_Window(){
	     webdriver.navigate().back();
	
}

	public void verify_User_Navigates_To_Home_Page() {
	    wait.hardWait(1);
	   element("flipkart_logo").click();
		
	}

	public void verify_User_Is_Able_To_View_Success_Message() {
		
		element("enter_id").sendKeys("474005");
		element("notify_me").click();
		
	}

	public void verify_Cart_Does_Not_Accept_Zero_As_A_Quantity() {
		element("cart_button").click();
		verifyPageTitleContains("Flipkart.com: Shopping Cart");
		element("cart_field").click();
		element("cart_input").clear();
		//element("cart_field").sendKeys(String.valueOf(quantity));
		element("cart_input").sendKeys("0");
		element("save_btn").click();
		element("back_homepage").click();

	}

	public void verify_Product_Is_Available_Only_For_Valid_PinCode() {
		 element("change_btn").click();
		 element("pincode_feild").clear();
		 element("pincode_feild").sendKeys("456532");
		 element("change_btn").click();
		
		
	}

	public void verify_Valid_Id_Is_Acceptable() {
		element("change_btn").click();
		element("pincode_feild").clear();
		element("pincode_feild").sendKeys("474005");
		
	}

	public void verify_User_Is_Able_To_View_Different_Version_Of_The_Product() {
		element("product_color").click();
		
	}

	public void verify_User_Can_Sign_Up_After_Adding_Product_In_cart() {
		element("cart_button").click();
		element("sign_up").click();
		
	}


	public void verify_User_Is_Able_To_Enter_Credentials(String data) {
		verifyPageTitleContains("Flipkart.com: Login");
		element("email_btn").click();
		element("email_btn").sendKeys(data);
		
	}

	public void verify_User_Successfully_Logs_In(String pwd) {
		element("passwd_feild").click();
		element("passwd_feild").sendKeys(pwd);
		Assert.assertTrue(element("login_btn").isEnabled(),"[ASSERT FAILED]: Login Button Is Enabled after Filling the Feilds");
		
		
		
	}

	public void verify_User_Is_Able_To_Sign_Up_For_Login_Page() {
		element("sign_in_btn").click();
		element("sign_feild").sendKeys("0987654321");
		
	}

	public void verify_User_Is_Able_To_Navigate_Back_To_Shipping_Page() {
		element("close_icon").click();
	//	Assert.assertTrue(element("continue_btn").isEnabled(),"[ASSERT FAILED]: Continue Button Is Not Disabled");
	}

	
		
	}

	
		
	




