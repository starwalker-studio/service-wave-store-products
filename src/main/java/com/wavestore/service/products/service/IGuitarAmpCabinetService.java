package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.GuitarAmpCabinet;

public interface IGuitarAmpCabinetService {

	public List<GuitarAmpCabinet> findAll();

	public Page<GuitarAmpCabinet> findAllWithPagination(int offset, int limit);

	public Page<GuitarAmpCabinet> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public GuitarAmpCabinet findById(int id);

	public long countTable();

}
