package com.dpmall.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author river
 * @since 2017-04-23
 */
public class DateUtils {
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final Date parse(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}

	public static final String format(Date date, String parttern) {
		SimpleDateFormat sdf = new SimpleDateFormat(parttern);
		return sdf.format(date);
	}
}
