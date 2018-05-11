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
 *
 */
public class ChoicePermissionPage{
	
	WebElement ChoiceCompany;
	WebElement ChoiceDesiner;
	WebDriver webDriver;

	/**
	 * 
	 */
	public ChoicePermissionPage(WebDriver webDriver){
		// TODO Auto-generated constructor stub
		this.webDriver= webDriver;
		
		try {
			ChoiceCompany = webDriver.findElement(By.linkText("进入公司"));
			//ChoiceCompany.isDisplayed();
			ChoiceDesiner = webDriver.findElement(By.linkText("设计师管理"));
		}catch (NoSuchElementException e){
			// TODO Auto-generated catch block
			System.out.println("公司/设计师权限选择页面获取元素失败！！！");
			e.printStackTrace();
		}
		
	}

	public WebElement getChoiceCompany() {
		return ChoiceCompany;
	}

	public void setChoiceCompany(WebElement choiceCompany) {
		ChoiceCompany = choiceCompany;
	}

	public WebElement getChoiceDesiner() {
		return ChoiceDesiner;
	}

	public void setChoiceDesiner(WebElement choiceDesiner) {
		ChoiceDesiner = choiceDesiner;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	

}
