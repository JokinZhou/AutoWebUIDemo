/**
 * 
 */
package util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author jokin
 *把所有的web操作方法等集成封装到这来，selenium原生web操作和开源的特殊操作方式
 *（目前用来是给actionFactory来调用具体执行具体的测试操作，也可在单个独立testcase里面调用）
 *
 */
public class WebActionUtil {
	/**
	 * 
	 * @param driver 
	 * @param pathType  表示的是定位的方式    id,name,className,tagName,linkText,Xpath,cssSelector
	 * @param pathValue
	 * @return
	 */
	public static WebElement findViewTool(WebDriver driver,String locationStyle, final String locationValue){
		WebElement element =null;
		if(locationStyle.equals("id")){
			/*//等到找到后在执行
			AndroidDriverWait aw = new AndroidDriverWait(driver, AndroidDriverWait.DEFAULT_SLEEP_TIMEOUT);
			aw.until(new ExpectedCondition<WebElement>(){

				@Override
				public WebElement apply(AndroidDriver arg0) {
					// TODO Auto-generated method stub
					return arg0.findElement(By.id(locationValue));//直接把这个找到的元素作为返回值,return是跳出这个方法返回值
				}
				
			});*/
			element=driver.findElement(By.id(locationValue));
		}else if(locationStyle.equals("name")){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//隐式等待，全局等待30s不管元素是否已经加载
			element=driver.findElement(By.name(locationValue));
		}else if(locationStyle.equals("Xpath")){
			element=driver.findElement(By.xpath(locationValue));
		}else if(locationStyle.equals("tagName")){
			//List<WebElement> allInputs = driver.findElements(By.tagName("locationValue"));
			//待实现因为一个页面中会有多个tagName一样的
		}else if(locationStyle.equals("className")){
			//待实现
		}else if(locationStyle.equals("linkText")){
			element=driver.findElement(By.linkText(locationValue));
		}else if(locationStyle.equals("partialLinkText")){
			//当你不能准确知道超链接上的文本信息或者只想通过一些关键字进行匹配时，可以使用这个方法来通过部分链接文字进行匹配
			element=driver.findElement(By.partialLinkText(locationValue));
		}else if(locationStyle.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locationValue));
		}

		else if(locationStyle.equals("")){//当定位方式为空时
			System.out.println("没有写入定位方式");
		}
		return element;
	}
	
	/**
	 *清除文本框中的文字
	 *
	 * @param driver
	 * @param editText
	 */
	public static void clearEditText(WebDriver driver,WebElement editText){
		editText.click();
/*		driver.pressKeyCode(123);//123������ƶ�����������ұ�
		String content = editText.getText();//����WebElementԪ�ص�getText()������ȡԪ�ص�ֵ
		for(int i =0;i<content.length();i++){
			driver.pressKeyCode(67); //67��delete��
			driver.findElementsByAndroidUIAutomator(content);
		}*/
		
	}
	/**
	 * 切换到最新的窗口页
	 * @param driver
	 * @return 
	 */
	public static WebDriver  swhitchWindow(WebDriver driver){
		
	    // 获取当前页面句柄    
        String handle = driver.getWindowHandle();    
        // 获取所有页面的句柄，并循环判断不是当前的句柄   
        for (String temhandle : driver.getWindowHandles()) {    
            if (!temhandle.equals(handle))    
                //driver.close();  
                driver= driver.switchTo().window(temhandle);   
             
        }
		return driver;
	}


}
