package com.icss.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataCount {
	
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private Calendar c = Calendar.getInstance();
//	当前年
//	public String 
	
	//前一年
	public String nextYear() {
		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date y = c.getTime();
		String year = format.format(y);
		return year;

	}
	
	
	
}
