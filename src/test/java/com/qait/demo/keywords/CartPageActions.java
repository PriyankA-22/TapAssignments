package com.qait.demo.keywords;

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
	private EventFiringWebDriver e_driver;

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
	}


