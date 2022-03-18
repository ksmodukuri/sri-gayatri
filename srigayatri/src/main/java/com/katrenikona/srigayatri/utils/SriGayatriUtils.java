package com.katrenikona.srigayatri.utils;

import java.util.HashMap;
import java.util.Map;

public class SriGayatriUtils {
  
	private static Map<String,String> mapColumn = new HashMap<String,String>();
	
	static {
		mapColumn.put("regName","REG_NAME");
		mapColumn.put("domain","DOMAIN");
		mapColumn.put("firstName","FIRST_NAME");
		mapColumn.put("lastName","LAST_NAME");
		mapColumn.put("emailId","EMAIL_ID");
		mapColumn.put("websiteName","WEBSITE_NAME");
		mapColumn.put("websiteDomain","WEBSITE_DOMAIN");
		mapColumn.put("websiteUri","WEBSITE_URI");
		mapColumn.put("websiteDescp","WEBSITE_DESCRIPTION");
		mapColumn.put("actionName","ACTION_NAME");
		mapColumn.put("actionDecp","ACTION_DESCRIPTION");
		mapColumn.put("fieldLabel","FIELD_LABEL");
		mapColumn.put("fieldDataType","FIELD_DATA_TYPE");
		
	}
	
	public String getString(String mapping) {
		return mapColumn.get(mapping);
	}
}
 