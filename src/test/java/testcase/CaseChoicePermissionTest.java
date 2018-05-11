package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChoicePermissionPage;
import page.ChromeInit;
import page.LoginPage;

public class CaseChoicePermissionTest {
  @Test
  public void choicePermissionTest() throws InterruptedException {
	  ChromeInit CI = new ChromeInit();
	  WebDriver wd = CI.getWebDriver();
	  LoginPage  login= new LoginPage(wd);
	  login.LoginSite("17500000004", "1234567a");
	  ChoicePermissionPage cp= new ChoicePermissionPage(wd);
	  if(cp.getChoiceCompany().isDisplayed()){//判断 进入公司   元素是否展示(展示)展示的前提是该元素确定已经存在了， 展示则点击该元素
		  cp.getChoiceCompany().click();
	  }
	  Thread.sleep(10000);
	  cp.getWebDriver().close();
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
