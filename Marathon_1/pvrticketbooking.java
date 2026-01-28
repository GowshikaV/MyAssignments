package marathon.one;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class pvrticketbooking {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		try {
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.findElement(By.xpath("//div[@id='cinema']")).click();
		driver.findElement(By.xpath("//span[text()='INOX National,Virugambakkam Chennai']")).click();
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='BORDER 2']/parent::li/span")).click();
		driver.findElement(By.xpath("//span[text()='06:25 PM']")).click();
		driver.findElement(By.xpath("//button[@type='submit']/span")).click();
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		driver.findElement(By.xpath("//span[@id='SL.SILVER|C:3']")).click();
		String seat = driver.findElement(By.xpath("//p[text()='C3']")).getText();
		System.out.println(seat);
		String price = driver.findElement(By.xpath("//div[@class='grand-prices']/h6")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();

		
		String title = driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(3000);

		
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		finally {
			driver.quit();
		}

	}

}
