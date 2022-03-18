package com.katrenikona.srigayatri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.katrenikona.srigayatri.entity.MarksEntity;
import com.katrenikona.srigayatri.entity.StudentDetailsEntity;
import com.katrenikona.srigayatri.object.Marks;
import com.katrenikona.srigayatri.object.MarksData;
import com.katrenikona.srigayatri.object.Pagination;
import com.katrenikona.srigayatri.repository.MarksRepository;
import com.katrenikona.srigayatri.repository.StudentRepository;
import com.katrenikona.srigayatri.service.MarksService;

@Service
public class MarksServiceImpl extends BaseServiceImpl implements MarksService{
	
	@Autowired
	private MarksRepository marksRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public MarksData getStudentsMarks(Integer pageNumber, Integer pageSize, String sortBy, String asc, String std) {
		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = null;
		
		pagedResult = studentRepository.findStudentByClass(std, paging);
		MarksData marksData = new MarksData();
		Pagination pag = new Pagination();
		marksData.setPagination(pag);
		System.out.println(pagedResult);
		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> studentsEntityList = pagedResult.getContent();
			
			for (StudentDetailsEntity studentEnt : studentsEntityList) {
				for(MarksEntity marksEnt : studentEnt.getMarksEntity()) {
					Marks marks = getMarksObject(marksEnt);
					marksData.addMarks(marks);
				}
			}
		}

//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return marksData;
	}

	@Override
	public MarksData getSearchStudentsMarksByAdmissionNumber(String searchByAdmnNo, Integer pageNumber, Integer pageSize, String sortBy, String asc) {
		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = null;
		
		pagedResult = studentRepository.findStudentBySearch(searchByAdmnNo,paging);
		
		MarksData marksData = new MarksData();
		Pagination pag = new Pagination();
		marksData.setPagination(pag);
		System.out.println(pagedResult);
		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> studentsEntityList = pagedResult.getContent();
			
			for (StudentDetailsEntity studentEnt : studentsEntityList) {
				for(MarksEntity marksEnt : studentEnt.getMarksEntity()) {
					Marks marks = getMarksObject(marksEnt);
					marksData.addMarks(marks);
				}
			}
		}

//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return marksData;
	}

	@Override
	public MarksData getSearchStudentsMarksByClass(String fromClass, Integer pageNumber, Integer pageSize, String sortBy, String asc) {
		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = null;
		
		pagedResult = studentRepository.findStudentByClass(fromClass,paging);
		
		MarksData marksData = new MarksData();
		Pagination pag = new Pagination();
		marksData.setPagination(pag);
		System.out.println(pagedResult);
		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> studentsEntityList = pagedResult.getContent();
			
			for (StudentDetailsEntity studentEnt : studentsEntityList) {
				for(MarksEntity marksEnt : studentEnt.getMarksEntity()) {
					Marks marks = getMarksObject(marksEnt);
					marksData.addMarks(marks);
				}
			}
		}

//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return marksData;
	}

	@Override
	public Marks getStudentSubjects(String admnNo) {
		StudentDetailsEntity studentEnt = studentRepository.getStudentByAdmn(admnNo);
		Marks marksEnterObject = new Marks();
		if(classList.contains(studentEnt.getStd())) {
			marksEnterObject.setSubjectList(subjectList);
		}else {
			marksEnterObject.setSubjectList(lkgSubjectList);
		}
		marksEnterObject.setExamTypeList(examTypeList);
		marksEnterObject.setStudentName(studentEnt.getStudentFirstName() + " " + studentEnt.getStudentLastName());
		marksEnterObject.setStd(studentEnt.getStd());
		marksEnterObject.setStudentId(studentEnt.getId());
		return marksEnterObject;
	}

	@Override
	public void updateMarks(Marks marksEnterObject) {
		StudentDetailsEntity studentEnt = studentRepository.findStudentById(marksEnterObject.getStudentId());
		for(MarksEntity marksEnt : studentEnt.getMarksEntity()) {
			String subject = marksEnterObject.getSubject();
			String marksEntSubject = marksEnt.getSubject();
			if(subject.equals(marksEntSubject)) {
				
				marksEnt.setFA1(marksEnterObject.getfA1());
				marksEnt.setfA1Grade(marksEnterObject.getfA1());
			
				marksEnt.setFA2(marksEnterObject.getfA2());
				marksEnt.setfA2Grade(marksEnterObject.getfA2());
			
				marksEnt.setSA1(marksEnterObject.getsA1());
				marksEnt.setsA1Grade(marksEnterObject.getsA1());
			
				marksEnt.setFA3(marksEnterObject.getfA3());
				marksEnt.setfA3Grade(marksEnterObject.getfA3());
			
				marksEnt.setFA4(marksEnterObject.getfA4());
				marksEnt.setfA4Grade(marksEnterObject.getfA4());
				
				marksEnt.setSA2(marksEnterObject.getsA2());
				marksEnt.setsA2Grade(marksEnterObject.getsA2());
			}
			marksRepository.save(marksEnt);
			
		}
	}
	
	@Override
	public void updateMarksByMarksId(Marks marksEnterObject) {
		MarksEntity marksEnt = marksRepository.getMarks(marksEnterObject.getMarksId());

		marksEnt.setFA1(marksEnterObject.getfA1());
		marksEnt.setfA1Grade(marksEnterObject.getfA1());

		marksEnt.setFA2(marksEnterObject.getfA2());
		marksEnt.setfA2Grade(marksEnterObject.getfA2());

		marksEnt.setSA1(marksEnterObject.getsA1());
		marksEnt.setsA1Grade(marksEnterObject.getsA1());

		marksEnt.setFA3(marksEnterObject.getfA3());
		marksEnt.setfA3Grade(marksEnterObject.getfA3());

		marksEnt.setFA4(marksEnterObject.getfA4());
		marksEnt.setfA4Grade(marksEnterObject.getfA4());

		marksEnt.setSA2(marksEnterObject.getsA2());
		marksEnt.setsA2Grade(marksEnterObject.getsA2());
		marksRepository.save(marksEnt);
			

	}

	@Override
	public MarksData getAllStudentsMarks(Integer pageNumber, Integer pageSize, String sortBy, String asc) {
		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = studentRepository.findAll(paging); 
		MarksData marksData = new MarksData();
		Pagination pag = new Pagination();
		marksData.setPagination(pag);
		System.out.println(pagedResult);
		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> studentsEntityList = pagedResult.getContent();
			
			for (StudentDetailsEntity studentEnt : studentsEntityList) {
				for(MarksEntity marksEnt : studentEnt.getMarksEntity()) {
					Marks marks = getMarksObject(marksEnt);
					marksData.addMarks(marks);
				}
			}
		}

//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return marksData;
	}

	@Override
	public Marks getMarks(long marksId) {
		MarksEntity marksEnt = marksRepository.getMarks(marksId);
		return getMarksObject(marksEnt);
	}

}
