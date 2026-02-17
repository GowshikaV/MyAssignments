package testcases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_002_CreateLead extends BaseClass {
	
	@BeforeTest
	public void setValues () {
		filename = "Leaftaps";
		sheetname = "CreateLead";
	}
	
	
	@Test (dataProvider = "fetchdata")
	public void createLeadFunctionality (String name, String pwd, String cmpname, String firstname, String lastname) {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(name).enterPassword(pwd).clickLoginButton().clickCrmsfaLink()
		.clickCreateLead().enterCompanyName(cmpname).enterFirstName(firstname).enterLastname(lastname).clickCreateLead().viewlead();
	}
	
	

}
