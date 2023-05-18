package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.BassAmpHead;

public interface IBassAmpHeadService {

	public List<BassAmpHead> findAll();
	
	public Page<BassAmpHead> findAllWithPagination(int offset, int limit);
	
	public Page<BassAmpHead> findByBrandIn(Collection<Integer> brands, Pageable pageable);
	
	public BassAmpHead findById(int id);

	public long countTable();
	
}
