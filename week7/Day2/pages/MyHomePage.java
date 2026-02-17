package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class MyHomePage extends BaseClass {
	
	public MyHomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public MyLeadsPage clickCreateLead () {
		driver.findElement(By.linkText("Create Lead")).click();
		return new MyLeadsPage(driver);
	}
	
	public MyAccountsPage clickCreateAccount () {
		driver.findElement(By.linkText("Create Account")).click();
		return new MyAccountsPage(driver);
	}
	
	public LogoutPage clickLogout () {
		driver.findElement(By.linkText("Logout")).click();
		return new LogoutPage(driver);
		
	}

}
