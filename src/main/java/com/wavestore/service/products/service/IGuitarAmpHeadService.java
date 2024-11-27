package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarAmpHead;

public interface IGuitarAmpHeadService {
	
	public List<GuitarAmpHead> findAll();

	public Page<GuitarAmpHead> findAllWithPagination(int offset, int limit);

	public Page<GuitarAmpHead> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public GuitarAmpHead findById(int id);

	public long countTable();
	
	public List<Brand> findDistinctBrand();

	public Page<GuitarAmpHead> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands, 
			Optional<String> inStock, int offset, int limit);

	public GuitarAmpHead findByItemID(String itemID);

}
