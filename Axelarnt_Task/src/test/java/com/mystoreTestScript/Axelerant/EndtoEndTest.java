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
import com.pompages.axelerant.AddressPage;
import com.pompages.axelerant.AddtoCartPage;
import com.pompages.axelerant.LandingPage;
import com.pompages.axelerant.OrderConfirmationPage;
import com.pompages.axelerant.OrderPage;
import com.pompages.axelerant.OrderSummary;
import com.pompages.axelerant.PaymentPage;
import com.pompages.axelerant.ShippingPage;
import com.pompages.axelerant.SignInPage;
import com.pompages.axelerant.fillter_sorting;

/**
 * @author AKS WORLD
 *
 */
public class EndtoEndTest extends BaseClass {
	fillter_sorting filtsort ;
	private LandingPage Lpage;
	private AddtoCartPage addToCartPage;
	private OrderPage orderPage;
	 SignInPage signinpage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

	//@Parameters("browser")
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
	
	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		//Log.startTestCase("endToEndTest");
		Lpage= new LandingPage();
		signinpage=new SignInPage();
		filtsort=new fillter_sorting();
		filtsort.overonwomenoption();
		filtsort.clickonsummeroption();
		filtsort.overonwomenoption();
		addToCartPage=filtsort.selectoneproduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		signinpage=orderPage.clickOnCheckOut();
		addressPage=signinpage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		//Log.endTestCase("endToEndTest");
	}
	

}
