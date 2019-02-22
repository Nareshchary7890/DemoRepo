package com.crm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utilities.Utility;

public class BaseConfig {

	public static WebDriver driver;
	public static Properties prop;

	public BaseConfig() {
		try {
			prop = new Properties();
			FileInputStream IP = new FileInputStream("G:\\Selenium\\Selenium_3.141_Workspace\\FreeCRMApp"
					+ "\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
			prop.load(IP);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String Browsername = prop.getProperty("Browser");
		if (Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\geckodriver-v0.23.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicitlyWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));

	}

}
