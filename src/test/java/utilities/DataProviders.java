package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="valueandget")
	public String[][] data() throws IOException {
		
		String path=".//testData/logintestDDT.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowCount = xl.getRowCount("Sheet1");
		int cellCount = xl.getCellCount("Sheet1", 1);
		
		String data[][]= new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				data[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		
		return data;
	}
	
	
	@DataProvider(name="valueanddelete")
	public String[] name() throws IOException {
		
		String path=".//testData/logintestDDT.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowCount = xl.getRowCount("Sheet1");
		
		String data[]=new String[rowCount];
				
				for(int i=1; i<=rowCount; i++) {
					data[i-1] = xl.getCellData("Sheet1", i, 1);
				}
				
			return data;
		
	}

}
