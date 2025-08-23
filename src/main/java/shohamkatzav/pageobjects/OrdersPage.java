package shohamkatzav.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shohamkatzav.AbstractComponent.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	
	WebDriver driver;
	
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	//tr td:nth-child(3)
	
	public boolean verifyOrderDisplay(String productName) {
		return productNames.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	}
	

}
