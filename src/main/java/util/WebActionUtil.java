/**
 * 
 */
package util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author jokin
 *1、把所有的web操作方法等集成封装到这来，selenium原生web操作和开源的特殊操作方式
 *（目前用来是给actionFactory来调用具体执行具体的测试操作，也可在单个独立testcase里面调用）
 *2、selenium的三种等待方式待封装进来
 *
 *3、切换到最新窗口
 *4、切换到新的同一个页面新的frame
 *
 */
public class WebActionUtil {
	
	
	
	/**
	 * @param driver 
	 * @param locationType  表示的是定位的方式    id,name,className,tagName,linkText,Xpath,cssSelector             
	 * @param locationValue 
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
                //driver.close();//每次切换窗口都关闭之前的窗口，确保之后打开新窗口都能是保持只有两个窗口，使这个方法可以重复调用
                driver= driver.switchTo().window(temhandle);   
             
        }
		return driver;
	}
	
	/**
	 * 当定位frame标签里面的元素获取不到时 切换到同一个页面的frame里面
	 * @param driver
	 * @param nameOrId    使用该frame标签的di或者是name属性作为参数
	 * @return
	 */
	public static WebDriver swhitchFrame(WebDriver driver ,String nameOrId){
		driver.switchTo().frame("nameOrId");
		return driver;
	}
	/**
	 * 当定位frame标签里面的元素获取不到时 切换到同一个页面的frame里面
	 * @param driver
	 * @param frameElement   通过元素的8中定位方式的任意一种定位获取到元素frame标签后再转换过去
	 * @return
	 */
	public static WebDriver swhitchFrame(WebDriver driver ,WebElement  frameElement){
		driver.switchTo().frame(frameElement);
		return driver;
	}
	
	/**
	 * 返回到上一个frame
	 * @param driver
	 * @return
	 */
	public static WebDriver swhitchDefaultFrame(WebDriver driver){
		driver.switchTo().defaultContent();
		return driver;
	}
	
	/**
	 * input类型的上传文件操作功能
	 * @param driver
	 * @param FilePath
	 * @param uploadElementName
	 */
	public static  void fileUpload(WebDriver driver ,String FilePath ,String uploadElementName){
		
		//File file = new File("C:\\Users\\happy\\Desktop\\FileUpload.rar");
		//File file = new File(FilePath);
        // 用java来实现文件读取功 \
        //driver.get(file.getAbsolutePath());
        // 通过name属性后期到获取文件上传文半框位置，将文件的地址文本写入到该框
        driver.findElement(By.name(uploadElementName)).sendKeys(FilePath);
	}
	/**
	 * 通过元素name属性判断界面元素是否存在
	 * @param driver
	 * @param ElementName
	 * @return
	 */
	public static boolean ElementExistByName(WebDriver driver , String ElementName){

		try{
		   
		    return true;
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
        }
	}
	
	/**
	 * 通过元素name属性判断界面元素是否存在
	 * @param driver
	 * @param Element
	 * @return
	 */
	public static boolean ElementExist(WebDriver driver , String locationStyle,String Element){

		try{
			//
			switch(locationStyle){//switch 在jar1.7版本开始支持参数是非整型，之前版本只能是整型
			case "id" :driver.findElement(By.id(Element));
			break;
			case "name":driver.findElement(By.name(Element));
			break;
			case "linkText":driver.findElement(By.name(Element));
			break;
			
			default: System.out.println("判断元素是否存在的定位方式在封装的方法中没有");
			}
		   
		    return true;
		}catch(org.openqa.selenium.NoSuchElementException ex){
			//try里面抛出元素查找失败的时候返回false
			return false;
        }
	}

}
