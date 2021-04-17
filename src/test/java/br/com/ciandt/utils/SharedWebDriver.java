package br.com.ciandt.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Utilitario para evitar duplicacao de codigo
 * 
 * @see <a href=
 *      "https://www.softpost.org/cucumber/sharing-selenium-webdriver-instance-using-picocontainer/">
 *      https://www.softpost.org/cucumber/sharing-selenium-webdriver-instance-using-picocontainer/</a>
 */
public class SharedWebDriver {

	private static boolean startBrowser = false;

	private WebDriver driver;

	@Before
	public void init() {
		if (!startBrowser) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://opentdb.com/");

			// To stop launching browser after every scenario, assign below variable with
			// true value
			startBrowser = false;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@After
	public void cleanUp() {
		driver.close();
		driver.quit();
	}

}