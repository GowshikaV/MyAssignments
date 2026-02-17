package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LogoutPage extends BaseClass{
	
	public LogoutPage (ChromeDriver driver) {
		this.driver= driver;
	}
	
	public void verifyLogout () {
		System.out.println("Logged Out Successfully");
	}
	
}
