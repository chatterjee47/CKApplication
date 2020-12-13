package TestCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Testing {
	
	  static WebDriver driver;

	public static void main(String[] args) throws Exception {
	/*	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		  
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability("requireWindowFocus", true);  
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
		capabilities.setCapability("ie.ensureCleanSession", true);
	//	capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,false);*/


		
		///////////////////////////////////////////////////////////
		
		/* String service = "C:\\Users\\Rush 14\\Desktop\\Documents\\Resume\\config\\drivers\\IEDriverServer.exe";
		 System.setProperty("webdriver.ie.driver", service);
		
		// Create the DesiredCapability object of InternetExplorer
		 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 
		 // Settings to Accept the SSL Certificate in the Capability object
		 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 
		 InternetExplorerDriver driver = new InternetExplorerDriver(capabilities); */
		
		
		
		
	//	System.setProperty("webdriver.ie.driver","C:\\Users\\Rush 14\\Desktop\\Documents\\Resume\\config\\drivers\\IEDriverServer.exe");
		// WebDriver driver = new InternetExplorerDriver(capabilities);
		
	//	WebDriver driver = new InternetExplorerDriver();
		 
		 
		 
		 
		 
		 
		// ============================================================================================
		 
		 
		 
		 
		 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 File file = new File(System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
		 System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		 WebDriver driver = new InternetExplorerDriver(capabilities);

		 System.out.println("Internet Explorer is selected");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 driver.manage().window().maximize();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		driver.get("https://www.ck12.org/student/");
		Thread.sleep(1000);
		
		WebElement searchBtn = driver.findElement(By.xpath("//ul[@class='sc-hzDkRC jGsNo']/li/a/span[contains(text(),'sign in')]"));

		Actions action = new Actions(driver);
		action.moveToElement(searchBtn).click().build().perform();
		
		
		Thread.sleep(5000);
		WebElement goButton = driver.findElement(By.xpath("//ul[@class='sc-hzDkRC jGsNo']/li/a/span[contains(text(),'sign in')]"));
		safeJavaScriptClick(goButton);
		
	//	driver.findElement(By.xpath("//span[contains(text(),'sign in')]")).click();
		Thread.sleep(5000);

	}
	
	
	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
}


