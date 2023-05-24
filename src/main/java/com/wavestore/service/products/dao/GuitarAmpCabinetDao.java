package com.wavestore.service.products.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarAmpCabinet;

public interface GuitarAmpCabinetDao extends JpaRepository<GuitarAmpCabinet, Integer> {
	
	public Page<GuitarAmpCabinet> findByBrandIn(@Param("brands") Collection<Integer> brands, Pageable pageable);

	public GuitarAmpCabinet findById(@Param("id") int id);
	
	@Query("select distinct new Brand(br.id, br.brand) from GuitarAmpCabinet bc left join Brand br on br.id = bc.brand")
	public List<Brand> findDistinctBrand();

}
