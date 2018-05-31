package testcase;

import org.testng.annotations.Test;

import comm.Scene;
import fileUtil.ReadAndWriteExcelByJXL;
import page.ChromeInit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class BaseCase {
    public String excelName;//不能定义成static变量，因为static只会加载一次，如果不同线程方法调用它赋值不同，会取值出错
	String sourceFile;
	
  /**
   * 
   * @param method
   * @return
   */
  @DataProvider(name="testData" , parallel = true)
	public Object[][] data(Method method){//改方法一定要是static静态方法否则获取 数据接收方获取不到改方法提供的数据报错
		Object[][] obj =null;
		File dataExcel;
		//File dataExcel = new File("d:\\data.xls");
		// 通过查找当前路径返回一个规范化路径，这样可以把工程放到不同地方执行了
		//File dataExcel =new File(".\\src\\test\\resources\\data.xls"); 
		Scene myScene = method.getDeclaringClass().getAnnotation(Scene.class);
		String excelName = myScene.name();
		try {
			dataExcel = new File(getPath(excelName));
			obj=ReadAndWriteExcelByJXL.getDataBySheetName(dataExcel, method.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;	
	}
	
	
  /**
   * 获得excel文件的路径
   * @return
   * @throws IOException
   */
  public String getPath(String excelName) throws IOException {
      File directory = new File(".");
      sourceFile = directory.getCanonicalPath() + "/src/test/resources/"
              + excelName+".xls";
      return sourceFile;
  }
  
  
  /* 
   * 判断一个页面元素是否显示在当前页面 
   */    
  public  boolean verifyElementIsPresent(WebElement element){  
            
  	if (element.isDisplayed()) {  
          System.out.println("This Element " + element.toString().trim()+" is present.");
          return true;
      }
		return false;
      }  
    
  
  
  

}
