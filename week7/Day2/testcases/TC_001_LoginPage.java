package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_001_LoginPage extends BaseClass{
	
	@BeforeTest
	public void setValues () {
		filename = "Leaftaps";
		sheetname = "LoginPage";
	}
	
	@Test (dataProvider = "fetchdata")
	public void loginFunctionaity (String name, String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(name).enterPassword(pwd).clickLoginButton();
	}
	
	

}
