package objectRepoistary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[id='user_email']")
	WebElement email;

	@FindBy(css = "[type='password']")
	WebElement password;

	@FindBy(css = "[value='Log In']")
	WebElement proceed;

	@Test
	public WebElement emailId() {
		return email;

	}

	@Test
	public WebElement pwd() {
		return password;

	}

	@Test
	public WebElement submit() {
		return proceed;

	}
}
