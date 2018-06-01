/**
 * 
 */
package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import comm.CONST;
import comm.Scene;
import page.ChromeInit;
import page.LoginPageByPageFactory;

/**
 * @author lenovo
 *通过java元注解， 运行时注解Scene类的name属性
 */
@Scene(name="dataTwo")
public class LoginByDataProviderFather extends BaseCase {

	  @BeforeClass
	  public void beforeClass() {
		  
	  }

	  @AfterClass
	  public void afterClass() {
		  
	  }
	  /**
	   * 
	   * @param useNname
	   * @param password
	   * @param exp  此处填写预期结果 即预期结果页的特定元素是否显示/或者是预期结果的元素值 是否等于实际值
	   */
	 @Test(description = "登录", dataProvider = CONST.PROVIDER_DATA)
	 public void loginTest(String useNname,String password,String exp) {
		  ChromeInit CI;
		  WebDriver wd;
		  CI = new ChromeInit();
		  wd =CI.getWebDriver();
		  wd.manage().window().maximize();
		  wd.get("http://longguojz.uat1.rs.com/");
		  
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //调用PageFactory类里的静态方法initElements去初始化界面元素并，获取到页面的实力对象
		  LoginPageByPageFactory lp =PageFactory.initElements(wd, LoginPageByPageFactory.class);
		   lp.LoginSite(useNname, password);
		  try {
			  Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*		  //调用testng中AssertJUnit类中的判断方法进行判断验证
	      AssertJUnit.assertEquals(wd.findElement(By.linkText("退出")).getText(), "退出");*/
		  WebElement element = wd.findElement(By.cssSelector(exp));
		  Assert.assertTrue(verifyElementIsPresent(element), "css选择器定位"+exp+"测试执行失败");
	      wd.close();
	      
		  
	  }
	 
	 
	 
	 
}
