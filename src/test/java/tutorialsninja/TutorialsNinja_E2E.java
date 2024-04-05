package tutorialsninja;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorialsNinja_E2E {

	@SuppressWarnings("deprecation")
	@Test
	public void E2E() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

		driver.findElement(By.id("input-email")).sendKeys("spacestudio555@gmail.com");

		driver.findElement(By.id("input-password")).sendKeys("8971059266", Keys.ENTER);

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='Account']")).isDisplayed());

		driver.findElement(By.name("search")).sendKeys("Nikon D300");

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='caption']//a[text()='Nikon D300']")).isDisplayed());

		driver.findElement(By.xpath("//div[@class='caption']//a[text()='Nikon D300']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='Nikon D300']")).isDisplayed());

		WebElement Qty = driver.findElement(By.id("input-quantity"));

		Qty.clear();

		Qty.sendKeys("2");

		driver.findElement(By.id("button-cart")).click();

		WebElement successMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		
		String successText = successMsg.getText();
		
		Thread.sleep(1000);
		Assert.assertEquals(successText, "Success: You have added Nikon D300 to your shopping cart! ×");
		
		System.out.println(successText.contains(" to your "));

		Assert.assertTrue(driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']//a[text()='Nikon D300']"))
				.isDisplayed());

		driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']//a[2]")).click();

		driver.findElement(By.linkText("Checkout")).click();

		driver.quit();

	}
}
