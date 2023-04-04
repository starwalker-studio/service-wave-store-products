package com.wavestore.service.products.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;

public interface BassAmpCabinetDao extends JpaRepository<BassAmpCabinet, Integer> {

	public List<BassAmpCabinet> findByBrand(@Param("brand") int brand);
	
	public BassAmpCabinet findById(@Param("id") int id);
	
}
