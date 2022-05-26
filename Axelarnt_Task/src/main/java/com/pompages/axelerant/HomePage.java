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
public class HomePage extends BaseClass {
	Action action=new Action();
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement mywishlist;
	
	@FindBy(xpath="//span[contains(.,'Order history and details')]")
	WebElement myorderHistory;
	

	public HomePage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validatemywishlist() 
	{
		return Action.isDisplayed(getDriver(), mywishlist);
		
	}
	public boolean validateorderhistory() 
	{
		return Action.isDisplayed(getDriver(), myorderHistory);
		
	}
	

	public String getcurrentUrl() {
		String homepageurl=getDriver().getCurrentUrl();
		return homepageurl;
	}
	

}
