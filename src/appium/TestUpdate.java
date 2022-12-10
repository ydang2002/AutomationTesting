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

public class TestUpdate {
	AppiumDriver<WebElement> driver;
//    String fileName = "app-release.apk";
//    File calculatorApp = new File("D:\\src\\Android\\app\\AppToDoList\\app\\release" + fileName);
    
    @BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		// khai báo platform
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "WCY7N18316013223");
        driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//    
//    @Test(dataProvider="update")
//	public void f(String task, String description, String result) throws Exception {
//    	upDate(task, description, result);
//    	
//    }
    
    @Test
	public void f() throws Exception {
    	delete(); 
    }
    
    @AfterTest
	public void afterTest() {
		driver.quit();//thoát
	}
    
    public void upDate(String task, String description, String result) {
    	
    	WebElement retrieved = driver.findElement(By.id("com.nhuy.todolist:id/retrieved"));
    	retrieved.click();
    	
    	WebElement edtTask = driver.findElement(By.id("com.nhuy.todolist:id/mEditTextTask"));
    	edtTask.clear();
    	edtTask.sendKeys(task);
		
		WebElement edtDescription = driver.findElement(By.id("com.nhuy.todolist:id/mEditTextDescription"));
		edtDescription.clear();
		edtDescription.sendKeys(description);

		WebElement updateBtn = driver.findElement(By.id("com.nhuy.todolist:id/btnUpdate"));
		updateBtn.click();
		
    	WebElement cancelBtn = driver.findElement(By.id("com.nhuy.todolist:id/btnCancelUpdate"));
    	cancelBtn.click();
    }
    
    public void delete()  {
    	WebElement retrieved = driver.findElement(By.id("com.nhuy.todolist:id/retrieved"));
    	retrieved.click();
    	WebElement deleteBtn = driver.findElement(By.id("com.nhuy.todolist:id/DeleteBtn"));
    	deleteBtn.click();
    }
    
    @DataProvider(name = "update")
	public Object[][] dataProvider() throws Exception {
		ReadFile.setExcelFile(Links.PATH_TO_EXCEL, "Sheet3");
		Object[][] testData = ReadFile.getTestData("invalid");
		return testData;
	}
}

