package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class base {

	public static WebDriver driver;
	public Properties prop;

	@Test
	public WebDriver initializeDriver() throws IOException {
		// "C:\\Users\\rohit\\Framework
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		// String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");

		if (browserName.contains("chrome")) {
			// C:\\Users\\rohit\\Downloads\\Selenium jars\\
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\ChromeDriver.exe");
			ChromeOptions c = new ChromeOptions();
			if (browserName.contains("headless")) {
				c.addArguments("headless", "user-agent=mrbean");
			}
			driver = new ChromeDriver(c);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		// String screenName= System.currentTimeMillis()+ ".png";
		// System.getProperty("user.dir") + "\\src\\main\\java\\resources\\screenshots
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\screenshots\\"
				+ result + "Screenshot.jpg"));

	}
}
