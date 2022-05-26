/**
 * 
 */
package com.genericreusable.axelerant;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author AKS WORLD
 *
 */
public class ListenerClass extends BaseClass implements ITestListener {
	public void onTestStart(ITestResult result) 
	{
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		
	}

	public void onTestFailure(ITestResult result)
	{
		
		Action.screenShot(getDriver(), result.getName());
	}

	public void onTestSkipped(ITestResult result) 
	{
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
