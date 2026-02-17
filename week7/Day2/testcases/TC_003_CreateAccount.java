package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_003_CreateAccount  extends BaseClass{
	
	@BeforeTest
	public void setValues () {
		filename = "Leaftaps";
		sheetname = "CreateAccount";
	}
	
	@Test (dataProvider = "fetchdata")
	public void createAccountFunctionality (String name, String pwd, String accname) {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(name).enterPassword(pwd).clickLoginButton().clickCrmsfaLink()
		.clickCreateAccount().enterAccountName(accname).clickCreateAccount().viewAccount();
	}

}
