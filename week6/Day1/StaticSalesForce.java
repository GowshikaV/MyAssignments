package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaticSalesForce extends SalesForceBaseClass {
	@Test
	public void createLegalEntity () {
		
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("testLeaf");
		driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div//textarea[@part='textarea']")).sendKeys("SalesForce");
		WebElement status = driver.findElement(By.xpath("//label[text()='Status']/parent::span/following-sibling::div//button"));
		driver.executeScript("arguments[0].click();", status);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String msg = driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-error slds-icon_container'])[2]/parent::div/following-sibling::div/h2")).getText();
		System.out.println(msg);
		
		if (msg.equals("We hit a snag.")) {
			System.out.println("Alert message captured");
		}
	}

}
