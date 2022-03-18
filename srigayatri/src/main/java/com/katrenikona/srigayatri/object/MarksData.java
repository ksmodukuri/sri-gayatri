package com.katrenikona.srigayatri.object;

import java.util.ArrayList;
import java.util.List;

public class MarksData extends Response {
	
	private List<Marks> data = new ArrayList<Marks>();

	public List<Marks> getData() {
		return data;
	}

	public void setData(List<Marks> marks) {
		this.data = marks;
	}
	
	public void addMarks(Marks marks){
		this.getData().add(marks);
	}


}
