package com.rollingstone.spring.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.spring.model.SalesOrderDetails;
import com.rollingstone.spring.model.SalesOrderDetailsDTO;

public interface SalesOrderDetailsDaoRepository extends PagingAndSortingRepository<SalesOrderDetails, Long> {
	@Query(name="SalesOrderDetailsDaoRepository.getSalesOrderDetailsByID", nativeQuery = true)
	SalesOrderDetailsDTO getSalesOrderDetailsByid(@Param("id") long id);

}
