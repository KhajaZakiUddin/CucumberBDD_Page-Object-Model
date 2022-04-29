Feature: Account Page Feature

Background:
Given user has already logged in to the application
|username|password|
|zakianimation04@gmail.com|testanimation123|


Scenario: Accounts Page Title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"


Scenario: Accounts Section Count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And accounts section count should be 5