/**
 * 
 */
package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author jokin
 * 封装读取excel等测试用例数据操作数据后，应该做操作
 *
 */
public class ActionFactory {
	
	public static void executeAction( WebDriver driver ,String action,String locationStyle ,String locationValue,String actionvalue){
		
		
		if(action!=null &&action.equals("input")){
			WebElement editText =WebActionUtil.findViewTool(driver, locationStyle, locationValue);
			editText.sendKeys(actionvalue);
		}else if(action!=null &&action.equals("click")){
			WebElement button =WebActionUtil.findViewTool(driver, locationStyle, locationValue);
			button.click();
		}else if(action!=null &&action.equals("clearText")){
			WebElement editText =WebActionUtil.findViewTool(driver, locationStyle, locationValue);
			WebActionUtil.clearEditText(driver, editText);
		}else{
			//如果上述都不满足那么执行
			System.out.println(action + "这个测试用例的操作功能在框架里的操作没封装");
		}
	}

}
