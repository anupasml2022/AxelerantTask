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
public class Newletterpage extends BaseClass {
	Action action=new Action();
	
	@FindBy(id="newsletter-input")
	WebElement Entermailid;
	
	@FindBy(name="submitNewsletter")
	WebElement Clicknext;
	
	@FindBy(xpath="//p[@class='alert alert-success'][contains(.,'Newsletter : You have successfully subscribed to this newsletter.')]")
	WebElement Successmessage;
	
	
	public Newletterpage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enteremailid(String newsmailid) 
	{
		action.scrollByVisibilityOfElement(getDriver(), Entermailid);
		action.type(Entermailid, newsmailid);
		
	}
	public void clicknext() {
		action.click(getDriver(), Clicknext);
	}
	

	public boolean validatesuccessmessage() {
		action.fluentWait(getDriver(), Successmessage, 10);
		return Action.isDisplayed(getDriver(), Successmessage);
		// TODO Auto-generated method stub
	}
	
	

}
