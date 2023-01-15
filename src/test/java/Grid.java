import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grid {
	WebDriver driver = null;
	DesiredCapabilities desiredCapabilities;

	@BeforeMethod
	public void setUp() {

		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setPlatform(Platform.WINDOWS);
		desiredCapabilities.setBrowserName("chrome");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-Maximized");
		chromeOptions.addArguments("--incognito");

		chromeOptions.merge(desiredCapabilities);
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.2.16:4444"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		driver.get("https://www.selenium.dev/documentation/grid/getting_started/");
		System.out.println("Title of the page: " + driver.getTitle());
	}

	@Test
	public void test2() {
		driver.get("https://www.google.com/");
		System.out.println("Title of the page: " + driver.getTitle());
	}

	@Test
	public void test3() {
		driver.get("https://ca.hotels.com/?locale=en_CA&pos=HCOM_CA&siteid=300000002");
		System.out.println("Title of the page: " + driver.getTitle());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
