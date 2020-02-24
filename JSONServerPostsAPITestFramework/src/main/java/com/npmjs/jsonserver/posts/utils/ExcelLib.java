package com.npmjs.jsonserver.posts.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods to extract required data from the .xlsx file.
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class ExcelLib
{
    /**
     * It is used to get the required HTTP request parameters from the given .xlsx file
     * 
     * @param testCaseName Name of the test case
     * @param excelPath Path of the .xlsx file
     * @param sheetName Name of the sheet in the .xlsx file having the required data 
     * @return A map contains all the HTTP request parameters as key, value pairs
     * @throws IOException
     */
    public LinkedHashMap<String, String> getRequestParameters(String testCaseName, String excelPath, String sheetName) throws IOException
    {
        LinkedHashMap<String, String> apiReqData = new LinkedHashMap<String, String>();

        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook   = WorkbookFactory.create(fis);
        Sheet sheet         = workbook.getSheet(sheetName);
        int rows            = sheet.getPhysicalNumberOfRows();
        
        for (int i = 0; i < rows; i++)
        {
            if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(testCaseName))
            {
                for (int j = 2; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++)
                    apiReqData.put(sheet.getRow(1).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());

                break;
            }
        }
            
        return apiReqData;
    }
}
