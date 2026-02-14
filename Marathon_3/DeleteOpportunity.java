package marathon.one;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DeleteOpportunity extends BaseOpportunity {
	@BeforeTest
	public void setvalue () {
		filename = "deleteopp";
	}
	
	@Test (dependsOnMethods= {"marathon.one.CreateNewOpportunity.createOpportunity"},dataProvider = "fetchdata")
	public void deleteOpportunity(String name) throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Search this list...']")).click();
		WebElement oppName = driver.findElement(By.xpath("//label[text()='Search this list...']//following::input[1]"));
		oppName.sendKeys(name);
		Thread.sleep(2000);
		oppName.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@data-key='down'])[6]")).click();
		Thread.sleep(5000);
		WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
	}
}
