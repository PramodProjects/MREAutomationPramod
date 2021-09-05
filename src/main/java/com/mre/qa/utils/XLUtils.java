package com.mre.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style; 
	public static String COLNAME_SF_LINK = "SFLink";
	public static String COLNAME_DOB = "DOB";
	public static String ROWNAME_TCNAME3 = "TestcaseName3";

	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(xlsheet);
		int rowcount=worksheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws Exception 
	{
		
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
		
		
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(xlsheet);
		row=worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,String colName) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(xlsheet);
		row=worksheet.getRow(0);
		int colNum = -1;
		for(int i = 0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
            	colNum = i;
        }
		row=worksheet.getRow(rownum);
		cell=row.getCell(colNum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,String rowName,String colName) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(xlsheet);
		row=worksheet.getRow(0);
		int colNum = -1;
		for(int c = 0; c < row.getLastCellNum(); c++)
        {
            if(row.getCell(c).getStringCellValue().trim().equals(colName.trim()))
            	colNum = c;
        }
		
		
		int rowNum = -1;
		for(int r = 0; r <= worksheet.getLastRowNum(); r++)
        {
			row=worksheet.getRow(r);			
            if(row.getCell(0).getStringCellValue().trim().equals(rowName.trim()))
            	rowNum = r;
        }
		row=worksheet.getRow(rowNum);
		cell=row.getCell(colNum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	
//	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
//	{
//		fis=new FileInputStream(xlfile);
//		workbook=new XSSFWorkbook(fis);
//		worksheet=workbook.getSheet(xlsheet);
//		row=worksheet.getRow(rownum);
//		cell=row.createCell(colnum);
//		cell.setCellValue(data);
//		fos=new FileOutputStream(xlfile);
//		workbook.write(fos);		
//		workbook.close();
//		fis.close();
//		fos.close();		
//		
//	}
	
	
	public static void setCellData(String path, String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fos=new FileOutputStream(path);
		workbook.write(fos);
		}
				
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		
		worksheet=workbook.getSheet(sheetName);
					
		if(worksheet.getRow(rownum)==null)   // If row not exists then create new Row
			worksheet.createRow(rownum);
		row=worksheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		workbook.write(fos);		
		workbook.close();
		fis.close();
		fos.close();
	}
	
	
	
	public static void setCellData(String path, String sheetName,int rowNum, String colName, String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fos=new FileOutputStream(path);
		workbook.write(fos);
		}
				
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		
		worksheet=workbook.getSheet(sheetName);
					
		
		row=worksheet.getRow(0);
		int colNum = -1;
		for(int i = 0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
            	colNum = i;
        }
		
		
		if(worksheet.getRow(rowNum)==null)   // If row not exists then create new Row
			worksheet.createRow(rowNum);
		row=worksheet.getRow(rowNum);
		
		cell=row.createCell(colNum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		workbook.write(fos);		
		workbook.close();
		fis.close();
		fos.close();
	}
	

	public static void setCellData(String path, String sheetName,String rowName, String colName, String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fos=new FileOutputStream(path);
		workbook.write(fos);
		}
				
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		
		worksheet=workbook.getSheet(sheetName);
					
		
		row=worksheet.getRow(0);
		int colNum = -1;
		for(int i = 0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
            	colNum = i;
        }
		
		int rowNum = -1;
		for(int r = 0; r <= worksheet.getLastRowNum(); r++)
        {
			row=worksheet.getRow(r);			
            if(row.getCell(0).getStringCellValue().trim().equals(rowName.trim()))
            	rowNum = r;
        }
		
		if(worksheet.getRow(rowNum)==null)   // If row not exists then create new Row
			worksheet.createRow(rowNum);
		row=worksheet.getRow(rowNum);
		
		cell=row.createCell(colNum);
		cell.setCellValue(data);
		fos=new FileOutputStream(path);
		workbook.write(fos);		
		workbook.close();
		fis.close();
		fos.close();
	}
	
	
	public void fillGreenColor(String xlfile,String sheetName,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(sheetName);
		
		row=worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
	
	public void fillRedColor(String xlfile, String sheetName,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(sheetName);
		row=worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
	
	
	
}
