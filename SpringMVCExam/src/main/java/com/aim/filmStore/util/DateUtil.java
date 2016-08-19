package com.aim.filmStore.util;

import java.util.Date;

public class DateUtil {

	/**
	 * 获取系统毫秒时间
	 * 
	 * @return
	 */
	public static long getDate() {
		Date date = new Date();
		long datetime = date.getTime();
		return datetime;
	}
}
