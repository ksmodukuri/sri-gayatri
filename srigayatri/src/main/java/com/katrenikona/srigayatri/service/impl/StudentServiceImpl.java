package com.katrenikona.srigayatri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.katrenikona.srigayatri.entity.FeesEntity;
import com.katrenikona.srigayatri.entity.StudentDetailsEntity;
import com.katrenikona.srigayatri.object.Pagination;
import com.katrenikona.srigayatri.object.SortField;
import com.katrenikona.srigayatri.object.Student;
import com.katrenikona.srigayatri.object.StudentData;
import com.katrenikona.srigayatri.repository.FeesRepository;
import com.katrenikona.srigayatri.repository.StudentRepository;
import com.katrenikona.srigayatri.service.StudentService;

@Service
public class StudentServiceImpl extends BaseServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private FeesRepository feesRepository;

	@Override
	public void createNewStudent(Student student) {
		StudentDetailsEntity studentEnt = new StudentDetailsEntity();
		studentEnt = getStudentDetailsEntity(student,studentEnt);
		studentEnt = studentRepository.save(studentEnt);
		FeesEntity feesEnt = new FeesEntity();
		feesEnt = getFeesEntity(student,feesEnt);
		feesEnt.setStudent(studentEnt);
		feesRepository.save(feesEnt);
		saveMarksEntity(studentEnt);
	}
	
	@Override
	public void updateStudentDetails(Student student) {
		StudentDetailsEntity studentEnt = studentRepository.findStudentById(student.getId());
		studentEnt = getStudentDetailsEntity(student,studentEnt);
		FeesEntity feesEnt = getFeesEntityWithPaidFees(student,studentEnt);
		feesEnt.setStudent(studentEnt);
		studentEnt = studentRepository.save(studentEnt);	
	}
	
	@Override
	public Student getStudentDetails(long studentId) {
		StudentDetailsEntity studentEnt = studentRepository.findStudentById(studentId);
		return getStudentObjectWithFees(studentEnt);
	}
	
	@Override
	public StudentData getStudents(Integer pageNumber, Integer pageSize, String sortBy, String asc) {
		List<SortField> sortFields = new ArrayList<SortField>();

		
		/*sortFields.add(new SortField("studentFirstName"));
		sortFields.add(new SortField("lastName"));
		sortFields.add(new SortField("emailId"));*/
		 

		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = studentRepository.findAll(paging);

		StudentData students = new StudentData();
		Pagination pag = new Pagination();
		students.setPagination(pag);

		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> studentDetailsEntityList = pagedResult.getContent();

			for (StudentDetailsEntity studentEnt : studentDetailsEntityList) {
				Student student = getStudentObject(studentEnt);
				students.addStudent(student);
			}
		}
//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return students;
	}

	@Override
	public StudentData getSearchStudents(String searchByAdmnNo,String searchByName, String searchByClass, Integer pageNumber, Integer pageSize, String sortBy, String asc) {

		List<SortField> sortFields = new ArrayList<SortField>();

//		sortFields.add(new SortField("firstName"));
//		sortFields.add(new SortField("lastName"));
//		sortFields.add(new SortField("emailId"));

		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = null;
		if (searchByAdmnNo != null && searchByName != null && searchByClass != null) {
			pagedResult = studentRepository.findStudentBySearch(searchByAdmnNo,searchByName,searchByClass, paging);
		} else {
			pagedResult = studentRepository.findAll(paging);
		}
		StudentData students = new StudentData();
		Pagination pag = new Pagination();
		students.setPagination(pag);
		System.out.println(pagedResult);
		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> userEntityList = pagedResult.getContent();

			for (StudentDetailsEntity studentEnt : userEntityList) {
				Student student = getStudentObject(studentEnt);
				students.addStudent(student);
			}
		}

//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return students;
	}

	@Override
	public String promoteStudents(String fromClass, String toClass) {
		List<StudentDetailsEntity> studentEntList = studentRepository.promoteStudents(fromClass);
		for(StudentDetailsEntity studentEnt : studentEntList) {
			studentEnt.setStd(toClass);
			studentRepository.save(studentEnt);
		}
		return "Success";
	}
	
	

	

	

}
