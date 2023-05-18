package com.wavestore.service.products.dao;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.BassComboAmp;


public interface BassComboAmpDao extends JpaRepository<BassComboAmp, Integer> {
	
	public Page<BassComboAmp> findByBrandIn(@Param("brands") Collection<Integer> brands, Pageable pageable);

	public BassComboAmp findById(@Param("id") int id);

}
