package com.openCart.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver ldriver;

	public LoginPageObject(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "email")
	@CacheLookup
	WebElement LgnEmail;

	@FindBy(name = "password")
	@CacheLookup
	WebElement LgnPass;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	@CacheLookup
	WebElement Lgnbtn;

	
	public void setUserEmail(String uEmail) {
		LgnEmail.sendKeys(uEmail);
	}

	public void setPassword(String uPwd) {
		LgnPass.sendKeys(uPwd);
	}

	public void clickSubmit() {
		Lgnbtn.click();
	}


}
