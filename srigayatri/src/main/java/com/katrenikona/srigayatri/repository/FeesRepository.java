package com.katrenikona.srigayatri.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.katrenikona.srigayatri.entity.FeesEntity;

public interface FeesRepository extends PagingAndSortingRepository<FeesEntity, Integer>{

	@Query(value = "SELECT * FROM FEES_ENTITY WHERE FEES_ID = :id ",nativeQuery = true)
	FeesEntity getFeesDetailsById(@Param("id") long id);

}
