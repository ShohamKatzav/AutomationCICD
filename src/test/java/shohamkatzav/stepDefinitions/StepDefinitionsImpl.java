package shohamkatzav.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shohamkatzav.TestComponents.BaseComponent;
import shohamkatzav.pageobjects.CartPage;
import shohamkatzav.pageobjects.CheckoutPage;
import shohamkatzav.pageobjects.ConfirmationPage;
import shohamkatzav.pageobjects.LandingPage;
import shohamkatzav.pageobjects.ProductCatalog;

public class StepDefinitionsImpl extends BaseComponent{
	
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pag() throws IOException {
		landingPage = lanchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		productCatalog = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) from Cart$")
	public void I_add_product_from_Cart(String productName) throws InterruptedException {
		productCatalog.addProductToCart(productName);
		productCatalog.goToCartPage();
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalog.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("isr");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	//Then "Thankyou for the order." message is displayed on ConfirmationPage
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_on_ConfirmationPage(String string) {
		String confirmMsg = confirmationPage.getConfiramationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));
		driver.quit();
	}
	
	@Then("{string} message is displayed")
	public void something_message_is_displayed(String string) {
		assertEquals(landingPage.getLoginErrorMessage(), string);	
		driver.quit();
	}

}
