package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChoicePermissionPage;
import page.LoginPage;

public class CaseChoicePermissionTest {
  @Test
  public void f() throws InterruptedException {
	  
	  LoginPage lp =new LoginPage();
	  lp.getUseNameInput().sendKeys("17500000004");
	  lp.getPasswordInput().sendKeys("1234567a");
	  lp.getLoginButton().click();
	  ChoicePermissionPage cp= new ChoicePermissionPage();
	  if(cp.getChoiceCompany().isDisplayed()){//判断 进入公司   元素是否展示(展示)展示的前提是该元素确定已经存在了， 展示则点击该元素
		  cp.getChoiceCompany().click();
	  }
	  
	  Thread.sleep(6000);
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
