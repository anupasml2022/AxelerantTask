/**
 * 
 */
package com.dataprovider.axelerant;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.util.axelerant.NewExcelLibrary;

/**
 * @author AKS WORLD
 *
 */

	public class DataProviders {

		NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "Credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Credentials");
			// Total Columns
			int column = obj.getColumnCount("Credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Credentials", j, i + 2);
				}
			}
			return data;
		}

	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "email")
		public Object[][] getEmail() {
			// Totals rows count
			int rows = obj.getRowCount("Email");
			// Total Columns
			int column = obj.getColumnCount("Email");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Email", j, i + 2);
				}
			}
			return data;
		}

	//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
		@DataProvider(name = "getProduct")
		public Object[][] getProduct() {
			// Totals rows count
			int rows = obj.getRowCount("ProductDetails");
			// Total Columns
			int column = obj.getColumnCount("ProductDetails");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
				}
			}
			return data;
		}

		// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		@DataProvider(name = "NewsletterEmail")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = obj.getRowCount("NewsletterEmail");
			// Total Columns
			int column = obj.getColumnCount("NewsletterEmail");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("NewsletterEmail", j, i + 2);
				}
			}
			return data;
		}
		
	
		}

	


