package com.wavestore.service.products.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;
import com.wavestore.service.products.commons.entity.BassAmpHead;
import com.wavestore.service.products.commons.entity.BassComboAmp;
import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarAmpCabinet;
import com.wavestore.service.products.commons.entity.GuitarAmpHead;
import com.wavestore.service.products.commons.entity.GuitarComboAmp;
import com.wavestore.service.products.service.IBassAmpCabinetService;
import com.wavestore.service.products.service.IBassAmpHeadService;
import com.wavestore.service.products.service.IBassComboAmpService;
import com.wavestore.service.products.service.IBrandService;
import com.wavestore.service.products.service.IGuitarAmpCabinetService;
import com.wavestore.service.products.service.IGuitarAmpHeadService;
import com.wavestore.service.products.service.IGuitarComboAmpService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

	@Autowired
	public IBassAmpCabinetService bassAmpCabinetService;

	@Autowired
	public IBassAmpHeadService bassAmpHeadService;

	@Autowired
	public IBassComboAmpService bassComboAmpService;

	@Autowired
	public IGuitarAmpCabinetService guitarAmpCabinetService;

	@Autowired
	public IGuitarAmpHeadService guitarAmpHeadService;

	@Autowired
	public IGuitarComboAmpService guitarComboAmpService;

	@Autowired
	public IBrandService brandService;

	/* Bass Amp Cabinet */

	@GetMapping(value = "/bass-amp-cabinet/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BassAmpCabinet> getBassAmpCabinetList() {
		return bassAmpCabinetService.findAll();
	}

	@GetMapping(value = "/bass-amp-cabinet/catalog-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpCabinet> getBassAmpCabinetListWithPagination(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		Page<BassAmpCabinet> catalogWithPagination = bassAmpCabinetService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@GetMapping(value = "/search-by-brand/bass-amp-cabinet", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpCabinet> getBassAmpCabinetByBrandIn(@RequestParam("brands") Collection<Integer> brands,
			Pageable pageable) {
		return bassAmpCabinetService.findByBrandIn(brands, pageable);
	}

	@GetMapping(value = "/search-by-id/bass-amp-cabinet", produces = MediaType.APPLICATION_JSON_VALUE)
	public BassAmpCabinet getBassAmpCabinetById(@RequestParam("id") int id) {
		return bassAmpCabinetService.findById(id);
	}

	@GetMapping(value = "/get-count/bass-amp-cabinet", produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableBassAmpCabinetCount() {
		return bassAmpCabinetService.countTable();
	}

	@GetMapping(value = "/bass-amp-cabinet/brand-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getBassAmpCabinetBrandList() {
		return bassAmpCabinetService.findDistinctBrand();
	}

	@GetMapping(value = "/bass-amp-cabinet/get-custom-search")
	public Page<BassAmpCabinet> getCustomSearchAmpCabinet(@RequestParam("mayor") Optional<Double> mayor,
			@RequestParam("minor") Optional<Double> minor,
			@RequestParam("brands") Optional<Collection<Integer>> brands,
			@RequestParam("inStock") Optional<String> inStock,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		return bassAmpCabinetService.findByCustomSearch(mayor, minor, brands, inStock, offset, limit);
	}
	
	@GetMapping(value = "/bass-amp-cabinet/get-by-itemID")
	public BassAmpCabinet getByItemIDBassAmpCabinet(@RequestParam("item") String item) {
		return bassAmpCabinetService.findByItemID(item);
	}

	/* Bass Amp Head */

	@GetMapping(value = "/bass-amp-head/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BassAmpHead> getBassAmpHeadList() {
		return bassAmpHeadService.findAll();
	}

	@GetMapping(value = "/bass-amp-head/catalog-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpHead> getBassAmpHeadListWithPagination(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		Page<BassAmpHead> catalogWithPagination = bassAmpHeadService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@GetMapping(value = "/search-by-brand/bass-amp-head", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpHead> getBassAmpHeadByBrandIn(@RequestParam("brands") Collection<Integer> brands,
			Pageable pageable) {
		return bassAmpHeadService.findByBrandIn(brands, pageable);
	}

	@GetMapping(value = "/search-by-id/bass-amp-head", produces = MediaType.APPLICATION_JSON_VALUE)
	public BassAmpHead getBassAmpHeadById(@RequestParam("id") int id) {
		return bassAmpHeadService.findById(id);
	}

	@GetMapping(value = "/get-count/bass-amp-head", produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableBassAmpHeadCount() {
		return bassAmpHeadService.countTable();
	}

	@GetMapping(value = "/bass-amp-head/brand-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getBassAmpHeadBrandList() {
		return bassAmpHeadService.findDistinctBrand();
	}

	@GetMapping(value = "/bass-amp-head/get-custom-search")
	public Page<BassAmpHead> getCustomSearchAmpHead(@RequestParam("mayor") Optional<Double> mayor,
			@RequestParam("minor") Optional<Double> minor,
			@RequestParam("brands") Optional<Collection<Integer>> brands,
			@RequestParam("inStock") Optional<String> inStock,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		return bassAmpHeadService.findByCustomSearch(mayor, minor, brands, inStock, offset, limit);
	}

	@GetMapping(value = "/bass-amp-head/get-by-itemID")
	public BassAmpHead getByItemIDBassAmpHead(@RequestParam("item") String item) {
		return bassAmpHeadService.findByItemID(item);
	}

	/* Bass Combo Amp */

	@GetMapping(value = "/bass-combo-amp/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BassComboAmp> getBassComboAmpList() {
		return bassComboAmpService.findAll();
	}

	@GetMapping(value = "/bass-combo-amp/catalog-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassComboAmp> getBassComboAmpListWithPagination(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		Page<BassComboAmp> catalogWithPagination = bassComboAmpService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@GetMapping(value = "/search-by-brand/bass-combo-amp", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassComboAmp> getBassComboAmpByBrandIn(@RequestParam("brands") Collection<Integer> brands,
			Pageable pageable) {
		return bassComboAmpService.findByBrandIn(brands, pageable);
	}

	@GetMapping(value = "/search-by-id/bass-combo-amp", produces = MediaType.APPLICATION_JSON_VALUE)
	public BassComboAmp getBassComboAmpById(@RequestParam("id") int id) {
		return bassComboAmpService.findById(id);
	}

	@GetMapping(value = "/get-count/bass-combo-amp", produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableBassComboAmpCount() {
		return bassComboAmpService.countTable();
	}

	@GetMapping(value = "/bass-combo-amp/brand-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getBassComboAmpBrandList() {
		return bassComboAmpService.findDistinctBrand();
	}

	@GetMapping(value = "/bass-combo-amp/get-custom-search")
	public Page<BassComboAmp> getCustomSearchComboAmp(@RequestParam("mayor") Optional<Double> mayor,
			@RequestParam("minor") Optional<Double> minor,
			@RequestParam("brands") Optional<Collection<Integer>> brands,
			@RequestParam("inStock") Optional<String> inStock,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		return bassComboAmpService.findByCustomSearch(mayor, minor, brands, inStock, offset, limit);
	}

	@GetMapping(value = "/bass-combo-amp/get-by-itemID")
	public BassComboAmp getByItemIDBassComboAmp(@RequestParam("item") String item) {
		return bassComboAmpService.findByItemID(item);
	}

	/* Guitar Amp Cabinet */

	@GetMapping(value = "/guitar-amp-cabinet/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuitarAmpCabinet> getGuitarAmpCabinetList() {
		return guitarAmpCabinetService.findAll();
	}

	@GetMapping(value = "/guitar-amp-cabinet/catalog-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpCabinet> getGuitarAmpCabinetListWithPagination(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		Page<GuitarAmpCabinet> catalogWithPagination = guitarAmpCabinetService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@GetMapping(value = "/search-by-brand/guitar-amp-cabinet", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpCabinet> getGuitarAmpCabinetByBrandIn(@RequestParam("brands") Collection<Integer> brands,
			Pageable pageable) {
		return guitarAmpCabinetService.findByBrandIn(brands, pageable);
	}

	@GetMapping(value = "/search-by-id/guitar-amp-cabinet", produces = MediaType.APPLICATION_JSON_VALUE)
	public GuitarAmpCabinet getGuitarAmpCabinetById(@RequestParam("id") int id) {
		return guitarAmpCabinetService.findById(id);
	}

	@GetMapping(value = "/get-count/guitar-amp-cabinet", produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableGuitarAmpCabinetCount() {
		return guitarAmpCabinetService.countTable();
	}

	@GetMapping(value = "/guitar-amp-cabinet/brand-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getGuitarAmpCabinetBrandList() {
		return guitarAmpCabinetService.findDistinctBrand();
	}

	@GetMapping(value = "/guitar-amp-cabinet/get-custom-search")
	public Page<GuitarAmpCabinet> getCustomSearchGtrAmpCabinet(@RequestParam("mayor") Optional<Double> mayor,
			@RequestParam("minor") Optional<Double> minor,
			@RequestParam("brands") Optional<Collection<Integer>> brands,
			@RequestParam("inStock") Optional<String> inStock,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		return guitarAmpCabinetService.findByCustomSearch(mayor, minor, brands, inStock, offset, limit);
	}

	@GetMapping(value = "/guitar-amp-cabinet/get-by-itemID")
	public GuitarAmpCabinet getByItemIDGtrAmpCabinet(@RequestParam("item") String item) {
		return guitarAmpCabinetService.findByItemID(item);
	}

	/* Guitar Amp Head */

	@GetMapping(value = "/guitar-amp-head/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuitarAmpHead> getGuitarAmpHeadList() {
		return guitarAmpHeadService.findAll();
	}

	@GetMapping(value = "/guitar-amp-head/catalog-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpHead> getGuitarAmpHeadListWithPagination(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		Page<GuitarAmpHead> catalogWithPagination = guitarAmpHeadService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@GetMapping(value = "/search-by-brand/guitar-amp-head", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpHead> getGuitarAmpHeadByBrandIn(@RequestParam("brands") Collection<Integer> brands,
			Pageable pageable) {
		return guitarAmpHeadService.findByBrandIn(brands, pageable);
	}

	@GetMapping(value = "/search-by-id/guitar-amp-head", produces = MediaType.APPLICATION_JSON_VALUE)
	public GuitarAmpHead getGuitarAmpHeadById(@RequestParam("id") int id) {
		return guitarAmpHeadService.findById(id);
	}

	@GetMapping(value = "/get-count/guitar-amp-head", produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableGuitarAmpHeadCount() {
		return guitarAmpHeadService.countTable();
	}

	@GetMapping(value = "/guitar-amp-head/brand-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getGuitarAmpHeadBrandList() {
		return guitarAmpHeadService.findDistinctBrand();
	}

	@GetMapping(value = "/guitar-amp-head/get-custom-search")
	public Page<GuitarAmpHead> getCustomSearchGtrAmpHead(@RequestParam("mayor") Optional<Double> mayor,
			@RequestParam("minor") Optional<Double> minor,
			@RequestParam("brands") Optional<Collection<Integer>> brands,
			@RequestParam("inStock") Optional<String> inStock,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		return guitarAmpHeadService.findByCustomSearch(mayor, minor, brands, inStock, offset, limit);
	}

	@GetMapping(value = "/guitar-amp-head/get-by-itemID")
	public GuitarAmpHead getByItemIDGtrAmpHead(@RequestParam("item") String item) {
		return guitarAmpHeadService.findByItemID(item);
	}

	/* Guitar Combo Amp */

	@GetMapping(value = "/guitar-combo-amp/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuitarComboAmp> getGuitarComboAmpList() {
		return guitarComboAmpService.findAll();
	}

	@GetMapping(value = "/guitar-combo-amp/catalog-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarComboAmp> getGuitarComboAmpListWithPagination(@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		Page<GuitarComboAmp> catalogWithPagination = guitarComboAmpService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@GetMapping(value = "/search-by-brand/guitar-combo-amp", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarComboAmp> getGuitarComboAmpByBrandIn(@RequestParam("brands") Collection<Integer> brands,
			Pageable pageable) {
		return guitarComboAmpService.findByBrandIn(brands, pageable);
	}

	@GetMapping(value = "/search-by-id/guitar-combo-amp", produces = MediaType.APPLICATION_JSON_VALUE)
	public GuitarComboAmp getGuitarComboAmpById(@RequestParam("id") int id) {
		return guitarComboAmpService.findById(id);
	}

	@GetMapping(value = "/get-count/guitar-combo-amp", produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableGuitarComboAmpCount() {
		return guitarComboAmpService.countTable();
	}

	@GetMapping(value = "/guitar-combo-amp/brand-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getGuitarComboAmpBrandList() {
		return guitarComboAmpService.findDistinctBrand();
	}

	@GetMapping(value = "/guitar-combo-amp/get-custom-search")
	public Page<GuitarComboAmp> getCustomSearchGtrComboAmp(@RequestParam("mayor") Optional<Double> mayor,
			@RequestParam("minor") Optional<Double> minor,
			@RequestParam("brands") Optional<Collection<Integer>> brands,
			@RequestParam("inStock") Optional<String> inStock,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		return guitarComboAmpService.findByCustomSearch(mayor, minor, brands, inStock, offset, limit);
	}

	@GetMapping(value = "/guitar-combo-amp/get-by-itemID")
	public GuitarComboAmp getByItemIDGtrComboAmp(@RequestParam("item") String item) {
		return guitarComboAmpService.findByItemID(item);
	}

	/* Brands */

	@GetMapping(value = "/get-brands/brand-by-ids", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getBrandByIds(@RequestParam("ids") Collection<Integer> ids) {
		return brandService.getBrandByIdIn(ids);
	}

}
