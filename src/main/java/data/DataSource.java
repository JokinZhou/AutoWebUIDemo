/**
 * 
 */
package data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import comm.CONST;
import fileUtil.ExcelData;

/**
 * @author lenovo
 *
 */
public class DataSource {

	private String url;
	private static List<String> testUrlList ; 
	
	/**
	 * 
	 */
	public DataSource() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 为家装测试用例提供参数
	 * @param	method:被提供参数的方法名
	 * @author zhouyiqing
	 */
	@DataProvider(name="providerData",  parallel = true)
	public Object[][] providerTestData(Method method) {
		
/*		//获取@Api的名称,名称必须与写入参数的excel名称一致
		Api myApi = method.getDeclaringClass().getAnnotation(Api.class);
		Assert.assertNotNull(myApi, method.getName().toString() + "没有实现api接口");
		//获得excel名称
		String excelFileName = myApi.name() + ".xlsx";*/
		
		String excelFileName=null;
		Object[][] result = null;
		
//		System.out.println("正在测试: " + myApi.name().toString() + "-" + method.getName().toString());
		/*
		 * 从excel中获取所有的场景
		 * excel的sheet名称与method一致
		 */
		result = getParamsFromExcel(excelFileName, method.getName());
		return result;
	}
	
	/*
	 * 从excel中获取参数
	 * @param	fileName:excel文件名称
	 * 			sheetName:指定的sheet名
	 * 
	 * @author zhouyiqing
	 */
	public Object[][]  getParamsFromExcel(String fileName, String sheetName){		
		//读取excel
		Object[][] result = null;
		ExcelData excelData = new ExcelData(fileName, sheetName);
		List<Map<String, String>> list = null;
		try {
			list = excelData.readExcelWithTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(list, fileName + "中的" + sheetName + "未发现可以使用的数据\n");
		//增加对url的统计
		Assert.assertTrue(list.get(0).containsKey(CONST.URL), sheetName + "中没有url参数配置");
		
		countTests(list.get(0).get("url").toString());	
				
		int length = list.size();
		result = new Object[length][1];
		for(int i = 0; i < list.size(); i++){
			result[i][0] = list.get(i);
		}
		return result;
	}
	
	
	protected void countTests(String methodUrl){
		synchronized(this){
			if(testUrlList == null){
				testUrlList = new ArrayList<String>();
			}
			
			//判断url是否已经存在
			String fullUrl = this.url + methodUrl;
			if(!testUrlList.contains(fullUrl)){
				testUrlList.add(fullUrl);
//				System.out.println(">>>新增: " + fullUrl);
			}
		}
	}

}
