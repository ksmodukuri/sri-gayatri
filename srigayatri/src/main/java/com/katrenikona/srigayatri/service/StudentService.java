package com.katrenikona.srigayatri.service;

import com.katrenikona.srigayatri.object.Student;
import com.katrenikona.srigayatri.object.StudentData;

public interface StudentService {
	
	void createNewStudent(Student student);

	StudentData getStudents(Integer pageNumber, Integer pageSize, String sortBy, String asc);

	StudentData getSearchStudents(String searchByAdmnNo,String searchByName, String searchByClass, Integer pageNumber, Integer pageSize, String sortBy, String asc);

	Student getStudentDetails(long studentId);

	void updateStudentDetails(Student student);

	String promoteStudents(String fromClass, String toClass);

}
