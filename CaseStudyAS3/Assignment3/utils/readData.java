package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParseException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import wrapper.WrapperConstants;

public class readData extends WrapperConstants {
	public File file = null;
	public FileInputStream fileInput = null;
	public Properties prop = null;

	public Properties readProperties() throws IOException {
		file = new File(PropertiesData_File_Path);
		Properties prop = null;
		try {
			fileInput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInput);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fileInput.close();
		}
		return prop;
	}

	public Sheet readExcel() {

		Sheet sheet = null;
		try {
			file = new File(ExcelData_File_Path);
			fileInput = new FileInputStream(file);
			Workbook workbook = null;
			String fileExtensionName = ExcelData_File_Path.substring(ExcelData_File_Path.indexOf(".x"));
			if (fileExtensionName.equals(".xlsx")) {
				workbook = new XSSFWorkbook(fileInput);
			} else if (fileExtensionName.equals(".xls")) {
				workbook = new HSSFWorkbook(fileInput);
			}
			sheet = workbook.getSheet(ExcelData_Sheet_Name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sheet;
	}

	@SuppressWarnings("deprecation")
	public String excelData(int scenario, String header) {
		Sheet sheet = readExcel();
		Row row;
		int rowCount = sheet.getPhysicalNumberOfRows();
		int headerRowNumber = sheet.getLastRowNum() + 1 - rowCount;
		row = sheet.getRow(headerRowNumber);
		Map<String, Integer> values = new HashMap<>();

		int cellCount = row.getPhysicalNumberOfCells();
		int firstCellNumber = row.getLastCellNum() - cellCount;
		Cell cell = null;

		for (int i = firstCellNumber; i < cellCount; i++) {
			if (row.getCell(i).getStringCellValue() != null) {
				values.put(row.getCell(i).getStringCellValue().toLowerCase(), i);
			}
		}

		row = sheet.getRow(headerRowNumber + scenario);
		cell = row.getCell(values.get(header.toLowerCase()));
		cell.setCellType(CellType.STRING);
		return cell.getStringCellValue();

	}

	public tripData readJSON() {
		File file = new File(JSONData_File_Path);
		ObjectMapper mapper = new ObjectMapper();
			tripData details = null;
			try {
				details = mapper.readValue(file, tripData.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return details;
		}
	}

