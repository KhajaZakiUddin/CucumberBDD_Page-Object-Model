package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1. By Locators
	private By emailId = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='passwd']");
	private By signInBtn = By.xpath("//button[@id='SubmitLogin']");
	private By forgotPwdLink = By.xpath("//a[normalize-space()='Forgot your password111?']");
	
	
	//2. Create Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//3. Creating Page Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInBtn).click();
	}
	
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("Login with "+username+ " and " +pwd);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		return new AccountsPage(driver);
	}
	
	
	
	
	
}
