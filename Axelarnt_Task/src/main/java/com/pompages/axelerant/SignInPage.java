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
public class SignInPage extends BaseClass {
	Action action= new Action();
	@FindBy(id="email")
	WebElement EnterUsername;
	
	@FindBy(id="passwd")
	WebElement EnterPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement Clicksignin;
	
	
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname,String pswd, HomePage homepage) throws Throwable 
	{
		action.scrollByVisibilityOfElement(getDriver(), EnterUsername);
		action.type(EnterUsername, uname);
		action.type(EnterPassword, pswd);
		action.click(getDriver(),Clicksignin);
		Thread.sleep(2000);
		
		  HomePage homePage=new HomePage(); 
		  return homePage;
	}
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), EnterUsername);
		action.type(EnterUsername, uname);
		action.type(EnterPassword, pswd);
		action.click(getDriver(), Clicksignin);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}

}
