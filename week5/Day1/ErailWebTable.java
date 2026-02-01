package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailWebTable {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement sourceStation = driver.findElement(By.id("txtStationFrom"));
		sourceStation.clear();
		sourceStation.sendKeys("MAS");
		driver.findElement(By.xpath("//div[@title='Mgr Chennai Ctr']/div[text()='Mgr Chennai Ctr']")).click();

		WebElement destStation = driver.findElement(By.id("txtStationTo"));
		destStation.clear();
		destStation.sendKeys("MDU");
		driver.findElement(By.xpath("//div[@title='Madurai Jn']/div[text()='Madurai Jn']")).click();
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

		List<WebElement> table = driver.findElements(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));

		List<String> list = new ArrayList<>();

		for (int i = 0; i < table.size(); i++) {
			String trainName = table.get(i).getText();
			list.add(trainName);
		}

		// list.add("NAGARCOIL EXP");
		
		System.out.println(list);
		Set<String> set = new HashSet<String>(list);

		if (list.size() == set.size()) {
			System.out.println("Size of List: " + list.size());
			System.out.println("Size of Set: " + set.size());
			System.out.println("No Duplicate TrainNames");
		} else {
			System.out.println("Size of List: " + list.size());
			System.out.println("Size of Set: " + set.size());
			System.out.println("Duplicate TrainNames Found");
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
