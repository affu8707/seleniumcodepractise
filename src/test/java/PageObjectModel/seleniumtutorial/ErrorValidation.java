package PageObjectModel.seleniumtutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void ErrorMessage() {
		
		
		landingpage.login_application("affu@gmail.com", "Afnan@123");
		
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
	
}
