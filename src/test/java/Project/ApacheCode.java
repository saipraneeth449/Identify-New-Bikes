package Project;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApacheCode {
	
	
	public void writeResult() throws IOException {
	 

	WebDriver driver=FindBikes.driver;

	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Bikes");
	Row header = sheet.createRow(0);
	header.createCell(0).setCellValue("Bike Name");
	header.createCell(1).setCellValue("Price");
	header.createCell(2).setCellValue("Expected Date");
	Bikes b = new Bikes(driver);
	int rowNum=1;
	


	for(WebElement a:b.bike()) {
		XSSFRow row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue(a.getText()); // Replace with browser variable if needed
		rowNum++;
	}
	int rown=1;
	for(WebElement a:b.price()) {

		XSSFRow row=sheet.getRow(rown);
		row.createCell(1).setCellValue(a.getText()); // Replace with browser variable if needed
		rown++;
	}
	int num=1;
	for(WebElement a:b.date()) {

		XSSFRow row=sheet.getRow(num);
		row.createCell(2).setCellValue(a.getText()); // Replace with browser variable if needed
		num++;
	}
	
	FileOutputStream fileOut = new FileOutputStream("C:\\Users\\2419228\\OneDrive - Cognizant\\Desktop\\Book1.xlsx");
		workbook.write(fileOut);
//		sheet.close();
		workbook.close();
		
		
		

}
	public void writeCars() throws IOException {
		WebDriver driver=FindBikes.driver;
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook1.createSheet("Cars");
		Row header1 = sheet1.createRow(0);
		header1.createCell(0).setCellValue("Car Company Name");
		getBrands gb = new getBrands(driver);
		
		int rowNum=1;
		
		for(WebElement a:gb.getbrands()) {
			XSSFRow row = sheet1.createRow(rowNum);
			row.createCell(0).setCellValue(a.getText()); // Replace with browser variable if needed
			rowNum++;
		}
		
		FileOutputStream fileOut1 = new FileOutputStream("C:\\Users\\2419228\\OneDrive - Cognizant\\Desktop\\Book2.xlsx");
		workbook1.write(fileOut1);
		workbook1.close();
		
		
		
		
		
	}
}

