package shohamkatzav.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import shohamkatzav.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	

	WebDriver driver;
			
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".user__address .input")
	private WebElement country;
	
	@FindBy(css=".ta-results button")
	private WebElement selectCountry;
	
	@FindBy(css=".actions a")
	private WebElement submit;
	
	private By result = By.cssSelector(".ta-results button");
	
	public void selectCountry(String countryName) {
		country.sendKeys(countryName);
		waitForElementToAppear(result);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
}
