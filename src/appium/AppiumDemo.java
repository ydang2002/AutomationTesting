package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
public class AppiumDemo {
	AppiumDriver<WebElement> driver;
    String fileName = "app-release.apk";
    File calculatorApp = new File("D:\\src\\Android\\app\\AppToDoList\\app\\release" + fileName);
	
	
	
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		// khai báo platform
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("appPackage", "com.nhuy.todolist");
//        cap.setCapability("platformVersion", "9");
//        //cap.setCapability("appActivity", "com.nhuy.todolist.LoginActivity");
//        // khai báo deviceName
//        cap.setCapability("deviceName", "WCY7N18316013223");
//        //version android
//        //cap.setCapability("platforName", "emulator-5554");
//        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// khai báo platform
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "WCY7N18316013223");
        driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void f() {
		//1.Điền mail
		//Khai báo id
		WebElement edtMail = driver.findElement(By.id("com.nhuy.todolist:id/loginEmail"));
		// xóa ô mail
		edtMail.clear();
		edtMail.sendKeys("nhuyyy@gmail.com");
		//2.Điền password
		//Khai báo id
		WebElement edtPassword = driver.findElement(By.id("com.nhuy.todolist:id/loginPassword"));
		// xóa ô password
		edtPassword.clear();
		edtPassword.sendKeys("12345678");
		//3.click login
		WebElement btnLogin = driver.findElement(By.id("com.nhuy.todolist:id/loginButton"));
		btnLogin.click();
		// so sánh kết quả mong đợi với kết quả thực tế
		// Viết cau7 lệnh lấy kết quả
		//WebElement mess = driver.findElement(By.id("android:id/message"));
		//
		//Assert.assertEquals(messError.getText(), "");
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
