package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChromeInit;
import page.LoginPageByPageFactory;

/**
 * 调用PageFactory类里的静态方法initElements去初始化界面元素
 * @author lenovo
 *
 */
public class CaseLoginTest {
	
  protected ChromeInit CI;
  protected WebDriver wd;
  
  @BeforeClass
  public void beforeClass() {
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
       
  }

  @AfterClass
  public void afterClass() {
	  wd.close();
  }
  
  
  @Test
  public void loginTest() {
	  //调用PageFactory类里的静态方法initElements去初始化界面元素并，获取到页面的实力对象
	  LoginPageByPageFactory lp =PageFactory.initElements(wd, LoginPageByPageFactory.class);
	   lp.LoginSite("17500000004", "1234567a");
	  try {
		  Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //调用testng中AssertJUnit类中的判断方法进行判断验证
      AssertJUnit.assertEquals(wd.findElement(By.linkText("退出")).getText(), "退出");
      
	  
  }
  @Test
  public void signOutTest(){
	  
  }
  
}
