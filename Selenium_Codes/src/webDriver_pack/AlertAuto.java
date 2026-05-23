package webDriver_pack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAuto {

	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/alerts");

		// Simple Alert
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// Timer Alert
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(7000);
		driver.switchTo().alert().accept();

		// Confirmation Alert
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();

		// Prompt Alert
		driver.findElement(By.id("promtButton")).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Welcome");

		Thread.sleep(3000);

		alert.accept();

		Thread.sleep(3000);

		// driver.switchTo().alert().dismiss();

		driver.close();

	}

}
