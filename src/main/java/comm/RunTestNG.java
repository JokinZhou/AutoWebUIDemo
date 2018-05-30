/**
 * 
 */
package comm;

/**
 * @author lenovo
 *
 */
import org.testng.TestNG;  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * 使用main程序去实现运行相关testng.xml文件（在命令行编译这个类， 然后执行即可），最终实现用例重跑
 */  
public class RunTestNG {  
  
    public static void main(String[] args) throws InterruptedException {  
  
          TestNG testNG = new TestNG();  
          List<String> suites = new ArrayList<String>();  
          suites.add(".\\testng.xml");  
          //suites.add(".\\test-output\\testng-failed.xml");  
          testNG.setTestSuites(suites);  
          testNG.run();  
  
          // 等待执行结束，然后去执行失败用例  
          TestNG testNG1 = new TestNG();  
          List<String> suites1 = new ArrayList<String>();  
          Thread.sleep(50000);  
          suites1.add(".\\test-output\\testng-failed.xml");
          testNG1.setTestSuites(suites1);  
          testNG1.run();
  
  
        }  
} 