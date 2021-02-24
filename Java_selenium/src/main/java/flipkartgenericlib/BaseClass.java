package flipkartgenericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class BaseClass
{
		public FileUtility flib=new FileUtility();
		public WebdriverUtility wlib=new WebdriverUtility();

	     public static WebDriver driver;
		
		
		@BeforeTest
		public void configBT() throws Throwable {
			String URL  = flib.getPropertyKeyValue("url");

			String Browser  = flib.getPropertyKeyValue("browser");
			//used for cross browser exceution
			if( Browser.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}else if(Browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}else if(Browser.equalsIgnoreCase("ie")) {
				driver=new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			wlib.waitForHTMLDOM(driver);
			driver.get(flib.getPropertyKeyValue("url"));
		}
		

		@AfterTest
		public void configAT() {
			driver.close();
			//close browser launched in cross browser testing
		}

}
