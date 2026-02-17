package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class ViewAccountsPage extends BaseClass {
	
	public ViewAccountsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	
	public void viewAccount () {
		System.out.println("Account created Successfully");
	}

}
