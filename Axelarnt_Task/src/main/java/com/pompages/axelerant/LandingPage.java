package com.pompages.axelerant;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericreusable.axelerant.Action;
import com.genericreusable.axelerant.BaseClass;

public class LandingPage extends BaseClass {
	
	Action action= new Action();
	//public WebgetDriver() getDriver();

	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[contains(@class,'logo img-responsive')]")
	private WebElement myStoreLogo;
	
	
	  @FindBy(id="search_query_top") 
	  private WebElement searchProductBox;
	  
	  @FindBy(name="submit_search") 
	  private WebElement searchButton;
	 
	
	public LandingPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	public SignInPage clicksignIn() 
	{
		action.click(getDriver(), signInBtn);
		return new SignInPage();
	}
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	public String getpageTitle() 
	{
		String pagetitle=getDriver().getTitle();
		return pagetitle;
	}
	public SignInPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		return new SignInPage();
	}
	
	
	 

	

}
