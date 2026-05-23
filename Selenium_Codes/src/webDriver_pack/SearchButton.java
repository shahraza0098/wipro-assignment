package webDriver_pack;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchButton {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		   WebDriver driver = new ChromeDriver();

	        driver.get("https://www.google.com/");

	        Thread.sleep(2000);

	        driver.findElement(By.name("q")).click();

	        driver.findElement(By.name("q")).sendKeys("nature images");

	        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
