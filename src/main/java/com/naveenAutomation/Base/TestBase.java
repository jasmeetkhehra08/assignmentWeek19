package com.naveenAutomation.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naveenAutomation.Listeners.WebdriverEvents;
import com.naveenAutomation.browsers.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public Browsers browser = Browsers.CHROME;
	
	public static WebdriverEvents events=new WebdriverEvents();
	public EventFiringWebDriver eventFiringWebDriver;

	public void launchBrowser() {

		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}
		
		eventFiringWebDriver=new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(events);
		driver=eventFiringWebDriver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		// Manage the page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Manage the script load timeout
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		// Launch a page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}

	public void quitBrowser() {
		// closing the browser
		driver.quit();
	}

}