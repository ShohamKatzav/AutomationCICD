package shohamkatzav.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shohamkatzav.TestComponents.BaseComponent;
import shohamkatzav.pageobjects.CartPage;
import shohamkatzav.pageobjects.CheckoutPage;
import shohamkatzav.pageobjects.ConfirmationPage;
import shohamkatzav.pageobjects.OrdersPage;
import shohamkatzav.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseComponent{
	

	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> map) throws InterruptedException {
		// TODO Auto-generated constructor stub

		ProductCatalog productCatalog = landingPage.loginApplication(map.get("email"), map.get("password"));
		
		productCatalog.addProductToCart(map.get("product"));
		CartPage cartPage = productCatalog.goToCartPage();
		
		boolean match = cartPage.verifyProductDisplay(map.get("product"));
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		
		checkoutPage.selectCountry("isr");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMsg = confirmationPage.getConfiramationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		
		System.out.println(confirmationPage.getOrderID());	
	}
	
	@Test(dependsOnMethods = "submitOrder", dataProvider = "getData", groups = {"Purchase"})
	public void OrderHistoryTest(HashMap<String, String> map) throws InterruptedException {
		ProductCatalog productCatalog = landingPage.loginApplication(map.get("email"), map.get("password"));
		OrdersPage ordersPage = productCatalog.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(map.get("product")));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src/test//java//shohamkatzav//data//PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
		
	}


	
//	@DataProvider
//	public Object[][] getData() {
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "Shoham@gmail.com");
//		map1.put("password", "Aa123456!");
//		map1.put("product", "ZARA COAT 3");
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("email", "Shoham2@gmail.com");
//		map2.put("password", "Aa123456!");
//		map2.put("product", "ADIDAS ORIGINAL");
//		return new Object [][] {{map1},{map2}};
//		
//	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object [][] {{"Shoham@gmail.com", "Aa123456!", "ZARA COAT 3"},{"Shoham2@gmail.com", "Aa123456!", "ADIDAS ORIGINAL"}};
//		
//	}
}
