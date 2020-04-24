package hybrid;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import objectRepoistary.LandingPage;
import objectRepoistary.LoginPage;
import resources.base;

public class MainTest extends base {

	public static Logger log = LogManager.getLogger(AssertionTestHeading.class.getName());

	@BeforeTest
	public void initialze() throws IOException {
		driver = initializeDriver();

		log.info("Driver initialized...");

	}

	@Test(dataProvider = "getData")
	public void homePage(String userName, String password, String type) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		log.info("Hitted url...");

		LandingPage lp = new LandingPage(driver);
		if (lp.getPopupSize() > 0) {
			lp.popup().click();
		}
		log.info("Reached Homepage successfully.....");
		lp.Login().click();
		LoginPage l = new LoginPage(driver);

		l.emailId().sendKeys(userName);
		l.pwd().sendKeys(password);
		log.info(type);
		l.submit().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] a = new Object[3][3];
		a[0][0] = "Naruto";
		a[0][1] = "123456";
		a[0][2] = "Sage Mode";

		a[1][0] = "Sasuke";
		a[1][1] = "12345678";
		a[1][2] = "Susuano Mode";

		a[2][0] = "itachi";
		a[2][1] = "abc123";
		a[2][2] = "amatresu Mode";

		return a;

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver = null;
		log.info("Should teardown the task....");

	}

}
