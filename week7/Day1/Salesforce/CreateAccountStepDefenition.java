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
	//String accname;
	@Given ("Launch the browser")
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		driver = new ChromeDriver(options);
	}
	
	@And ("Load the URL as {string}")
	public void loadUrl (String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@And ("Enter the Username as {string}")
	public void enterUsername (String name) {
		driver.findElement(By.id("username")).sendKeys(name);
	}
	
	@And ("Enter the Password as {string}")
	public void enterPassword (String Pwd) {
		driver.findElement(By.id("password")).sendKeys(Pwd);
	}
	
	@When ("Click on the Login button")
	public void clickLoginbutton () {
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.linkText("Remind Me Later")).click();
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
	
	@Given ("Enter the AccountName as (.*)$")
	public void enterAccountName (String accname) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accname);
	}
	
	@And ("Choose Ownership as Public")
	public void chooseOwnership () {
		WebElement ownership = driver.findElement(By.xpath("//button[@aria-label='Ownership']/following-sibling::div//lightning-icon"));
		driver.executeScript("arguments[0].click();", ownership);
		WebElement value = driver.findElement(By.xpath("//span[text()='Public']"));
		driver.executeScript("arguments[0].click();", value);
	}
	
	@When ("Click Save button")
	public void clickSave () {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	
	@Then ("Verify AccountName (.*)$")
	public void verifyAccountName (String accname) {
		String text = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if (text.equals(accname)) {
			System.out.println("Account Name Verified Successfully");
		}
		else {
			System.out.println("Name Mismatch");
		}
		
		driver.quit();
		
	}
}
