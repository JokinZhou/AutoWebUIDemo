package testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import page.ChromeInit;
import page.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class CaseLoginTest {
  @Test
  public void loginTest() {
	  ChromeInit CI = new ChromeInit();
	  WebDriver wd1 = CI.getWebDriver();
	  LoginPage lp =new LoginPage(wd1);
	   WebDriver webDriver=lp.getWebDriver();
	   lp.LoginSite("17500000004", "1234567a");
	  try {
		  Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //调用testng中AssertJUnit类中的判断方法进行判断验证
      AssertJUnit.assertEquals(webDriver.findElement(By.linkText("退出")).getText(), "退出");
      
	  webDriver.close();
  }
  @Test
  public void signOutTest(){
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
  }
   
}
