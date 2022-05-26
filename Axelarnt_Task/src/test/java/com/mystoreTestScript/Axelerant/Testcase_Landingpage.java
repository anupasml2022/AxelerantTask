/**
 * 
 */
package com.mystoreTestScript.Axelerant;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pompages.axelerant.HomePage;
import com.pompages.axelerant.LandingPage;
import com.pompages.axelerant.SignInPage;
import com.genericreusable.axelerant.BaseClass;

/**
 * @author AKS WORLD
 *
 */
public class Testcase_Landingpage extends BaseClass {
	LandingPage Lpage;
	//public WebgetgetDriver()() getgetDriver()();
	
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
	@Test
	public void verifylogo() throws Throwable 
	{
		Lpage=new LandingPage();
		Thread.sleep(3000);
		boolean result=Lpage.validateLogo();
		Thread.sleep(3000);
		Assert.assertTrue(result);
	}
	@Test
	public void verifyTitle() 
	{
		Lpage=new LandingPage();
		String actTitle=Lpage.getpageTitle();
		Assert.assertEquals(actTitle, "My Store");
	}

}
