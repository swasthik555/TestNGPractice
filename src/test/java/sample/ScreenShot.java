package sample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

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

//		driver.manage().window().maximize();

		// Selenium Implicit wait - Global wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

		// Take a ScreenShot here

//		File file = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("screenshots//sc1.png"));
		
		File file = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenshots//sc1.png"));

		driver.findElement(By.id("input-email")).sendKeys("spacestudio555@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("8971059266");

		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

		// Take a Screenshot here
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("screenshots//sc2.png"));

		driver.quit();
	}
}
