/**
 * 
 */
package comm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
/*import org.testng.internal.annotations.IAnnotationTransformer;*/

/**
 * @author lenovo
 *
 */
public class MyRetryListener implements IAnnotationTransformer {  
	  
/*	  //改方法是对Testn的 @Test 注释的监听后执行动作的重写；本身testng的监听后动作以及封装在框架里了
	但是此处是我们自行重写的方法，所有要去testng.xml里配置新增这个监听器*/
    @Override  
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {  
  
        IRetryAnalyzer myRetry = iTestAnnotation.getRetryAnalyzer();  
        if (myRetry == null) {  
            iTestAnnotation.setRetryAnalyzer(MyRetry.class);  
        }
        
        if("testMethodName".equals(method.getName())){
        	iTestAnnotation.setInvocationCount(3);//设置到@Test注释的方法的名字是testMethodName时就跑3次
        }
    }  
} 