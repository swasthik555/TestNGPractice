package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException {
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("http://www.omayo.blogspot.com");
//		driver.get("https://omayo.blogspot.com/p/page3.html");
//		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
//		WebElement element = driver.findElement(By.id("confirm"));
//		element.click();
//		driver.switchTo().alert().accept();
//		
//		
//		WebElement element1 = driver.findElement(By.name("q"));
//		element1.sendKeys("Sanjay");
//		element1.clear();
//		
//		WebElement element2 = driver.findElement(By.className("classone"));
//		element2.sendKeys("Acharya");
//		
//		WebElement element3 = driver.findElement(By.linkText("compendiumdev"));
//		element3.click();
//		driver.navigate().back();
//		
//		WebElement element4 = driver.findElement(By.cssSelector("#confirm"));
//		element4.click();
//		driver.switchTo().alert().accept();
//		String txt = driver.findElement(By.id("pah")).getText();
//		System.out.println(txt);
//		
//		String title = driver.getTitle();
//		System.out.println(title);
//
//		String URL = driver.getCurrentUrl();
//		System.out.println(URL);
//
//		String getAttribute = driver.findElement(By.name("fname")).getAttribute("value");
//		System.out.println(getAttribute);
//
//		boolean disp = driver.findElement(By.partialLinkText("Page One")).isDisplayed();
//		System.out.println(disp);
//
//		boolean rd = driver.findElement(By.id("but1")).isEnabled();
//		System.out.println(rd);
//
//		boolean rd2 = driver.findElement(By.id("but2")).isEnabled();
//		System.out.println(rd2);
//
//		driver.findElement(By.id("radio1")).click();
//		boolean sel = driver.findElement(By.id("radio1")).isSelected();
//		System.out.println(sel);
//
//		String pge = driver.getPageSource();
//		System.out.println(pge);
//		
//		WebElement ele = driver.findElement(By.name("q"));
//		ele.sendKeys("Selenium");
//		ele.submit();
//		
//		String ele1 = driver.findElement(By.name("q")).getTagName();
//		System.out.println(ele1);
//		
//		String css = driver.findElement(By.id("home")).getCssValue("line-height");
//		System.out.println(css);
//		
//		Dimension size = driver.findElement(By.id("but2")).getSize();
//		System.out.println(size);
//		
//		Point loc = driver.findElement(By.id("but2")).getLocation();
//		System.out.println(loc);
//		
//		List<WebElement> more = driver.findElements(By.xpath("//div[@class='widget-content']"));
//		String txt = more.get(3).getText();
//		System.out.println(txt);
//		
//		List<WebElement> elements = driver.findElements(By.tagName("a"));
//		for(WebElement i : elements) {
//			if(i.getText().length()>0) {
//			System.out.println(i.getText());
//		}
//		}
//		
//		//Window handles
//		driver.findElement(By.linkText("Open a popup window")).click();
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> itr = windows.iterator();
//		String mainwindow = itr.next();
//		String childwindow = itr.next();
//		//We switched the focus of selenium to the child window
//		driver.switchTo().window(childwindow);
//		String txt = driver.findElement(By.xpath("//div[@class='example']")).getText();
//		System.out.println(txt);
//		driver.close();
//		driver.switchTo().window(mainwindow);
//		String para = driver.findElement(By.id("post-body-9023929218208337252")).getText();
//		System.out.println(para);
//		
//		//Waiting Mechanism
//		driver.findElement(By.className("dropbtn")).click();
//		driver.findElement(By.linkText("Facebook")).click();
//		
//		//Explicitly wait
//		driver.findElement(By.className("dropbtn")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement facebookElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
//		facebookElement.click();
//		
//		// alert
//		driver.findElement(By.id("alert1")).click();
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();
//		String para = driver.findElement(By.id("post-body-9023929218208337252")).getText();
//		System.out.println(para);
//		
//		//Drop down select
//		Thread.sleep(2000);
//		WebElement drop = driver.findElement(By.id("drop1"));
//		Select select = new Select(drop);
//		select.selectByIndex(2);
//		Thread.sleep(2000);
//		
//		//multiselect dropdown
//		WebElement multiselectdrop = driver.findElement(By.id("multiselect1"));
//		Select select = new Select(multiselectdrop);
//		select.selectByVisibleText("Volvo");
//		select.selectByVisibleText("Hyundai");
//		select.selectByVisibleText("Audi");
//		Thread.sleep(2000);
//		
//----------------------------------------------------------------------------
//		
//		// Handling Frames
//		WebElement iframe2 = driver.findElement(By.id("iframe2"));
//		driver.switchTo().frame(iframe2);
//		driver.findElement(By.id("q")).sendKeys("Sanjay");
//		driver.switchTo().defaultContent();
//		
//-------------------------------------------------		
//		
//		// Handling Light-Box
		
//-------------------------------------------------------
//		
//		// Actions Class
//		
//		WebElement blogmenu = driver.findElement(By.id("blogsmenu"));
//		WebElement seleniumByArun = driver.findElement(By.xpath("//a/span[text()='SeleniumByArun']"));
//		Actions a = new Actions(driver); 
//		a.moveToElement(blogmenu).perform();	
//		a.moveToElement(seleniumByArun).click(seleniumByArun).build().perform();
//		
//		// DragandDropBy
//		WebElement minPrice = driver.findElement(By.xpath("//a[@aria-labelledby='price-min-label']"));
//		a.dragAndDropBy(minPrice, 100, 0).perform(); // 100-Horizantally,  0-Vertically 
//		a.dragAndDropBy(minPrice, -200, 0).perform();
//		
//		// Context Click (Right click) and Double click
//		WebElement searchBoxField = driver.findElement(By.name("q"));
//		searchBoxField.sendKeys("Sanjay");
//		//a.contextClick(searchBoxField).perform();
//		Thread.sleep(2000);
//		a.doubleClick(searchBoxField).perform();
//		
//		// DragAndDrop
//		WebElement drag = driver.findElement(By.id("box7"));
//		WebElement drop = driver.findElement(By.id("box107"));
//		a.dragAndDrop(drag, drop).perform();
//		
//		// Opening a link in a new Tab
//		
//		WebElement compendiumdevLink = driver.findElement(By.linkText("compendiumdev"));
//		a.keyDown(Keys.CONTROL).click(compendiumdevLink).keyUp(Keys.CONTROL).build().perform();
//		
//		// Send Keys
//		
//		WebElement userid = driver.findElement(By.name("userid"));
//		WebElement password = driver.findElement(By.name("pswrd"));
//		userid.sendKeys("Sanjay");
//		a.sendKeys(Keys.TAB).perform();
//		password.sendKeys("897455");
//		a.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
//	
//	    // Keys class
//		
//		WebElement userid = driver.findElement(By.name("userid"));
//		userid.sendKeys("Sanjay", Keys.CONTROL,"z");
//		
//		// Taking Screenshot
//		
		
		
		
		
		
		
		driver.quit();
		
		
		

	}

}
