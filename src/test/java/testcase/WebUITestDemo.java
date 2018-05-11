package testcase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.WebActionUtil;

public class WebUITestDemo {
 // @Test(timeOut=5000)
  @Test(enabled = false)
  public void TestDome() throws IOException {
	  // 通过查找当前路径返回一个规范化路径，这样可以把工程放到不同地方执行了
	    String driverPath = new File("./").getCanonicalPath() + "/src/main/resources/chromedriver.exe";
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      WebDriver webDriver = new ChromeDriver();
	      webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      webDriver.get("https://www.baidu.com/");
	      webDriver.manage().window().maximize();
	      String testWindowHandle = webDriver.getWindowHandle();
	      webDriver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
	      
	      //切换到新窗口
	     // webDriver=WebActionUtil.swhitchWindow(webDriver);
	      webDriver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
	      
	      System.out.println("我执行到这里了,我已经点击过用账号密码登录");
	      webDriver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("1263747826@qq.com");
	      System.out.println("我执行到这里了,输入过用户名了");
	      webDriver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("password");
	      webDriver.findElement(By.id("TANGRAM__PSP_10__verifyCode")).sendKeys("验证码");
	      webDriver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
	      String username = webDriver.findElement(By.id("user-name")).getText();
	      
	      System.out.println("我执行到这里了！！！");
	      if (username.contains("username")) {
	          System.out.print(true);
	      } else {
	          System.out.print(false);
	      }
	      webDriver.close();
  }
}
