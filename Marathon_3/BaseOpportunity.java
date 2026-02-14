package marathon.one;

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

public class BaseOpportunity {
	public ChromeDriver driver;
	public String filename;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String url, String name, String pwd) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		//driver.findElement(By.linkText("Remind Me Later")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		WebElement opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		driver.executeScript("arguments[0].click();", opportunities);
		Thread.sleep(4000);

	}

	@AfterMethod
	public void postCondition() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@DataProvider(name = "fetchdata")
	public String[][] sendData() throws IOException {
		String[][] data = ReadExcel.readData(filename);
		return data;
	}

}
