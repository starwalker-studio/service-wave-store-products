package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavestore.service.products.commons.entity.BassComboAmp;

public interface IBassComboAmpService {

	public List<BassComboAmp> findAll();

	public Page<BassComboAmp> findAllWithPagination(int offset, int limit);

	public Page<BassComboAmp> findByBrandIn(Collection<Integer> brands, Pageable pageable);

	public BassComboAmp findById(int id);

	public long countTable();

}
