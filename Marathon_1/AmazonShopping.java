package marathon.one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonShopping {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		try {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("Bags for boys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']/preceding-sibling::span/preceding-sibling::span")).getText();
		System.out.println(result);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Skybags']/preceding-sibling::div//i")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Gear']/preceding-sibling::div//i")).click();
		//driver.wait(3000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='a-button-inner']/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']/span)[1]")).getText();
		System.out.println(text);
		String price = driver.findElement(By.xpath("(//a[@aria-describedby='price-link']//span)[1]")).getText();
		System.out.println(price);
		}
		
		finally {
			driver.quit();
		}
		

	}

}
