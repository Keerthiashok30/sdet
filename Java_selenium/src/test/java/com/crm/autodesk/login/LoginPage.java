package com.crm.autodesk.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Genericlib.FileUtility;
import ObjectRespository.Login;

public class LoginPage
{
	public FileUtility flib=new FileUtility();
	public WebDriver driver=null;
	@Test
	public void loginpagevtiger() throws Throwable 
	{
		String Browser = flib.generatevalue("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(flib.generatevalue("url"));
		Login log= new Login(driver);
		log.logincredentials(flib.generatevalue("username"), flib.generatevalue("password"));
	}

}
