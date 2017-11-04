package com.udemy.uat.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.udemy.uat.pages.HomePage;
import com.udemy.uat.pages.SearchResultPage;
import com.udemy.uat.utilities.ConfigurationReader;
import com.udemy.uat.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchTest {
	WebDriver driver=Driver.getInstance();
	HomePage homePage=new HomePage();
	SearchResultPage search=new SearchResultPage();
	
	@Given("^Udemy homepage$")
	public void udemy_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
	    Driver.getInstance().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@When("^user click search box$")
	public void user_click_search_box() throws Throwable {
	   homePage.searchBox.sendKeys("selenium");
	}

	@When("^search some item$")
	public void search_some_item() throws Throwable {
	    homePage.searchButton.click();
	}

	@Then("^user should be able to see expected results\\.$")
	public void user_should_be_able_to_see_expected_results() throws Throwable {
	   WebDriverWait wait=new WebDriverWait(Driver.getInstance(), 20);
	   wait.until(ExpectedConditions.visibilityOf(search.searchItemName));
	   Assert.assertTrue(search.searchItemName.getText().contains("selenium"));
	   
	}
}
