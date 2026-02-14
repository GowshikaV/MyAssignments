Feature: Account creation for SalesForce Application
Scenario Outline: Create multiple Accounts
Given Launch the browser
And Load the URL as 'https://login.salesforce.com/'
And Enter the Username as 'gowshika27846@agentforce.com'
And Enter the Password as 'Asdf@1234'
When Click on the Login button
When Click on toggle menu button
And Click on the ViewAll link
Given Enter Sales
And Click on the Sales
And Click on the Accounts tab
And Click on the New button
Given Enter the AccountName as <accountname>
And Choose Ownership as Public
When Click Save button
Then Verify AccountName <accountname>

Examples: 
|accountname|
|Vineeth|
|Sabari|