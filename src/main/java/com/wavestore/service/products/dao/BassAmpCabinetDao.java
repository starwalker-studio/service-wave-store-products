package com.wavestore.service.products.dao;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;

public interface BassAmpCabinetDao extends JpaRepository<BassAmpCabinet, Integer> {

	public Page<BassAmpCabinet> findByBrandIn(@Param("brands") Collection<Integer> brands, Pageable pageable);
	
	public BassAmpCabinet findById(@Param("id") int id);
	
}
