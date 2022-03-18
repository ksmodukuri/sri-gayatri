package com.katrenikona.srigayatri.service;

import com.katrenikona.srigayatri.object.Marks;
import com.katrenikona.srigayatri.object.MarksData;

public interface MarksService {

	MarksData getStudentsMarks(Integer pageIndex, Integer pageLimit, String sortBy, String asc, String std);

	MarksData getSearchStudentsMarksByAdmissionNumber(String searchByAdmnNo, Integer pageIndex, Integer pageLimit,
			String sortBy, String asc);

	MarksData getSearchStudentsMarksByClass(String fromClass, Integer pageIndex, Integer pageLimit, String sortBy,
			String asc);

	Marks getStudentSubjects(String admnNo);

	void updateMarks(Marks marksEnterObject);

	MarksData getAllStudentsMarks(Integer pageIndex, Integer pageLimit, String sortBy, String asc);

	Marks getMarks(long marksId);

	void updateMarksByMarksId(Marks marksEnterObject);

}
