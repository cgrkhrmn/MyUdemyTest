package com.udemy.uat.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.uat.pages.HomePage;
import com.udemy.uat.utilities.ConfigurationReader;
import com.udemy.uat.utilities.Driver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpStepDefinitions {
	WebDriver driver = Driver.getInstance();
	HomePage homePage=new HomePage();
	@Given("^udemy homepage$")
	public void udemy_homepage() throws Throwable {
		 Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		    Driver.getInstance().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@When("^user click sign up button$")
	public void user_click_sign_up_button() throws Throwable {
		homePage.signUpButton.click();
	}

	@When("^provide a fullname valid email and password$")
	public void provide_a_fullname_valid_email_and_password() throws Throwable {
	   
	homePage.fullName.sendKeys("Hasan Huseyin");
	homePage.emailId.sendKeys("hasasnhusss@gmail.com");
	homePage.password.sendKeys("password1234");
	homePage.submitButton.click();
	}

	@When("^click sign up button$")
	public void click_sign_up_button() throws Throwable {
		homePage.submitButton.click();
	}

	@Then("^user should be able to signup successfully$")
	public void user_should_be_able_to_signup_successfully() throws Throwable {
		WebDriverWait wait=new WebDriverWait(Driver.getInstance(), 20);
	    wait.until(ExpectedConditions.visibilityOf(homePage.fullName));
	    Assert.assertEquals(homePage.fullName, "Hasan Huseyin");
	}


}
