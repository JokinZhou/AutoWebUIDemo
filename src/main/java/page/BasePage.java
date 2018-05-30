/**
 * 
 */
package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author lenovo
 *页面父类，来定义一些公共的方法或者公共的元素
 *后续所有page类都继承它， 这样后续就能直接调用该类中的一些公用操作方法
 */
public class BasePage {  
	  
    public static WebDriver driver;  
    public static String pageTitle;  
    public static String pageUrl;
      
    /* 
     * 构造方法 
     */  
    public BasePage (WebDriver driver){  
        BasePage.driver = driver;  
    }  
      
    /* 
     * 在文本框内输入字符 
     */  
    public  void type(WebElement element , String text){  
        try {  
                if (element.isEnabled()) {  
                    element.clear();   
                    element.sendKeys(text);    
                }  
            } catch (Exception e) {  
            	e.printStackTrace();
                }  
              
        }  
      
    /* 
     * 点击元素，这里指点击鼠标左键 
     */   
    public  void click(WebElement element){  
              
        try {  
                if (element.isEnabled()) {  
                        element.click();  
                        System.out.println("Element: "+element.toString()+" was clicked.");
                    }  
                } catch (Exception e) {  
                	e.printStackTrace();  
                        }  
              
        }  
          
    /* 
     * 在文本输入框执行清除操作 
     */  
    public  void clean(WebElement element){  
              
        try {  
                if (element.isEnabled()) {  
                    element.clear();  
                    System.out.println("Element "+element.toString()+" was cleaned.");
                }  
            } catch (Exception e) {  
            	e.printStackTrace();  
            }  
              
        } 
      
    /* 
     * 判断一个页面元素是否显示在当前页面 
     */    
    public  void verifyElementIsPresent(WebElement element){  
              
        try {  
                if (element.isDisplayed()) {  
                    System.out.println("This Element " + element.toString().trim()+" is present.");        
                }  
            } catch (Exception e) {  
            	e.printStackTrace();  
            }  
        }  
      
    /* 
     * 获取页面的标题 
     */  
    public String getCurrentPageTitle(){  
          
        pageTitle=driver.getTitle();    
        return pageTitle;  
       }  
      
    /* 
     * 获取页面的url 
     */  
    public  String getCurrentPageUrl(){  
          
        pageUrl=driver.getCurrentUrl();  
        return pageUrl;  
       } 
    /**
     * 鼠标右键当前位置
     */
    public void mouseRightClick(){
    	Actions action = new Actions(driver);  
    	action.contextClick().build().perform();// 鼠标右键在当前停留的位置做单击操作   
    }
    
    /**
     * 鼠标右键某个元素
     */
    public void mouseRightClickElement(WebElement element){
    	Actions action = new Actions(driver);  
    	action.contextClick(element).build().perform();// 鼠标右键在当前停留的位置做单击操作   
    }
    
    /**
     * 鼠标拖拽某个元素到目标元素处
     */
    public void mouseDragElement(WebElement sourceElement,WebElement targetElement){
    	Actions action = new Actions(driver);  
    	action.clickAndHold(sourceElement).moveToElement(targetElement).perform();
    	action.release();
    }
         
}  
