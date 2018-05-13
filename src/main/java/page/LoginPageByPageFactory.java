/**
 * 
 */
package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author jokin
 *封装login页面的所有节目元素的获取 和业务动作
 */
public class LoginPageByPageFactory {
	
	@FindBy(id="username")
	WebElement useNameInput;//使用此注释，调用PageFactory类里的静态方法initElements去初始化界面元素
	
	@FindBy(id="password")
	WebElement passwordInput;
	
	@FindBy(id="js-login")
	WebElement loginButton;
	
	WebDriver webDriver;

/*	*//**
	 * 构造方法，初始化获取该页面的所有节目元素
	 *//*
	public LoginPageByPageFactory(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		this.webDriver= webDriver;
		
	}
	*/
	
	public void LoginSite(String useName,String password){
		
		useNameInput.sendKeys(useName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}



/*	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

*/

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
