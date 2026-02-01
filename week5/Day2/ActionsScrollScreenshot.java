package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrollScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Create Object for Action class, locate element and perform necessary action
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Conditions of Use & Sale"));
		action.scrollToElement(element).perform();
		String text = element.getText();
		element.click();
		System.out.println(text);
		
		//To take Screenshot (Source, Destination, Copy file)
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File ("./snapshots/amazonsnap.png");
		FileUtils.copyFile(source, destFile);
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
