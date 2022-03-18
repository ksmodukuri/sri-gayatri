package com.katrenikona.srigayatri.controller;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseController {
	
	final String DEFAULT_PAGE_NO = "0";
	final String DEFAULT_PAGE_SIZE = "10";
	final String DEFAULT_SORT_BY = "id";
	final String DEFAULT_ORDER = "false";
 
	protected static long ukgAdmissionNumber = 0;
	
	protected static long lkgAdmissionNumber = 0;
	
	List<String> ukgList = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
	{
	add("UKG");
	add("Ukg");
	add("uKg");
	add("ukG");
	add("UKg");
	add("UkG");
	add("uKG");
	add("ukg");
	}
	};
	List<String> lkgList = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
	add("LKG");
	add("Lkg");
	add("lKg");
	add("lkG");
	add("LKg");
	add("LkG");
	add("lKG");
	add("lkg");
	}
	};
	
}
