package sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_Calendar {

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException, IOException {
		String browser = "chrome";
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		// Selenium Implicit wait - Global wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor je = (JavascriptExecutor)driver; 
        je.executeScript("window.scrollBy(0, 1200)");
        
        Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
//		Thread.sleep(2000);
		
		for(int i = 0; i<10;i++) {
			
			driver.findElement(By.className("flatpickr-next-month")).click();
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'25')]")).click();
//		Thread.sleep(2000);
		
		String txt = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).getText();
		System.out.println(txt);
		
		driver.quit();

	}
}
