/**
 * 
 */
package com.pompages.axelerant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericreusable.axelerant.Action;
import com.genericreusable.axelerant.BaseClass;

/**
 * @author AKS WORLD
 *
 */
public class fillter_sorting  extends BaseClass {
	Action action= new Action();
	@FindBy(xpath="//a[contains(@title,'Women')]")
	WebElement hoverwomenoption;
	
	@FindBy(xpath="(//a[@href='http://automationpractice.com/index.php?id_category=11&controller=category'][contains(.,'Summer Dresses')])[1]")
	WebElement clickonsummeroption;
	
	@FindBy(xpath="(//h5[@itemprop='name'][contains(.,'Printed Summer Dress')])[1]")
	WebElement selectoneproduct;
	
	/*
	 * @FindBy(xpath="//i[contains(@class,'icon-th-list')]") WebElement
	 * clickonproduct;
	 */
	
	
	public fillter_sorting() {
		PageFactory.initElements(getDriver(), this);
	}
	public void overonwomenoption() throws Throwable {
		action.moveToElement(getDriver(), hoverwomenoption);
	}
	public void clickonsummeroption() throws Throwable {
		
		action.click(getDriver(), clickonsummeroption);
	}
	public AddtoCartPage selectoneproduct() throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), selectoneproduct);
		action.moveToElement(getDriver(), selectoneproduct);
		action.click(getDriver(), selectoneproduct);
		return new AddtoCartPage();
	}
	

}
