package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegister {

	public static void main(String[] args) {
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Gowshika");
		driver.findElement(By.name("lastname")).sendKeys("Viswanathan");
		driver.findElement(By.name("reg_email__")).sendKeys("1234567891");
		driver.findElement(By.id("password_step_input")).sendKeys("Qwert@123");
		
		WebElement day= driver.findElement(By.id("day"));
		Select date = new Select(day);
		date.selectByVisibleText("27");
		
		WebElement mon= driver.findElement(By.id("month"));
		Select month = new Select (mon);
		month.selectByValue("7");
		
		WebElement yr= driver.findElement(By.id("year"));
		Select year = new Select (yr);
		year.selectByIndex(31);
		
		driver.findElement(By.xpath("//label[text()='Female']/input")).click();
		
		driver.close();

	}

}
