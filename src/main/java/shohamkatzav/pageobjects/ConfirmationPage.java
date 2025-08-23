package shohamkatzav.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import shohamkatzav.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	

	WebDriver driver;
			
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
	@FindBy(xpath="//td[@class='box']")
	WebElement firstBox;
	
	By orderID = By.xpath(".//label");
	
	public String getConfiramationMessage() {
		return confirmMsg.getText();
	}
	
	public String getOrderID() {
		return firstBox.findElements(orderID).get(1).getText().split(" ")[1].trim();
	}
	
}
