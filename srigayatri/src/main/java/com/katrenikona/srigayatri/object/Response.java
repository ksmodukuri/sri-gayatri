package com.katrenikona.srigayatri.object;

import java.util.ArrayList;
import java.util.List;

public abstract class Response {
	
	List<String> examTypeList50 = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("FA1");
		add("FA2");
		add("FA3");
		add("FA4");
		
	}
	};
	List<String> examTypeList100 = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		
		add("SA1");
		add("SA2");
	}
	};
	
	private Pagination pagination;
 
	private List<Error> errors = new ArrayList<Error>();
 
	private List<Filter> filters;
	
	private List<SortField> sortFields;

	public List<SortField> getSortFields() {
		return sortFields;
	}

	public void setSortFields(List<SortField> sortFields) {
		this.sortFields = sortFields;
	}

	public Pagination getPagination() {
		return pagination;
	}
	
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public List<Error> getErrors() {
		return errors;
	}
	
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	public List<Filter> getFilters() {
		return filters;
	}
	
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	public String getGradeFromMarks(double marks,String examType) {
		double percentage = 0;
		if(examTypeList50.contains(examType)) {
			percentage = (marks / 50) * 100;
		}else if(examTypeList100.contains(examType)){
			percentage = (marks / 100) * 100;
		}
		String grade = "";
		if(percentage >= 90 && percentage <= 100) {
			grade += "A+";
		}else if(percentage >= 70 && percentage < 90) {
			grade += "A";
		}else if(percentage >=50  && percentage < 70) {
			grade += "B+";
		}else if(percentage >=40  && percentage < 50) {
			grade += "B";
		}else if(percentage >=0  && percentage < 40) {
			grade += "C";
		}
		return grade;
	}

}
