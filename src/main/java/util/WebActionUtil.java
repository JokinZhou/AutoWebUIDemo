/**
 * 
 */
package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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
	 * @param pathType  ��ʾ���Ƕ�λ�ķ�ʽ id��name,Xpath
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
					return arg0.findElement(By.id(locationValue));//ֱ�Ӱ�����ҵ���Ԫ����Ϊ����ֵ,return�����������������ֵ
				}
				
			});*/
			element=driver.findElement(By.id("locationValue"));
		}else if(locationStyle.equals("name")){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// ��ʽ�ȴ���ȫ�ֵȴ�30s����Ԫ���Ƿ��Ѿ�����
			element=driver.findElement(By.name("locationValue"));
		}else if(locationStyle.equals("Xpath")){
			//��ʾ�ȴ�
/*			new AndroidDriverWait(driver,AndroidDriverWait.DEFAULT_SLEEP_TIMEOUT)
			.until(new ExpectedCondition<WebElement>() {//until�ĵ���Ӣ����˼Ϊ   ֱ����������Ϊֹ
				public WebElement apply(AndroidDriver d) {
                    return d.findElement(By.xpath(locationValue));
                }
            });*/
			element=driver.findElement(By.xpath("locationValue"));
		}else if(locationStyle.equals("")){//����λ��ʽΪ��ʱ
			System.out.println("û��д�붨λ��ʽ");
		}
		return element;
	}
	
	/**
	 * �����������Ĭ��text���ҵ���ѡ��ʱ��������յ���յĴ���
	 * ���Ƶ��������element.clear()��û��Ч����; ��Ĭ�ϵ���ʾ�ı�(�ּ��Ƚ�ǳ)
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


}
