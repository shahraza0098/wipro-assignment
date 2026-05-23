package webDriver_pack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firstscript {

	public static void main(String[] args) throws InterruptedException   {
		// TODO Auto-generated method stub
		
		

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

//        Thread.sleep(3000);

        // Click using id = Layer_1
        WebElement logo=driver.findElement(By.id("Layer_1"));
        System.out.println("checking"+logo);
//        driver.findElement(By.id("Layer_1")).click();

//        Thread.sleep(3000);

        driver.close();

	}

}
