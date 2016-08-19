package com.aim.filmStore.util;

import java.util.Collection;

/**
 * 校验工具类
 * @author aim
 *
 */
public class ValidateUtil {
   
	/**
	 * 判断字符串是否为空
	 * @param src
	 * @return
	 */
	public static boolean isValid(String src){
    	return !(src==null||"".equals(src.trim()));
    }
	
	/**
	 * 判断集合是否为空
	 * @param col
	 * @return
	 */
	public static boolean isValid(Collection col){
		if(col==null||col.isEmpty()){
			return false;
		}
		return true;
	}
}
