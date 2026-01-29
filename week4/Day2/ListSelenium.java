package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListSelenium {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@role='listitem' and not(.//span[text()='Sponsored'])]//span[@class='a-price-whole']"));

		List<Integer> price = new ArrayList<Integer>();
		for (int i = 0; i < prices.size(); i++) {
			String text = prices.get(i).getText();
			String replaced = text.replace(",", "");
			int int1 = Integer.parseInt(replaced);
			price.add(int1);
		}
		Collections.sort(price);
		System.out.println("Size of the List: " + price.size());
		System.out.println("Mobile Price List: " + price);
		Integer lowestprice = price.get(0);
		System.out.println("LowestPrice: " + lowestprice);
		Thread.sleep(10000);
		driver.quit();
	}

}

////div[@role='listitem']//span[@class='a-price-whole']
