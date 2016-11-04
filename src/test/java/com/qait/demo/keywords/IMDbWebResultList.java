package com.qait.demo.keywords;

import java.util.List;

import org.openqa.selenium.WebElement;

public class IMDbWebResultList  {
 List<WebElement> list;
 WebElement movieElement=null; 
 public IMDbWebResultList(List<WebElement> list) {
  this.list=list;
 }
   
 public IMDbWebResultList  getResult(int i)
 {
  this.movieElement=list.get(i);
  return this;
 }
  
 public String getTitle()
 {   
  return this.movieElement.getText();
  
  
  
 }
}
