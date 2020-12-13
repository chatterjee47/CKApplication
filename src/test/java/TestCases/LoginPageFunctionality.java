package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import BaseClass.BrowserSetup;
import PageObjects.LoginPage;
import utility.WaitCommand;

public class LoginPageFunctionality{
    WebDriver driver;
	LoginPage loginpage;
	BrowserSetup BS;
	
	WaitCommand stop;

	@BeforeMethod
	public void HomePageNavigation() throws Throwable {
		driver = BrowserSetup.StartBrowser("Chrome", "https://www.ck12.org/student/");
	}

	@Test(priority = 0)
	public void LoginPageOne() throws Exception {

		loginpage = new LoginPage(driver);
		loginpage.implicitlyWait();
		loginpage.getSignInButton();
		loginpage.implicitlyWait();
		loginpage.setLoginCredentials("chatterjeeamit42@gmail.com", "Testing123$");
		loginpage.checkPageIsReady();
		loginpage.getlibraryButton();
		loginpage.checkPageIsReady();
		loginpage.getCreateNewButton();
		loginpage.checkPageIsReady();
		loginpage.getQuizButton();
		loginpage.checkPageIsReady();
		
		loginpage.getSwitchIframe();
		loginpage.checkPageIsReady();
		
		loginpage.getQuizNewTitle("test2");
		loginpage.checkPageIsReady();
		
		loginpage.getQuizDescription("test3");
		loginpage.checkPageIsReady();
		 
		loginpage.getNumberofAttempts();
		loginpage.checkPageIsReady();
		
		loginpage.getQuizTimeLimit();
		loginpage.checkPageIsReady();
		
		loginpage.getQuizLanguage();
		loginpage.checkPageIsReady();
		
}
	@AfterMethod
	public void getResult() throws Exception {
		BS= new BrowserSetup();
		BS.TearDown();
	}
}