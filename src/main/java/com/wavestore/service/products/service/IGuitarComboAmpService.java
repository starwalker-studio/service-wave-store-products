package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.GuitarComboAmp;

public interface IGuitarComboAmpService {
	
	public List<GuitarComboAmp> findAll();

	public Page<GuitarComboAmp> findAllWithPagination(int offset, int limit);

	public Page<GuitarComboAmp> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public GuitarComboAmp findById(int id);

	public long countTable();


}
