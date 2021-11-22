package com.bigsmall.reusableComponents;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.bigsmall.utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass extends ReadConfig {
	public static Logger log;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public static void initializeReport()
	{
		if(report==null)
		report = new ExtentReports(pro.getProperty("extentPath")+ "ExtentReport-"
				+ System.currentTimeMillis() + ".html");
	}
	public static WebDriver initialize() {
		WebDriver driver = null;
		if (driver == null) {
			if (pro.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",pro.getProperty("chromepath"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			} else if (pro.getProperty("browser").equals("firefox")) {
				System.out.println("not implemented yet.");
			} else if (pro.getProperty("browser").equals("IE")) {
				System.out.println("not implemented yet.");
			}
		}

		return driver;
	}
}
