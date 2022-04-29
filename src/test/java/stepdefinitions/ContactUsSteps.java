package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
	   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the from given sheetname {string} and {int}")
	public void user_fills_the_from_given_sheetname_and(String SheetName, Integer rowNumber) throws Exception, IOException {
	    ExcelReader reader = new ExcelReader();
	    List<Map<String,String>> testData = reader.getData("C:\\Users\\Khaja Afrozuddin\\Desktop\\OrderDetails.xlsx", SheetName);
	    String heading = testData.get(rowNumber).get("subjectheading");
	    String email = testData.get(rowNumber).get("email");
	    String message = testData.get(rowNumber).get("message");
	    
	    contactUsPage.fillContactsForm(heading, email, message);
	    
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickOnSendButton();
	}

	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String expectedSuccessMessage) {
		String actualMessage = contactUsPage.getSuccessMsg();
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage, expectedSuccessMessage);
	}
	
	
	
	
}
