package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import objectRepoistary.LandingPage;
import objectRepoistary.LoginPage;
import objectRepoistary.errorValidation;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

	@Given("^Initialize chrome driver$")
	public void initialize_chrome_driver() throws Throwable {
		driver = initializeDriver();
	}

	@Given("^Navigating to \"([^\"]*)\"$")
	public void navigating_to(String arg1) throws Throwable {
		driver.get(arg1);

	}

	@Given("^click on login link  to land on sign in page$")
	public void click_on_login_link_to_land_on_sign_in_page() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		if (lp.getPopupSize() > 0) {
			lp.popup().click();
		}
		lp.Login().click();

	}

	@When("^user enters valid (.+) and (.+) and logs in$")
	public void user_enters_valid_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage l = new LoginPage(driver);
		l.emailId().sendKeys(username);
		l.pwd().sendKeys(password);
		l.submit().click();
	}

	@Then("^verify the user is successfully naviagtes to sign page$")
	public void verify_the_user_is_successfully_naviagtes_to_sign_page() throws Throwable {
		errorValidation d = new errorValidation(driver);
		d.error().getText();
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}