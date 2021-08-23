package com.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oracle.net.Sdp;

import java.text.*;


public class DateUtil {
	
	public static String dateToString(Date date) {
		if(date == null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}

	public static Date stringToDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (strDate == null || strDate == "")
			return null;
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) 
			{
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return sdf2.parse(strDate);
				} catch (ParseException e1) {
					return null;
				}
			}
		}
				
}

