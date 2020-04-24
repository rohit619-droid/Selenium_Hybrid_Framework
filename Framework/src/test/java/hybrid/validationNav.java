package hybrid;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepoistary.LandingPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.io.IOException;

import resources.base;

public class validationNav extends base {

	public static Logger log = LogManager.getLogger(AssertionTestHeading.class.getName());

	@BeforeTest
	public void initialze() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialized...");
		driver.get(prop.getProperty("url"));
		log.info("Hit url...");

	}

	@Test
	public void nav() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.navigation().isDisplayed());
		log.info("Should display the expected navagtion...");

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver = null;
		log.info("Should teardown the task....");

	}
}
