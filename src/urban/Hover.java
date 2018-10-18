package urban;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Hover {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.urbanladder.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.partialLinkText("Close")).click();
		
		List<WebElement> name1 =  driver.findElements(By.className("topnav_itemname"));
		for (WebElement ele : name1) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			
			System.out.println("---------------------------");
			System.out.println(ele.getText().toLowerCase());
			String temp = ele.getText().toLowerCase();
			System.out.println("---------------------------");
			
			List<WebElement> sub_ele = driver.findElements(By.className("inverted"));
			for(WebElement list_sub_ele : sub_ele) {
			  if(list_sub_ele.getAttribute("href").contains("topnav_"+temp)) {
			    System.out.println("sub_element --> " + list_sub_ele.getText());
			  }
			}
			
		}
		
	}

}
