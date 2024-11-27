package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarAmpCabinet;

public interface IGuitarAmpCabinetService {

	public List<GuitarAmpCabinet> findAll();

	public Page<GuitarAmpCabinet> findAllWithPagination(int offset, int limit);

	public Page<GuitarAmpCabinet> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public GuitarAmpCabinet findById(int id);

	public long countTable();
	
	public List<Brand> findDistinctBrand();

	public Page<GuitarAmpCabinet> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands, 
			Optional<String> inStock, int offset, int limit);

	public GuitarAmpCabinet findByItemID(String itemID);
}
