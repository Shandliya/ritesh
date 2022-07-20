package org.tyss.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains only java related reusable methods
 * @author 
 *
 */
public class JavaUtility {
	/**
	 * This method will return random number within 1000
	 * @return
	 */
	public int getRandomNumber() {
		return new Random().nextInt(1000);
	}
	/**
	 * This method will return current date based on startegy
	 * @param datePattern
	 * @return
	 */
	public String currentDate(String datePattern) {
		Date date=new Date();
		return new SimpleDateFormat(datePattern).format(date);
	}
	/**
	 * This method will print passed statement on console
	 * @param printingStatement
	 */
	public void print(String printingStatement) {
		System.out.println(printingStatement);
	}
	/**
	 * This method will convert String to long
	 * @param value
	 * @return
	 */
	public long convertStringToLong(String value) {
		return Long.parseLong(value);
	}
	/**
	 *  This method will convert String to int
	 * @param value
	 * @return
	 */
	public static  int convertStringToInt(String value) {
		return Integer.parseInt(value);
	}
}
