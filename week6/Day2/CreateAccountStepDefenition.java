package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStepDefenition {
	
	public ChromeDriver driver;
	@Given ("Launch the browser")
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		driver = new ChromeDriver(options);
	}
	
	@And ("Load the URL")
	public void loadUrl () {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@And ("Enter the Username")
	public void enterUsername () {
		driver.findElement(By.id("username")).sendKeys("gowshika27846@agentforce.com");
	}
	
	@And ("Enter the Password")
	public void enterPassword () {
		driver.findElement(By.id("password")).sendKeys("Asdf@1234");
	}
	
	@When ("Click on the Login button")
	public void clickLoginbutton () {
		driver.findElement(By.id("Login")).click();
		//driver.findElement(By.linkText("Remind Me Later")).click();
	}
	
	@When ("Click on toggle menu button")
	public void clickToggleMenu () {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}
	
	@And ("Click on the ViewAll link")
	public void clickViewAll () {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	
	@Given ("Enter Sales")
	public void enterSales () {
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Sales");
	}
	
	@And ("Click on the Sales")
	public void clickSales () {
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
	}
	
	@And ("Click on the Accounts tab")
	public void clickAccountsTab () throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Accounts']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	@And ("Click on the New button")
	public void clickNewButton () {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	
	@Given ("Enter the AccountName")
	public void enterAccountName () {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Gowshika");
	}
	
	@And ("Choose Ownership as Public")
	public void chooseOwnership () {
		driver.findElement(By.xpath("//button[@aria-label='Ownership']/following-sibling::div//lightning-icon")).click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
	}
	
	@When ("Click Save button")
	public void clickSave () {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	
	@Then ("Account has to be created successfully and verify AccountName")
	public void verifyAccountName () {
		String text = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if (text.equals("Gowshika")) {
			System.out.println("Account Name Verified Successfully");
		}
		else {
			System.out.println("Name Mismatch");
		}
	}
}
