package com.aim.filmStore.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class StringUtil {
	public static String getUrl(HttpServletRequest request) {
		String servletPath = request.getServletPath();// 获取servletPath
		String queryString = request.getQueryString();// 获取问号后的参数
		// 判断参数是否包含&pc=,包含便截取掉
		if (queryString != null) {
			if (queryString.contains("&pc=")) {
				int index = queryString.indexOf("&pc=");
				queryString = queryString.substring(0, index);
			}
		}
		return servletPath + "?" + queryString;
	}
}
