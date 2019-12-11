package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import wrapper.WrapperConstants;


public class readData extends WrapperConstants{
	public  File file = null;
	public  FileInputStream fileInput = null;
	public  Properties prop = null;

	public  Properties readProperties() throws IOException {
		file = new File(PropertiesData_File_Path);
		Properties prop = null;
	      try {
	    	  fileInput = new FileInputStream(file);
	         prop = new Properties();
	         prop.load(fileInput);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	    	  fileInput.close();
	      }
	      return prop;
	}
}