package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

	public Page<BassAmpCabinet> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands,
			Optional<String> inStock, int offset, int limit);

	public BassAmpCabinet findByItemID(String item);

}