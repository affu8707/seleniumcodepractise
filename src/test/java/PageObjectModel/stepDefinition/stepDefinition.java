package PageObjectModel.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjectModel.TestComponents.BaseTest;
import PageObjectModel.seleniumtutorial.CheckoutPage;
import PageObjectModel.seleniumtutorial.ConfirmationPage;
import PageObjectModel.seleniumtutorial.LandingPage;
import PageObjectModel.seleniumtutorial.cartPage;
import PageObjectModel.seleniumtutorial.productCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class stepDefinition extends BaseTest {

	public LandingPage landingpage;
	public productCatalogue productcatalogue;
	public ConfirmationPage confirmationpage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingpage = launchApplication();
	}
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages2() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages3() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages4() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages5() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages6() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Pages7() throws IOException {
		System.out.println("I landed on Ecommerce Page");
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {

		 productcatalogue = landingpage.login_application(username,password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productcatalogue.getProductList();

		productcatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		cartPage cartpage = productcatalogue.goToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckoutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("india");
		confirmationpage = checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
