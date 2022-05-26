/**
 * 
 */
package com.mystoreTestScript.Axelerant;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pompages.axelerant.AddtoCartPage;
import com.pompages.axelerant.HomePage;
import com.pompages.axelerant.LandingPage;

import com.pompages.axelerant.SignInPage;
import com.pompages.axelerant.fillter_sorting;
import com.dataprovider.axelerant.DataProviders;
import com.genericreusable.axelerant.BaseClass;

/**
 * @author AKS WORLD
 *
 */
public class Testcase_addtocartpage extends BaseClass {
	LandingPage Lpage;
	AddtoCartPage addToCartPage;
	
	fillter_sorting filtsort ;
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
	
	@Test(dataProvider="getProduct",dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName,String qty,String size) throws Throwable {
		
		Lpage= new LandingPage();
		filtsort=new fillter_sorting();
		filtsort.overonwomenoption();
		filtsort.clickonsummeroption();
		filtsort.overonwomenoption();
		addToCartPage=filtsort.selectoneproduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		System.out.println(result);
		Assert.assertTrue(result); 
		 		
	}

}
