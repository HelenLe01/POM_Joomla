package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;


public class AbstractTest {
	WebDriver driver;
	
	public WebDriver openBrowser(String browser, String url) {

		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "..\\POM_Joomla\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "..\\POM_Joomla\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equals("headless")) {
			   System.setProperty("webdriver.chrome.driver", "..\\POM_Joomla\\resources\\chromedriver.exe");
			   ChromeOptions options = new ChromeOptions();
			   options.addArguments("headless");
			   options.addArguments("window-size=1366x768");
			   driver = new ChromeDriver(options);
			  }
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public boolean verifyTrue(boolean condition) {
    	boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			e.printStackTrace();
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public boolean verifyFalse(boolean condition) {
		try {
			Assert.assertFalse(condition);
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.getCurrentTestResult().setThrowable(e);
			return false;
		}
	}

	public boolean verifyEquals(Object actual, Object expected) {
		try {
			Assert.assertEquals(actual, expected);
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.getCurrentTestResult().setThrowable(e);
			return false;
		}
	}
	public void closeBrowser(WebDriver driver) {
    	try {
			driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				String cmd = "taskkill /IM IEDriverServer.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
