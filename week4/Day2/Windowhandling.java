package week4.day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		
		Set<String> handle = driver.getWindowHandles();
		List <String> allAddress = new ArrayList <String> (handle);
		String childAddress = allAddress.get(1);
		driver.switchTo().window(childAddress);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		WebDriver parent = driver.switchTo().window(allAddress.get(0));
		parent.close();
		
	}

}
