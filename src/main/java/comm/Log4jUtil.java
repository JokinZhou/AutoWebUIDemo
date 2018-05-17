/**
 * 
 */
package comm;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author lenovo
 *
 */
public class Log4jUtil {
	
	public Logger logger;
	
	static{
		PropertyConfigurator.configure(".\\Log4j.properties");
	}

	/**
	 * 
	 */
	public Log4jUtil(String category) {
		// TODO Auto-generated constructor stub
		logger=Logger.getLogger(category);
		//PropertyConfigurator.configure(".\\Log4j.properties");可以重复加载多次，并不会重新输出新的文件，不用担心内容被覆盖
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	

}
