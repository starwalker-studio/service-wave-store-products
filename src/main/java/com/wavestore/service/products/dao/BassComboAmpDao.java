package com.wavestore.service.products.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.BassComboAmp;
import com.wavestore.service.products.commons.entity.Brand;


public interface BassComboAmpDao extends JpaRepository<BassComboAmp, Integer> {
	
	public Page<BassComboAmp> findByBrandIn(@Param("brands") Collection<Integer> brands, Pageable pageable);

	public BassComboAmp findById(@Param("id") int id);
	
	@Query("select distinct new Brand(br.id, br.brand) from BassComboAmp bc left join Brand br on br.id = bc.brand")
	public List<Brand> findDistinctBrand();

}
