package marathon.one;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditOpprtunity extends BaseOpportunity {
	
	@BeforeTest
	public void setvalue () {
		filename = "editopp";
	}
	
	@Test(dependsOnMethods = {"marathon.one.CreateNewOpportunity.createOpportunity"}, dataProvider = "fetchdata")
	public void editOpportunity(String name) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@aria-label='Search this list...']")).click();
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Search this list...']//following::input[1]"));
		oppName.sendKeys(name);
		Thread.sleep(2000);
		oppName.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@data-key='down'])[6]")).click();
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']"));
		driver.executeScript("arguments[0].click();", edit);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='26']")).click();
		driver.findElement(By.xpath("//label[text()='Stage']/parent::span/following-sibling::div//button")).click();
		WebElement stage = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Perception Analysis']//span[text()='Perception Analysis']"));
		driver.executeScript("arguments[0].click();", stage);
		
		Thread.sleep(3000);
		WebElement deliveryStatus = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/parent::span/following-sibling::div//button"));
		Actions act = new Actions(driver);
		act.scrollToElement(deliveryStatus).perform();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", deliveryStatus);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div//textarea")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String text = driver.findElement(By.xpath("//span[@title='Perception Analysis']")).getText();
		System.out.println(text);

		
	}

}
