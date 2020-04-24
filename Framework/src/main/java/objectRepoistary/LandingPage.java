package objectRepoistary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By getPopupSize = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	By popup = By.xpath("//button[contains(text(),'NO THANKS')]");

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement login;

	@FindBy(xpath = "//h3[contains(text(),'An Academy to learn Everything about Testing')]")
	WebElement headingText;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']")
	WebElement navigation;



	@Test
	public int getPopupSize() {
		return driver.findElements(getPopupSize).size();

	}

	@Test
	public WebElement popup() {
		return driver.findElement(popup);

	}

	@Test
	public WebElement Login() {
		return login;

	}

	@Test
	public WebElement heading() {
		return headingText;

	}

	@Test
	public WebElement navigation() {
		return navigation;

	}
}
