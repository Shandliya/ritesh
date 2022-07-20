package org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

/**
 * This class contain reusable method for Csv file and property file
 * @author rites
 *
 */
public final class FileUtility implements IConstants{
	private static final FileInputStream Null = null;
	private Properties properties;
	private FileInputStream fis;
/**
 * 
 * @param
 */

public void intializePropertyFile(String filePath) {
	FileInputStream fis;
	try {
		fis = new FileInputStream(filePath);
		 properties = new Properties();
		 properties.load(fis);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	  catch (IOException e) {
		
		e.printStackTrace();
	} 
}

/**
 * This method is used to data from property file
 * @param key
 * @return
 */
public String getDataFromPropertyFile(String key)
{ 
	FileInputStream fis = Null;
	try {
		fis=new FileInputStream(IConstants.PROPERTYFILEPATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties properties=new Properties();
	try {
		properties.load(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return properties.getProperty(key);
}


/**
 * This method is used to fetch the dtata from csv file
 * @param csvFilePath
 * @param rowNumber
 * @param cellNumber
 * @return
 */

public String getDatafromCSV(String csvfilePath,int rowNumber,int cellNumber)
{
	CSVReader reader = null;
	String data = null;
	try {
		reader = new CSVReader(new FileReader(csvfilePath));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
      
	try {
		data = reader.readAll().get(rowNumber)[cellNumber];
	} catch (IOException e) {
		e.printStackTrace();
	} catch (CsvException e) {
		e.printStackTrace();
	}
	return data;




}
}



	
	
	
