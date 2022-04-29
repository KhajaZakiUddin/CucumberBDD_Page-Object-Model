Feature: Contact Us Feature

Scenario Outline: Contact Us Scenario with different set of data
Given user navigates to contact us page
When user fills the from given sheetname "<SheetName>" and <RowNumber>
And user clicks on send button
Then it shows successful message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|contactus|0|
|contactus|1|