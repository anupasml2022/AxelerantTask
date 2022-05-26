/**
 * 
 */
package com.mystoreTestScript.Axelerant;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dataprovider.axelerant.DataProviders;
import com.genericreusable.axelerant.BaseClass;
import com.pompages.axelerant.AddtoCartPage;
import com.pompages.axelerant.LandingPage;
import com.pompages.axelerant.OrderPage;

import com.pompages.axelerant.SignInPage;
import com.pompages.axelerant.fillter_sorting;

/**
 * @author AKS WORLD
 *
 */
public class Testcase_OrderPage extends BaseClass {
	LandingPage Lpage;
	AddtoCartPage addToCartPage;
	fillter_sorting filtsort ;
	OrderPage orderPage;
	
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
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		
		Lpage= new LandingPage();
		filtsort=new fillter_sorting();
		filtsort.overonwomenoption();
		filtsort.clickonsummeroption();
		filtsort.overonwomenoption();
		addToCartPage=filtsort.selectoneproduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Thread.sleep(5000);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		//Log.endTestCase("verifyTotalPrice");
	}

}
