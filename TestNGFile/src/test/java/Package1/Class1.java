package Package1;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class1 extends BaseClass{
	@BeforeClass
	private void beforeclass() {
		browserLaunch("CHROME");
		enterApplnUrl("https://adactinhotelapp.com/");
		maximizeWindow();
		implicitWait(10);
		
		
	}
	@AfterClass
	private void afterclass() {
		closeBrowser();
	}
	
	@BeforeMethod
	private void beforemethod() {
		long startTime=System.currentTimeMillis();
		System.out.println(startTime);
		
	}
	@AfterMethod
	private void aftermethod() {
		long endTime=System.currentTimeMillis();
		System.out.println(endTime);
		
	}
	@Test
	private void login() {
		Loginpage loginpage=new Loginpage();
		// loginpage.login("lotus@123","Selvan313");
		
		
	}
	
}
	

