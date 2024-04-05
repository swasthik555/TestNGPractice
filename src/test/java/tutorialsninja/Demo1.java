package tutorialsninja;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {
	
	@Test(priority = 1)
	public void loginWithValidCredentials() {
		SoftAssert softassert = new SoftAssert();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("spacestudio555@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("8971059266", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());

		softassert.assertAll();
		
		driver.quit();

	}

	@Test(priority = 2)
	public void LoginWithValidEmailAndInvalidPassword() {
		SoftAssert softassert = new SoftAssert();
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[@class='caret']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("spacestudio555@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("89710592663", Keys.ENTER);

		softassert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

		softassert.assertAll();
		
		driver.quit();

	}

}
