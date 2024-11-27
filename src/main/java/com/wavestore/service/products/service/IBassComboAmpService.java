package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.BassComboAmp;
import com.wavestore.service.products.commons.entity.Brand;

public interface IBassComboAmpService {

	public List<BassComboAmp> findAll();

	public Page<BassComboAmp> findAllWithPagination(int offset, int limit);

	public Page<BassComboAmp> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public BassComboAmp findById(int id);

	public long countTable();
	
	public List<Brand> findDistinctBrand();

	public Page<BassComboAmp> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands, 
			Optional<String> inStock, int offset, int limit);

	public BassComboAmp findByItemID(String itemID);
}
