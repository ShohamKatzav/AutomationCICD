package shohamkatzav.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import shohamkatzav.TestComponents.BaseComponent;
import shohamkatzav.TestComponents.Retry;
import shohamkatzav.pageobjects.CartPage;
import shohamkatzav.pageobjects.ProductCatalog;

public class ErrorValidationsTest extends BaseComponent{

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void LoginErrorValidation() {
		// TODO Auto-generated constructor stub

		landingPage.loginApplication("Shoham@gmail.com", "Aa123456!!");
		assertEquals(landingPage.getLoginErrorMessage(), "Incorrect email or password.");	
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException {
		// TODO Auto-generated constructor stub

		String productName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingPage.loginApplication("Shoham@gmail.com", "Aa123456!");
		
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		
		boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
		
	}

}
