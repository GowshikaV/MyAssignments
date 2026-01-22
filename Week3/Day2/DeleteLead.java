package week3.day2;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;


public class DeleteLead {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		try {
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9998887771");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);	
		String leadId = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr[1]/td[1]/div/a")).getText();
		System.out.println(leadId);
		driver.findElement(By.linkText(leadId)).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		//System.out.println(msg);
		if (msg.equals("No records to display")) {
			System.out.println("Lead Deleted Succesfully");
		}
		else {
			System.out.println("No Information");
		}
		
		Thread.sleep(5000);
		}
		 catch (InterruptedException e) {
				e.printStackTrace();
			}
		finally {
			driver.quit();
		}
		
		
		
		

	}

}
