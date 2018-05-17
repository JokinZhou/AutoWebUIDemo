package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comm.Log4jUtil;
import page.ChoicePermissionPage;
import page.ChromeInit;
import page.LoginPage;

public class CaseChoicePermissionTest {
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
  public void choicePermissionTest() throws InterruptedException {
	  LoginPage  login= new LoginPage(wd);
	  login.LoginSite("17500000004", "1234567a");
	  ChoicePermissionPage cp= new ChoicePermissionPage(wd);
	  if(cp.getChoiceCompany().isDisplayed()){//判断 进入公司   元素是否展示(展示)展示的前提是该元素确定已经存在了， 展示则点击该元素
		  cp.getChoiceCompany().click();
	  }
	  Thread.sleep(10000);
	  System.out.println(cp.getCurrentPageTitle());
	  Log4jUtil log =new Log4jUtil(cp.getCurrentPageUrl());
	  log.logger.info("执行成功了");
  }

}
