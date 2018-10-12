@Grab('org.apache.poi:poi:3.14')

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

public XSSFWorkbook workbook = null;
	def public XSSFSheet sheet = null;
	def XSSFRow row   =null;
	def XSSFCell cell = null
	def static String filename = null
	def public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut =null;

   
	def public Xlsx_Builder(String path) {
		  this.path=path;
	
		  try {
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
		  } catch (Exception e) {
				e.printStackTrace();
		  }
		 
	}
   
	
	def int getRowCount(String sheetName){
		  int index = workbook.getSheetIndex(sheetName);
		  if(index==-1)
				return 0;
		  else{
		  sheet = workbook.getSheetAt(index);
		  int number=sheet.getLastRowNum()+1;
		  return number;
	
		  }
		 
	}
  
  return this;
