/**
 * 
 */
package com.mystoreTestScript.Axelerant;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pompages.axelerant.HomePage;
import com.pompages.axelerant.LandingPage;
import com.pompages.axelerant.SignInPage;
import com.dataprovider.axelerant.DataProviders;
import com.genericreusable.axelerant.Action;
import com.genericreusable.axelerant.BaseClass;

/**
 * @author AKS WORLD
 *
 */
@Listeners(com.genericreusable.axelerant.ListenerClass.class)
public class Testcase_Loginpage extends BaseClass {
	LandingPage Lpage;
	SignInPage signinpage;
	HomePage homePage;
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
	public void loginTest(String uname,String pswd) throws Throwable 
	{
		Lpage=new LandingPage();
		signinpage=Lpage.clickOnSignIn();
		//homepage=signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		homePage=signinpage.login(uname,pswd, homePage);
		//Action.screenShot(getDriver(), "ss1");
		String acturl=homePage.getcurrentUrl();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(acturl, expectedURL);
		
	}

}
