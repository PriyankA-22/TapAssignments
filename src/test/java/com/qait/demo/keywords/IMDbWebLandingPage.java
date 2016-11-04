package com.qait.demo.keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMDbWebLandingPage {
 WebDriver driver ;
 
 public IMDbWebLandingPage(WebDriver browser) {
  this.driver=browser;
  this.driver.get("http://www.imdb.com/");
  this.driver.manage().window().maximize();
 }
     //return list of webElements
 
 public IMDbWebResultList searchFor(String movie) {
  
  driver.findElement(By.xpath("//input[contains(@placeholder,'Find Movies, TV shows)]")).sendKeys(movie);
  
  driver.findElement(By.xpath("//button[@id='navbar-submit-button']")).click();;
  
        List<WebElement> list= driver.findElements(By.xpath("//h3[text()='Titles']/../table//td[@class='result_text']/a"));
    
      return new IMDbWebResultList(list);
  
   
 }

}