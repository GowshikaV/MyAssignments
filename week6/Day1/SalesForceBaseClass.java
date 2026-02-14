package week6.day1;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class SalesForceBaseClass {
	
	public ChromeDriver driver;
	public String filename;
	
	@Parameters ({"url", "username", "password"})
    @BeforeMethod
	public void preCondition (String url, String name, String pwd) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		//driver.findElement(By.linkText("Remind Me Later")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Legal Entities']")).click();
		
		Thread.sleep(3000);
		WebElement entity = driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();", entity);
		Thread.sleep(3000);
	}
	@AfterMethod
	public void postCondition () throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	 @DataProvider (name = "fetchdata")
	 public String[][] sendData () throws IOException {
		 String[][] data = ReadExcel.readData(filename);
		return data;
		 
	 }
	 
	 
}
