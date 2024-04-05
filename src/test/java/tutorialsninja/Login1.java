package tutorialsninja;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login1 {

	WebDriver driver = null; // WebDriver add selenium-java dependency
	SoftAssert softassert = new SoftAssert();

	/*
	 * @BeforeMethod
	 * 
	 * @Test-1
	 * 
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * 
	 * @Test-2
	 * 
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * 
	 * @Test-3
	 * 
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * 
	 * @Test-4
	 * 
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * 
	 * @Test-5
	 * 
	 * @AfterMethod
	 */

	@BeforeMethod
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");
		prop.load(fis);
		
		String browser = "chrome";

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public String email() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");
		prop.load(fis);
		
		return prop.getProperty("email");
	}

	public String password() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");
		prop.load(fis);
		
		return prop.getProperty("password");
	}

	public String getEmailTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

	@Test(priority = 1)
	public void loginWithValidCredentials() throws IOException {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		File file = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenshots//sc3.png"));

		driver.findElement(By.id("input-email")).sendKeys(email());
		driver.findElement(By.id("input-password")).sendKeys(password(), Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());

		softassert.assertAll();

	}

	@Test(priority = 2)
	public void LoginWithValidEmailAndInvalidPassword() throws IOException {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys(email());
		driver.findElement(By.id("input-password")).sendKeys("12345", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

		softassert.assertAll();

	}

	@Test(priority = 3)
	public void LoginWithInvalidEmailAndValidPassword() {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("8971059266", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

		softassert.assertAll();

	}

	@Test(priority = 4)
	public void LoginWithInvalidCredentials() {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("89710dv5926643", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

		softassert.assertAll();

	}

	@Test(priority = 5)
	public void verifyUserLoginWithoutGivingCredentials() {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

		softassert.assertAll();

	}
}
