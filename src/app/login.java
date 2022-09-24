package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class login {
	AppiumDriver<WebElement> driver;
	
	public void logInapp(String email, String password) {
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
}
