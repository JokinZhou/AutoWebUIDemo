/**
 * 
 */
package testcase;

import java.io.File;

import fileUtil.ReadAndWriteExcelByJXL;

/**
 * @author lenovo
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ReadAndWriteExcelByJXL  r = new ReadAndWriteExcelByJXL();
		File dataExcel = new File("d:\\data.xls");
		System.out.println(ReadAndWriteExcelByJXL.getData(dataExcel).toString());

	}

}
