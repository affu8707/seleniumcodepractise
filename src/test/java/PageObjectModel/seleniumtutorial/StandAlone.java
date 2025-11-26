package PageObjectModel.seleniumtutorial;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.TestComponents.BaseTest;

public class StandAlone extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"Purchase"})
	public void standAl(HashMap<String,String> input) throws IOException, InterruptedException {

		LandingPage landingpage = launchApplication();

		productCatalogue productcatalogue = landingpage.login_application(input.get("email"), input.get("password"));
		// LandingPage LandingPage = new LandingPage(driver);

		// Now take the list of all product using some similarity

		List<WebElement> products = productcatalogue.getProductList();

		productcatalogue.addProductToCart(input.get("products"));

		cartPage cartpage = productcatalogue.goToCartPage();

		// Here we are using JAVA streams method

		// until the loading button works

		// Now click on add to cart button and open cart

		// Now we are in Add to cart page

		// Here we are if any product is present in add to cart or not

		// Thread.sleep(2000); // or better, wait for toast to disappear completely

		// Now we are clicking on check out button

		Boolean match = cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

		CheckoutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();

		String confirmMessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "standAl" }) // This will execute after first method will complete
	public void OrderHistoryTest() {

		// ZARA COAT 3 is present on order history or not
		productCatalogue productcatalogue = landingpage.login_application("affu@gmail.com", "Afnan@123");
		orderPage orderpage = productcatalogue.goToOrdersPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException // here we can test different data test in same method using DataProvider
	{
		//HashMap<String,String> map = new HashMap<String,String>();
		//map.put("email", "affu@gmail.com");
		//map.put("password", "Afnan@123");
		//map.put("product", "ZARA COAT 3");
		
		//HashMap<String,String> map1 = new HashMap<String,String>();
		//map1.put("email", "afnanabbas731@gmail.com");
		//map1.put("password", "Affu@123");
		//map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\HP\\eclipse-workspace\\seleniumtutorial\\src\\test\\java\\PageObjectModel\\data\\PurchaseOrder.json");
		
		return new Object[][] { {data.get(0)}, {data.get(1)} }; // object
																												// accept
																												// any
		// type of datatype just like int, string
		
	}

}
