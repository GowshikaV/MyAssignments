Feature: Account creation for SalesForce Application
Scenario: Create an Account with Valid data
Given Launch the browser
And Load the URL
And Enter the Username
And Enter the Password
When Click on the Login button
When Click on toggle menu button
And Click on the ViewAll link
Given Enter Sales
And Click on the Sales
And Click on the Accounts tab
And Click on the New button
Given Enter the AccountName
And Choose Ownership as Public
When Click Save button
Then Account has to be created successfully and verify AccountName