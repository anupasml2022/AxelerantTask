/**
 * 
 */
package com.mystoreTestScript.Axelerant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genericreusable.axelerant.BaseClass;
import com.pompages.axelerant.AddtoCartPage;
import com.pompages.axelerant.LandingPage;

import com.pompages.axelerant.fillter_sorting;

/**
 * @author AKS WORLD
 *
 */
public class Testcase_sort_filter extends BaseClass {
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
	@Test
	public void sortfilter() throws Throwable
	{
		filtsort=new fillter_sorting();
		filtsort.overonwomenoption();
		Thread.sleep(5000);
		filtsort.clickonsummeroption();
		Thread.sleep(5000);
		filtsort.selectoneproduct();
		Thread.sleep(5000);
	}

}
