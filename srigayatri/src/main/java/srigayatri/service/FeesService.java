package srigayatri.service;

import srigayatri.object.Fees;
import srigayatri.object.StudentData;

public interface FeesService {

	void createNewStudentFees(Fees fees);

	StudentData getStudentsFees(Integer pageNumber, Integer pageSize, String sortBy, String asc);

	StudentData getSearchStudentsFees(String searchByAdmnNo, String searchByName, String searchByClass,
			Integer pageNumber, Integer pageSize, String sortBy, String asc);

	Fees getFeesDetails(long studentId);

	void updateFees(Fees fees);

	Fees getFeesPaymentDetails(String admnNo);
	
}
