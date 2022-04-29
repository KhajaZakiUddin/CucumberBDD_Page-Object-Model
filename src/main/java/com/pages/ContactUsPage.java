package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

	private WebDriver driver;
	//1. Create Locators
	//private By contactUsLink = By.xpath("//a[text()='Contact us']");
	private By subjectHeading = By.xpath("//select[@id='id_contact']");
	private By email = By.xpath("//input[@id='email']");
	private By sendButton = By.xpath("//span[normalize-space()='Send']");
	private By messageBody = By.xpath("//textarea[@id='message']");
	private By successMessage = By.xpath("//p[@class='alert alert-success']");
	
	
	//2. Create Constructor
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page Actions
	
	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactsForm(String heading, String emailId, String Message) {
		Select select  = new Select(driver.findElement(subjectHeading));
		select.selectByVisibleText(heading);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(messageBody).sendKeys(Message);
	}
	
	public void clickOnSendButton() {
		driver.findElement(sendButton).click();
	}
	
	public String getSuccessMsg() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		return driver.findElement(successMessage).getText();
	}
	
	
	
}
