package utility;

import org.openqa.selenium.WebDriver;

public class Utilities {
	 WebDriver driver;
	 
	protected boolean isTextPresent(String text){
	    return driver.getPageSource().contains(text);
	}
}
