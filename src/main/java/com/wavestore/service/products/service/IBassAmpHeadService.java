package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.BassAmpHead;
import com.wavestore.service.products.commons.entity.Brand;

public interface IBassAmpHeadService {

	public List<BassAmpHead> findAll();

	public Page<BassAmpHead> findAllWithPagination(int offset, int limit);

	public Page<BassAmpHead> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public BassAmpHead findById(int id);

	public long countTable();

	public List<Brand> findDistinctBrand();

	public Page<BassAmpHead> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands,
			Optional<String> inStock, int offset, int limit);

	public BassAmpHead findByItemID(String itemID);

}
