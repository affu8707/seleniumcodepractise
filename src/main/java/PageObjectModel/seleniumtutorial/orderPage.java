package PageObjectModel.seleniumtutorial;


import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponent.AbstractComponent;

public class orderPage extends AbstractComponent {
	
	WebDriver driver;
	
	public orderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement totalEle;
	
	
	public Boolean VerifyOrderDisplay(String productName)
	{
		Boolean match = productNames.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		return match;
	}
	public CheckoutPage goToCheckOut() {
		totalEle.click();
		return new CheckoutPage(driver);
	}
}
