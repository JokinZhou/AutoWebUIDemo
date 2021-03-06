package testcase;

import org.testng.annotations.Test;

import data.LoginDataProvider;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.WebActionUtil;
/**
 * 使用数据驱动实现登录测试
 * @author lenovo
 *
 */
public class LongguoLoginByDataProviderTest {
  @Test(dataProvider="loginData",dataProviderClass=LoginDataProvider.class)//参数化数据
  public void TestDome(String useNname,String password,String exp,String act) throws IOException {
	  // 通过查找当前路径返回一个规范化路径，这样可以把工程放到不同地方执行了
	    String driverPath = new File("./").getCanonicalPath() + "/src/main/resources/chromedriver.exe";
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      WebDriver webDriver = new ChromeDriver();
	      webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      webDriver.get("http://longguojz.uat1.rs.com/");
	      webDriver.manage().window().maximize();
	      //String testWindowHandle = webDriver.getWindowHandle();//获取当前窗口句柄
	      webDriver.findElement(By.id("username")).sendKeys(useNname);
	      System.out.println("我执行到这里了,输入过用户名了");
	      webDriver.findElement(By.id("password")).sendKeys(password);
	      webDriver.findElement(By.id("js-login")).click();
	      webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      AssertJUnit.assertEquals(webDriver.findElement(By.linkText("退出")).getText(), "退出");
	      System.out.println("我执行到这里了！！！");
	      webDriver.findElement(By.linkText("退出")).click();
	      webDriver.close();
  }
}
