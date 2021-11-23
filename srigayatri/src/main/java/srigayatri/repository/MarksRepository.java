package srigayatri.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import srigayatri.entity.MarksEntity;

public interface MarksRepository extends PagingAndSortingRepository<MarksEntity, Integer>{
	
	@Query(value = "SELECT * FROM MARKS_ENTITY WHERE CLASS_ADMISSION = :std",nativeQuery = true)
	Page<MarksEntity> findMarksByClass(@Param("std") String searchByClass, Pageable paging);

	@Query(value = "SELECT * FROM MARKS_ENTITY WHERE MARKS_ID = :marksId",nativeQuery = true)
	MarksEntity getMarks(@Param("marksId") long marksId);
	
	

}
