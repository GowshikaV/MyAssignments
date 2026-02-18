package marathon.one;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver ();
		driver.get("https://dev181504.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("F/*jyM6Q6pHh");
		driver.findElement(By.id("sysverb_login")).click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(5);
		shadow.findElementByXPath("//div[text()='All']").click();
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		filter.sendKeys("Service catalog");
		filter.sendKeys(Keys.ENTER);
		WebElement serviceCatalog = shadow.findElementByXPath("//mark[text()='Service Catalog']");
		driver.executeScript("arguments[0].click();", serviceCatalog);
		WebElement mobileFrame = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(mobileFrame);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]/parent::a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
		WebElement dataDropdown = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select sel = new Select (dataDropdown);
		sel.selectByValue("unlimited");
		driver.findElement(By.xpath("//input[@value='sierra_blue']/following-sibling::label")).click();
		driver.findElement(By.xpath("//input[@value='512']/following-sibling::label")).click();
		//driver.switchTo().defaultContent();
		WebElement orderNow = driver.findElement(By.id("oi_order_now_button"));
		driver.executeScript("arguments[0].click();", orderNow);
		
		String text = driver.findElement(By.xpath("//span[@class='notification-icon icon-check-circle']/following-sibling::span")).getText();
		if (text.equals("Thank you, your request has been submitted")) {
			System.out.println("Order has been sucessfully placed and verified");
		}
		String requestID = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();	
		System.out.println("request ID: "+requestID);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File ("./snapshots/servicenow.png");
		FileUtils.copyFile(source, destination);
		
		Thread.sleep(5000);
		driver.quit();

	}

}
