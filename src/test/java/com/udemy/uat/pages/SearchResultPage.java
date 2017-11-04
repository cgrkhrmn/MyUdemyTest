package com.udemy.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udemy.uat.utilities.Driver;

public class SearchResultPage {
	public SearchResultPage(){
		PageFactory.initElements(Driver.getInstance(), this);	
	}
	
	@FindBy(xpath=("(//div[@class='search-results-header'])[1]"))
	public WebElement searchItemName;
	
	
	

	
	
	
	
	
}
