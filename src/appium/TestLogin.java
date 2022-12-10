package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
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
    
    @Test(dataProvider="loginData")
	public void f(String email, String password, String result) throws Exception {
    	
    	logIn(email, password, result);
    	Thread.sleep(3000);
    	
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();//thoát
	}
	
	public void logIn(String email, String password, String result) throws InterruptedException {
		WebElement edtMail = driver.findElement(By.id("com.nhuy.todolist:id/loginEmail"));
		edtMail.clear();
		edtMail.sendKeys(email);
		
		WebElement edtPassword = driver.findElement(By.id("com.nhuy.todolist:id/loginPassword"));
		edtPassword.clear();
		edtPassword.sendKeys(password);
		
		WebElement btnLogin = driver.findElement(By.id("com.nhuy.todolist:id/loginButton"));
		btnLogin.click();
		
		Thread.sleep(2000);
		
		WebElement btnOK = driver.findElement(By.id("com.nhuy.todolist:id/btn_ok"));
		btnOK.click();
//		
//		Thread.sleep(2000);
//		
//		//
//		WebElement message = driver.findElement(By.id("com.nhuy.todolist:id/tv_message"));
//		Assert.assertEquals(message.getText(), result);
//		System.out.println("message" + message.getText());
		
		
				
	}
	
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() throws Exception {
		ReadFile.setExcelFile(Links.PATH_TO_EXCEL, "Sheet1");// Đường dẫn đến file excel và các sheet
		Object[][] testData = ReadFile.getTestData("invalid");// khoanh vùng dữ liệu cần đọc
		return testData;
	}
	
	
//	NoReset: true : Không dừng ứng dụng, không xóa dữ liệu ứng dụng và không gỡ cài đặt apk.
// ignoreHiddenApiPolicyError: Bỏ qua Ngoại lệ bảo mật: Cảnh báo từ chối quyền và cho phép tiếp tục quá trình.
// deviceName: Loại thiết bị di động hoặc trình mô phỏng để sử dụng.
// flatformName: Nền tảng hệ điều hành nào sử dụng.
// package: package của ứng dụng để chạy	
	
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);: 
//	nó chỉ phát huy tác dụng khi một phần tử đang được tìm kiếm không có sẵn 
//	... sau đó, quá trình chờ ngầm được kích hoạt và phần tử đó được thăm dò đến 10 giây. 
//	Nếu phần tử đã ở đó, thì không có thời gian chờ đợi. 
	
//	Thread.sleep () tạm dừng thực thi bất kể điều gì.
	
// DataProviders là một phương tiện để chuyển dữ liệu đến các tập lệnh kiểm tra trong TestNG.
// có thể dễ dàng đưa nhiều giá trị vào cùng một trường hợp thử nghiệm	
	
// Phương thức DataProvider trả về danh sách các đối tượng	
}
