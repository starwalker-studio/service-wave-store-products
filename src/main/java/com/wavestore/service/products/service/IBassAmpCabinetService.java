package com.wavestore.service.products.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;

public interface IBassAmpCabinetService {
	
	public List<BassAmpCabinet> findAll();
	
	public Page<BassAmpCabinet> findAllWithPagination(int offset, int limit);
	
	public List<BassAmpCabinet> findByBrand(int brand);
	
	public BassAmpCabinet findById(int id);

	public long countTable();
}
