package com.wavestore.service.products.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarAmpHead;

public interface GuitarAmpHeadDao extends JpaRepository<GuitarAmpHead, Integer> {

	public static final String CUSTOM_SEARCH_QUERY = "select c from GuitarAmpHead c where" +
			" (COALESCE(:mayor, null) is null or c.price <= :mayor)"
			+ " and (COALESCE(:minor, null) is null or c.price >= :minor)"
			+ " and (COALESCE(:brands, null) is null or c.brand in :brands)"
			+ " and (COALESCE(:product_in_stock, null) is null or c.inStock = :product_in_stock)";

	public static final String DISTINCT_BRAND_QUERY = "select distinct new Brand(br.id, br.brand)" +
			"from GuitarAmpHead bc left join Brand br on br.id = bc.brand";
	
	public Page<GuitarAmpHead> findByBrandIn(@Param("brands") Collection<Integer> brands, Pageable pageable);

	public GuitarAmpHead findById(@Param("id") int id);

	@Query(CUSTOM_SEARCH_QUERY)
	public Page<GuitarAmpHead> findByCustomSearch(@Param("mayor") Optional<Double> mayor,
			@Param("minor") Optional<Double> minor,
			@Param("brands") Optional<Collection<Integer>> brands,
			@Param("product_in_stock") Optional<String> inStock,
			Pageable pageable);

	@Query(DISTINCT_BRAND_QUERY)
	public List<Brand> findDistinctBrand();
	
	public GuitarAmpHead findByItemID(@Param("item") String itemID);
	
}
