package marathon.one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewOpportunity extends BaseOpportunity {
	
	@BeforeTest
	public void setvalue () {
		filename = "createopp";
	}
	
	@Test (dataProvider = "fetchdata")
	public void createOpportunity(String name, String phoneNumber) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]"));
		oppName.sendKeys("Salesforce Automation by "+name);
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(phoneNumber);
		
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Stage']/parent::span/following-sibling::div//button")).click();
		WebElement stage = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']//span[text()='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", stage);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();		
		String verifymsg = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();

		if (verifymsg.contains(name)) {
			System.out.println("New Oppurtunity Created");
		} else {
			System.out.println("Oppurtunity not Created");
		}
	}
}
