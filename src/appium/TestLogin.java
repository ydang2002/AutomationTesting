package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import appiumExcel.Links;
import appiumExcel.ReadFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestLogin {
	
	AppiumDriver<WebElement> driver;
    String fileName = "app-release.apk";
    File calculatorApp = new File("D:\\src\\Android\\app\\AppToDoList\\app\\release" + fileName);
    
    @BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		// khai báo platform
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "WCY7N18316013223");
        driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
    
    @Test(dataProvider="loginData")
	public void f(String email, String password) throws Exception {
		//set up đường dẫn file excel
//		final String excelFilePath = "D:/src/Java/src/JaVaTestAppium/src/Data/Login.xlsx";
//		excel.setExcelFile(excelFilePath, "Sheet1");
//		
//		login = new login();
//		
//		for (int i = 1; i < 6; i++) {
//			// Đọc data từ file excel
//			logIn(excel.getCellData("user", i), excel.getCellData("password", i));
//			
//		}
    	
//		WebElement edtMail = driver.findElement(By.id("com.nhuy.todolist:id/loginEmail"));
//		edtMail.clear();
//		edtMail.sendKeys(email);
//		
//		WebElement edtPassword = driver.findElement(By.id("com.nhuy.todolist:id/loginPassword"));
//		edtPassword.clear();
//		edtPassword.sendKeys(password);
//		
//		WebElement btnLogin = driver.findElement(By.id("com.nhuy.todolist:id/loginButton"));
//		btnLogin.click();
    	
    	logIn(email, password);
    					
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();//thoát
	}
	
	public void logIn(String email, String password) {
		WebElement edtMail = driver.findElement(By.id("com.nhuy.todolist:id/loginEmail"));
		edtMail.clear();
		edtMail.sendKeys(email);
		
		WebElement edtPassword = driver.findElement(By.id("com.nhuy.todolist:id/loginPassword"));
		edtPassword.clear();
		edtPassword.sendKeys(password);
		
		WebElement btnLogin = driver.findElement(By.id("com.nhuy.todolist:id/loginButton"));
		btnLogin.click();
		//driver.findElement(edtMail).sen
	}
	
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() throws Exception {
		ReadFile.setExcelFile(Links.PATH_TO_EXCEL, "Sheet1");
		Object[][] testData = ReadFile.getTestData("invalid");
		return testData;
	}

}
