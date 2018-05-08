/**
 * 
 */
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author lenovo
 *封装login页面的所有节目元素的获取
 */
public class LoginPage extends BasePage {
	
	WebElement useNameInput;
	WebElement passwordInput;
	WebElement loginButton;
	WebDriver webDriver;

	/**
	 * 构造方法，初始化获取该页面的所有节目元素
	 */
	public LoginPage() {
		// TODO Auto-generated constructor stub
		webDriver= super.webDriver;
		webDriver.findElement(By.id("username"));
		useNameInput = webDriver.findElement(By.id("username"));
		passwordInput = webDriver.findElement(By.id("password"));
		loginButton = webDriver.findElement(By.id("js-login"));
	}

	
	
	public WebDriver getWebDriver() {
		return webDriver;
	}



	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}



	public WebElement getUseNameInput() {
		return useNameInput;
	}

	public void setUseNameInput(WebElement useNameInput) {
		this.useNameInput = useNameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(WebElement passwordInput) {
		this.passwordInput = passwordInput;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
	

}
