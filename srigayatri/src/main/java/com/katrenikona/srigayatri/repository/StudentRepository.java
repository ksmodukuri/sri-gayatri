package com.katrenikona.srigayatri.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.katrenikona.srigayatri.entity.StudentDetailsEntity;

public interface StudentRepository extends PagingAndSortingRepository<StudentDetailsEntity, Integer> {
	
	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE STUDENT_FIRST_NAME LIKE %:query% OR STUDENT_LAST_NAME LIKE %:query% OR ADMISSION_NUMBER = :admnNo OR CLASS_ADMISSION = :std",nativeQuery = true)
	Page<StudentDetailsEntity> findStudentBySearch(@Param("admnNo") String searchByAdmnNo, @Param("query") String searchByName, @Param("std") String searchByClass, Pageable paging);

	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE STUDENT_ID = :id ",nativeQuery = true)
	StudentDetailsEntity findStudentById(@Param("id") long studentId);
	
	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE ADMISSION_NUMBER = :admnNo",nativeQuery = true)
	Page<StudentDetailsEntity> findStudentBySearch(@Param("admnNo") String searchByAdmnNo,Pageable paging);

	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE CLASS_ADMISSION = :std",nativeQuery = true)
	List<StudentDetailsEntity> promoteStudents(@Param("std") String fromClass);

	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE CLASS_ADMISSION = :std",nativeQuery = true)
	Page<StudentDetailsEntity> findStudentByClass(@Param("std") String fromClass, Pageable paging);
	
	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE ADMISSION_NUMBER = :admnNo",nativeQuery = true)
	StudentDetailsEntity getStudentByAdmn(@Param("admnNo") String searchByAdmnNo);
	
	@Query(value = "SELECT * FROM STUDENT_DETAILS WHERE ADMISSION_NUMBER = :admnNo",nativeQuery = true)
	StudentDetailsEntity findStudentByAdmnNo(@Param("admnNo") String admnNo);

}
