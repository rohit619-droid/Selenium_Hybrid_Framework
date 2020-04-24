package hybrid;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import objectRepoistary.LandingPage;
import resources.base;

public class AssertionTestHeading extends base {

	public static Logger log = LogManager.getLogger(AssertionTestHeading.class.getName());

	@BeforeTest
	public void initialze() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialized...");

		driver.get(prop.getProperty("url"));
		log.info("Hit url..");
	}

	@Test
	public void Text() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.heading().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT ESTING");
		log.info("Given should match the Expected condition");

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver = null;
		log.info("Should teardown the task....");

	}

}
