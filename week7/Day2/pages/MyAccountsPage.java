package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class MyAccountsPage extends BaseClass {
	
	public MyAccountsPage (ChromeDriver driver) {
		this.driver=driver;
	}

	public MyAccountsPage enterAccountName(String accname) {
		driver.findElement(By.id("accountName")).sendKeys(accname);
		return this;
	}

	public ViewAccountsPage clickCreateAccount() {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewAccountsPage(driver);

	}

}
