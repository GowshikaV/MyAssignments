package marathon.one;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver ();
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("moe-dontallow_button")).click();
	
		Actions act = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		act.moveToElement(brands).perform();
		//brands.click();
		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.moveToElement(watches).perform();
		//watches.click();
		driver.findElement(By.xpath("//div[@class='DesktopHeader__featureBrands']/div[2]")).click();
		WebElement filter = driver.findElement(By.xpath("//select[@label='Popularity']"));
		Select sel = new Select(filter);
		sel.selectByVisibleText("New Arrivals");
		driver.findElement(By.xpath("//div[text()='Men']/preceding-sibling::div")).click();
		
		Thread.sleep(3000);
		List<WebElement> priceList = driver.findElements(By.xpath("//div[contains(@class,'ProductDescription__priceHolder')]/h3"));
		List <String> list = new ArrayList <String> ();
		
		for (int i=0; i<priceList.size(); i++) {
			 String price = priceList.get(i).getText();
			 list.add(price);
		}
		System.out.println("No. of Watches Displayed and Size of List: "+list.size());
		System.out.println("Price of all the displayed Watches: "+list);
		driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> windowList = new ArrayList <String> (windowHandles);
		String ParentWindow = windowList.get(0);
		String childWindow = windowList.get(1);
		driver.switchTo().window(childWindow);
		
		String firstMobilePrice = driver.findElement(By.xpath("//meta[@itemprop='priceValidUntil']/following-sibling::h3")).getText();
		System.out.println("ChildWindow First Mobile price: "+firstMobilePrice);
		if (firstMobilePrice.contains(list.get(0))) {
			System.out.println("Both the Prices are similar");
		}
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		WebElement cart = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		String cartCount = cart.getText();
		System.out.println("Count from the cart icon: "+cartCount);
		cart.click();
		Thread.sleep(3000);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File ("./snapshots/tatacliq.png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(3000);
		
		//driver.close();
		//driver.switchTo().window(ParentWindow).close();
		
		driver.quit();
	}
}
