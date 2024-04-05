package sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_Table {

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

		driver.get("https://omayo.blogspot.com/");

//		List<WebElement> data = driver.findElements(By.xpath("//table[@id='table1']//td"));
//		for (int i = 0; i < data.size(); i++) {
//
//			System.out.println(data.get(i).getText());
//
//			
//
//		}
		
//---------------------------
		
		
//		int row = 0;
//		String givenName = "Praveen";
//		List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
//		for(int i = 0;i<names.size();i++) {
//		if(names.get(i).getText().equals(givenName)) {
//			
//			row = i;
//			
//		}
//		}
		
//		String path = "//table[@id='table1']//tr["+(row+1)+"]//td[3]";
//		String location = driver.findElement(By.xpath(path)).getText();
//		System.out.println(location);
		
//		-----------------------------------------
		
		// number of rows
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size());
		
		//number of column
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[1]/td")).size());
		
		driver.quit();

	}
}
