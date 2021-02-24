package com.autodesk.flipkart;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVWriter;
import Genericlib.FileUtility;
import flipkartObjectRespo.Homepage;
import flipkartgenericlib.BaseClass;

public class PurchaseProduct extends BaseClass
{
	@Test
	public void iphonesearchtestcase() throws Throwable
	{
		
		Homepage hp=new Homepage(driver);
		hp.getLoginPopup().click();
		hp.getSearchBOX().sendKeys("iphones",Keys.ENTER);
		WebElement searchResult = hp.getContentVal();
		Assert.assertEquals(searchResult.isDisplayed(), true);
		List<WebElement> devicelist = hp.getIphonedevices();
		List<WebElement> pricelist = hp.getIphonePrice();
		List<WebElement> ratingslist = hp.getIphoneRatings();
		String[] headr = {"Device Details", "Price", "Ratings"};
		List<String[]> list = new ArrayList<String[]>();
		list.add(0,headr);
		for(int i=0;i<devicelist.size();i++)
		{
			String[] row1 = {devicelist.get(i).getText(),pricelist.get(i).getText().substring(1),ratingslist.get(i).getText()};
			list.add(i, row1);
		}
		CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/Iphonedetails.csv"));
		writecsv.writeAll(list);
		writecsv.close();
		
	}
}


