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
import com.dataprovider.axelerant.DataProviders;
import com.genericreusable.axelerant.BaseClass;

/**
 * @author AKS WORLD
 *
 */
public class Testcase_HomePage extends BaseClass {
	LandingPage Lpage;
	SignInPage signinpage;
	HomePage homepage;
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
	@Test(dataProvider = "Credentials",dataProviderClass = DataProviders.class)
	public void WishlistTest(String uname, String pswd) throws Throwable 
	{
		Lpage=new LandingPage();
		signinpage=Lpage.clickOnSignIn();
		homepage=signinpage.login(uname,pswd,homepage);
		boolean result=homepage.validatemywishlist();
		Assert.assertTrue(result);
		
	}
	@Test(dataProvider = "Credentials",dataProviderClass = DataProviders.class)
	public void orderhistoryTest(String uname, String pswd) throws Throwable 
	{
		Lpage=new LandingPage();
		signinpage=Lpage.clickOnSignIn();
		//homepage=signinpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=signinpage.login(uname,pswd,homepage);
		boolean historyresult=homepage.validateorderhistory();
		Thread.sleep(5000);
		Assert.assertTrue(historyresult);
		
	}


}
