package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_004_LogoutPage extends BaseClass {
	
	@BeforeTest
	public void setValues () {
		filename = "Leaftaps";
		sheetname = "LoginPage";
	}
	
	@Test (dataProvider = "fetchdata")
	public void logoutFunctionality (String name, String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(name).enterPassword(pwd).clickLoginButton().clickCrmsfaLink().clickLogout().verifyLogout();
		
	}

}
