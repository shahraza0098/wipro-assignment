package webDriver_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/buttons");

		// Double Click
		WebElement dc = driver.findElement(By.id("doubleClickBtn"));
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.doubleClick(dc).perform();

		Thread.sleep(2000);

		// Right Click
		WebElement rc = driver.findElement(By.id("rightClickBtn"));
		Thread.sleep(2000);

		ac.contextClick(rc).perform();

		Thread.sleep(2000);

		// Dynamic Click
		WebElement dcc = driver.findElement(By.cssSelector("Alkww"));
		Thread.sleep(2000);

		ac.moveToElement(dcc).click().perform();

		Thread.sleep(2000);
		
		

		Thread.sleep(3000);

		driver.close();
	}

}
