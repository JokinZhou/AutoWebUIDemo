/**
 * 
 */
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author jokin
 *封装login页面的所有节目元素的获取 和业务动作
 */
public class LoginPage {
	
	WebElement useNameInput;
	WebElement passwordInput;
	WebElement loginButton;
	WebDriver webDriver;

	/**
	 * 构造方法，初始化获取该页面的所有节目元素
	 */
	public LoginPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		this.webDriver= webDriver;
		try{
			useNameInput = webDriver.findElement(By.id("username"));
			passwordInput = webDriver.findElement(By.id("password"));
			loginButton = webDriver.findElement(By.id("js-login"));	
		}catch (NoSuchElementException e){
			// TODO Auto-generated catch block
			System.out.println("登录页面获取元素失败！！！");
			e.printStackTrace();
		}
		
	}
	
	
	public void LoginSite(String useName,String password){
		
		LoginPage lp =new LoginPage(webDriver);
		lp.getUseNameInput().sendKeys(useName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.getPasswordInput().sendKeys(password);
		lp.getLoginButton().click();
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
