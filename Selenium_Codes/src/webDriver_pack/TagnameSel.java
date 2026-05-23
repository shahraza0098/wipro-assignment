package webDriver_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class TagnameSel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		
		List<WebElement> el=driver.findElements(By.tagName("input"));
		
		
//		for(WebDriver element:el) {
//			System.out.println(element.getAttribute(""));
//		}

	}

}
