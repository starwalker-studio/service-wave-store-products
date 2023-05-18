package com.wavestore.service.products.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {
	
	public List<Brand> findByIdIn(@Param("ids") Collection<Integer> ids );

}
