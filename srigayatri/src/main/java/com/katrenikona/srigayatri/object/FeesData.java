package com.katrenikona.srigayatri.object;

import java.util.ArrayList;
import java.util.List;

public class FeesData {

	private List<Fees> data = new ArrayList<Fees>();

	public List<Fees> getData() {
		return data;
	}

	public void setData(List<Fees> fees) {
		this.data = fees;
	}
	
	public void addFees(Fees fees){
		this.getData().add(fees);
	}
	
}
