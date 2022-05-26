/**
 * 
 */
package com.pompages.axelerant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericreusable.axelerant.Action;
import com.genericreusable.axelerant.BaseClass;

/**
 * @author AKS WORLD
 *
 */
public class AddressPage extends BaseClass {
Action action= new Action();
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
    WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}

}
