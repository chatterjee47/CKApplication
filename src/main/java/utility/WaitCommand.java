package utility;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;

public class WaitCommand {
	
	  WebDriver driver;
	 
	 public WaitCommand(WebDriver driver) {
	        this.driver = driver;
	   }
	 
	 //use : WebElement textbox = fluentWait(By.id("textbox"));
	
	public WebElement fluentWait(final By locator) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });
	    return  foo;
	};
	
	
	
	public boolean waitForPageLoad(int waitTimeInSec, ExpectedCondition<Boolean>... conditions) {
	    boolean isLoaded = false;
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(waitTimeInSec, TimeUnit.SECONDS)
	            .ignoring(StaleElementReferenceException.class)
	            .pollingEvery(2, TimeUnit.SECONDS);
	    for (ExpectedCondition<Boolean> condition : conditions) {
	        isLoaded = wait.until(condition);
	        if (isLoaded == false) {
	            //Stop checking on first condition returning false.
	            break;
	        }
	    }
	    return isLoaded;
	}
	
	//use : element(By.cssSelector("h1.logo")).click();
	public WebElement element(By locator){
	    Integer timeoutLimitSeconds = 20;
	    WebDriverWait wait = new WebDriverWait(driver, timeoutLimitSeconds);
	    try {
	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	    catch(TimeoutException e){
	        throw new NoSuchElementException(locator.toString());
	    }
	    WebElement element = driver.findElement(locator);
	    return element;
	}
	
	public void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public void PageLoad(WebElement value){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(value));
	} 
	
	public void waitForPageLoad() {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
	
	public static boolean isloadComplete(WebDriver driver)
	{
	    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
	            || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
	
	

   public WebElement waitForMe(By locatorname, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(WaitCommand.presenceOfElementLocated(locatorname));
   }

   public static Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
         // TODO Auto-generated method stub
         return new Function<WebDriver, WebElement>() {
              public WebElement apply(WebDriver driver) {
                   return driver.findElement(locator);
              }
         };
   }

   
   public void waittime(){
	   long timeOut = 5000;
	    long end = System.currentTimeMillis() + timeOut;

	        while (System.currentTimeMillis() < end) {

	            if (String.valueOf(
	                    ((JavascriptExecutor) driver)
	                            .executeScript("return document.readyState"))
	                    .equals("complete")) {
	                break;
	            }
	        }
   }
   
   
   
   public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {

	    FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.SECONDS)
	        .pollingEvery(pollingSec, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

	    for (int i = 0; i < 2; i++) {
	        try {
	            //fWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='reportmanager-wrapper']/div[1]/div[2]/ul/li/span[3]/i[@data-original--title='We are processing through trillions of data events, this insight may take more than 15 minutes to complete.']")));
	        fWait.until(ExpectedConditions.visibilityOf(element));
	        fWait.until(ExpectedConditions.elementToBeClickable(element));
	        } catch (Exception e) {

	        System.out.println("Element Not found trying again - " + element.toString().substring(70));
	        e.printStackTrace();

	        }
	    }

	    return element;

	    }
   
   

   public static void wait(int ms)
   {
       try
       {
           Thread.sleep(ms);
       }
       catch(InterruptedException ex)
       {
           Thread.currentThread().interrupt();
       }
   }
   
   
   
   
   public void waitForPageLoaded() {
       ExpectedCondition<Boolean> expectation = new
               ExpectedCondition<Boolean>() {
                   public Boolean apply(WebDriver driver) {
                       return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                   }
               };
       try {
         //  Thread.sleep(1000);
           WebDriverWait wait = new WebDriverWait(driver, 10000);
           wait.until(expectation);
       } catch (Throwable error) {
         //  Assert.fail("Timeout waiting for Page Load Request to complete.");
       }
   }
   
   
   
   
   public void E_WaitUntilElementDisplay(String locator) throws Exception
   {
       int i=1;
       boolean eleche,eleche1 = false; 
       while(i<=1)
       {
               try{
                   eleche = driver.findElements(By.xpath(locator)).size()!=0;
               }catch(InvalidSelectorException ISExcep)
               {
                   eleche = false;
               }
               if(eleche == true)
               {

                   while(i<=1)
                   {
                       try{
                           eleche1=driver.findElement(By.xpath(locator)).isDisplayed();
                       }catch(org.openqa.selenium.NoSuchElementException NSEE){
                           eleche1=false;
                       }
                       if(eleche1 == true)
                       {
                           i=2;
                           System.out.println("\nElement Displayed.");
                       }
                       else
                       {
                           i=1;
                           Thread.sleep(2000);
                           System.out.println("\nWaiting for element, to display.");
                       }
                   }
               }
               else
               {
                   i=1;
                   Thread.sleep(2000);
                   System.out.println("\nWaiting for element, to display.");
               }
       }
   }
   
   
   public void WaitTillPageLoad() throws InterruptedException {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   for (int i = 0; i >= 50000; i++) {
	   try {
	   System.out.println("Page is Loading");

	   } catch (Exception e) {

	   }
	   if (js.executeScript("return document.readyState").toString().equals("complete")) {
	   System.out.println("Page Loaded Completely");
	   break;
	   } else {
	   System.out.println("Page is not Loaded Completely");
	   }
	   }
	   }
   
}
   

