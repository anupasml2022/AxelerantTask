/**
 * 
 */
package com.mystoreTestScript.Axelerant;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dataprovider.axelerant.DataProviders;
import com.genericreusable.axelerant.BaseClass;
import com.pompages.axelerant.HomePage;
import com.pompages.axelerant.LandingPage;
import com.pompages.axelerant.Newletterpage;
import com.pompages.axelerant.SignInPage;

/**
 * @author AKS WORLD
 *
 */
public class Testcase_Newsletter extends BaseClass {
	Newletterpage newsletterpage;
	
	@BeforeMethod
	public void setup() 
	{
		Lunchapp();
	}
	@AfterMethod
	public void tearDown() 
	{
		getDriver().quit();
	}
	@Test(dataProvider = "NewsletterEmail",dataProviderClass = DataProviders.class)
	public void subscribetonewsletter(String newsmailid) throws Throwable 
	{
		newsletterpage=new Newletterpage();
		newsletterpage.enteremailid(newsmailid);
		newsletterpage.clicknext();
		boolean result=newsletterpage.validatesuccessmessage();
		//Reporter.log(result);
		Assert.assertTrue(result);
		 		
		
	}



}
