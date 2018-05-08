package testcase;

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
	  
	  lp.getUseNameInput().sendKeys("17500000006");
	  lp.getPasswordInput().sendKeys("1234567a");
	  lp.getLoginButton().click();
	  lp.getWebDriver().close();
  }
  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
  }
   
}
