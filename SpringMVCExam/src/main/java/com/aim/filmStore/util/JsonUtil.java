package com.aim.filmStore.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil{
       
	 /**
	  * 将服务器端的javabean转换成json字符串
	  * @param objects
	  * @return
	  */
	  public static String getJsonArray(Object... objects){
		    
		     String jsonArray=JSONArray.fromObject(objects).toString();
		     return jsonArray;
	  }
	  
	  /**
	   *将json转换为Javabean
	   * @param json
	   * @param obj
	   * @return
	   */
	  public static Object getObjectFormJson(String json,Object obj){
		  Object object=JSONObject.toBean(JSONObject.fromObject(json),obj.getClass());
		  return object;
	  }
	 
	  public static String sizeJsonCreate(int len,String sizeJson) {
			sizeJson = sizeJson + "{" + "size:" + len + "}" + ",";
			return sizeJson;
		}

		public static String getsizeJson(String sizeJson) {
			int index = sizeJson.lastIndexOf(",");
			return "[" + sizeJson.substring(0, index) + "]";
		}
	  
}
