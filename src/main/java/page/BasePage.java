/**
 * 
 */
package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    protected BasePage (WebDriver driver){  
        BasePage.driver = driver;  
    }  
      
    /* 
     * 在文本框内输入字符 
     */  
    protected void type(WebElement element , String text){  
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
    protected void click(WebElement element){  
              
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
    protected void clean(WebElement element){  
              
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
    protected void verifyElementIsPresent(WebElement element){  
              
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
    protected String getCurrentPageTitle(){  
          
        pageTitle=driver.getTitle();    
        return pageTitle;  
       }  
      
    /* 
     * 获取页面的url 
     */  
    protected String getCurrentPageUrl(){  
          
        pageUrl=driver.getCurrentUrl();  
        return pageUrl;  
       }   
     
             
}  
