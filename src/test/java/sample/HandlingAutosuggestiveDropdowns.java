package sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAutosuggestiveDropdowns {

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

		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.id("fromCity")).click();

		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("fresno");

		for (int i = 0; i <= 3; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.DOWN);

		}

		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		driver.quit();
	}

}
