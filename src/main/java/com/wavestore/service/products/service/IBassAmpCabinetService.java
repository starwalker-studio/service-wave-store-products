package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;
import com.wavestore.service.products.commons.entity.Brand;

public interface IBassAmpCabinetService {
	
	public List<BassAmpCabinet> findAll();
	
	public Page<BassAmpCabinet> findAllWithPagination(int offset, int limit);
	
	public Page<BassAmpCabinet> findByBrandIn(Collection<Integer> brands, Pageable pageable);
	
	public BassAmpCabinet findById(int id);

	public long countTable();
	
	public List<Brand> findDistinctBrand();
}
