package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To print entire Column
		
		List <WebElement> columns =driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']//tbody/tr/td[1]"));
		for (int i=0; i<columns.size(); i++) {
			String text = columns.get(i).getText();
			System.out.println(text);
		}
		
	
		
		

	}

}
