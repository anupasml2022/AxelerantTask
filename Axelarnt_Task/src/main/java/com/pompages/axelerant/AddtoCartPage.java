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
public class AddtoCartPage extends BaseClass {
Action action= new Action();
	
	@FindBy(id="quantity_wanted")
	 WebElement quantity;
	
	@FindBy(name="group_1")
	 WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	 WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	 WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	 WebElement proceedToCheckOutBtn;
	
	public AddtoCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(getDriver(), addToCartMessag, 10);
		return Action.isDisplayed(getDriver(), addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}

}
