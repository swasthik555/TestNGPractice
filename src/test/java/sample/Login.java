package sample;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	WebDriver driver; // WebDriver add selenium-java dependency
	SoftAssert softassert = new SoftAssert();

	/*
	@BeforeMethod
	@Test-1
	@AfterMethod
	
	@BeforeMethod
	@Test-2
	@AfterMethod
	
	@BeforeMethod
	@Test-3
	@AfterMethod
	
	@BeforeMethod
	@Test-4
	@AfterMethod
	
	@BeforeMethod
	@Test-5
	@AfterMethod
	*/

	@BeforeMethod
	public void setup() {

		
		WebDriverManager.chromedriver().setup(); // WebDriverManager add webdrivermanager dependency
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://tutorialsninja.com/demo/");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public String email() {
		return "spacestudio555@gmail.com";
	}

	public String password() {
		return "8971059266";
	}

	public String getEmailTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

	@Test(priority = 1)
	public void loginWithValidCredentials() {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys(email());
		driver.findElement(By.id("input-password")).sendKeys(password(), Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
		
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void LoginWithValidEmailAndInvalidPassword() {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys(email());
		driver.findElement(By.id("input-password")).sendKeys("89710592663", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

		softassert.assertAll();
		
	}

	@Test(priority = 3)
	public void LoginWithInvalidEmailAndValidPassword() {

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("dvdfbdn@gmail.com");
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
		driver.findElement(By.id("input-password")).sendKeys("897105926643", Keys.ENTER);

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
