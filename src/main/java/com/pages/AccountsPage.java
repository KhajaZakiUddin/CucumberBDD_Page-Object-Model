package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	//1. Page Locators
	private By accountsSection = By.xpath("//div[@class='row addresses-lists']/descendant::span");
	
	
	//2. Create Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//3. Page Actions
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountsSection).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<WebElement> accountsHeaderList = driver.findElements(accountsSection);
		List<String> accountsList = new ArrayList<String>();
		
		for(WebElement e:accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}
	
	
	
}
