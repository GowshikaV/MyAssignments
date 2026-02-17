package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class MyLeadsPage extends BaseClass{
	
	public MyLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	
	public MyLeadsPage enterCompanyName (String cmpname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpname);
		return this;
	}
	public MyLeadsPage enterFirstName (String firstname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		return this;
	}
	public MyLeadsPage enterLastname (String lastname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		return this;
		
	}
	
	public ViewLeadPage clickCreateLead () {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage(driver);
	}

}
