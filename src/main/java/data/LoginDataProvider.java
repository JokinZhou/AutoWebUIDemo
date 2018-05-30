/**
 * 
 */
package data;

import java.io.File;

import org.testng.annotations.DataProvider;

import fileUtil.ReadAndWriteExcelByJXL;

/**
 * @author join
 *
 */
public class LoginDataProvider {
	
	private static Object[][] obj;
	
	@DataProvider(name="loginData")
	public  static Object[][] data(){
		
		//File dataExcel = new File("d:\\data.xls");
		// 通过查找当前路径返回一个规范化路径，这样可以把工程放到不同地方执行了
		File dataExcel =new File(".\\src\\test\\resources\\data.xls"); 
		obj=ReadAndWriteExcelByJXL.getData(dataExcel);
		return obj;
		
	}
	
}
