package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import page.BasePage;
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
	  LoginPage lp =new LoginPage();
	   WebDriver webDriver=lp.getWebDriver();
	  lp.getUseNameInput().sendKeys("17500000006");
	  lp.getPasswordInput().sendKeys("1234567a");
	  lp.getLoginButton().click();
	  webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      AssertJUnit.assertEquals(webDriver.findElement(By.linkText("退出")).getText(), "退出");
      
	  lp.getWebDriver().close();
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
