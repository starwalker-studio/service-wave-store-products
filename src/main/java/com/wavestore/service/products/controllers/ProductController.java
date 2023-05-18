package com.wavestore.service.products.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/bass-amp-cabinet/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BassAmpCabinet> getBassAmpCabinetList() {
		return bassAmpCabinetService.findAll();
	}

	@RequestMapping(value = "/bass-amp-cabinet/catalog-pagination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpCabinet> getBassAmpCabinetListWithPagination(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		Page<BassAmpCabinet> catalogWithPagination = bassAmpCabinetService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@RequestMapping(value = "/search-by-brand/bass-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpCabinet> getBassAmpCabinetByBrandIn(@RequestParam("brands") Collection<Integer> brands, Pageable pageable) {
		return bassAmpCabinetService.findByBrandIn(brands, pageable);
	}

	@RequestMapping(value = "/search-by-id/bass-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BassAmpCabinet getBassAmpCabinetById(@RequestParam("id") int id) {
		return bassAmpCabinetService.findById(id);
	}

	@RequestMapping(value = "/get-count/bass-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableBassAmpCabinetCount() {
		return bassAmpCabinetService.countTable();
	}

	/* Bass Amp Head */
	
	@RequestMapping(value = "/bass-amp-head/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BassAmpHead> getBassAmpHeadList() {
		return bassAmpHeadService.findAll();
	}

	@RequestMapping(value = "/bass-amp-head/catalog-pagination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpHead> getBassAmpHeadListWithPagination(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		Page<BassAmpHead> catalogWithPagination = bassAmpHeadService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}

	@RequestMapping(value = "/search-by-brand/bass-amp-head", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassAmpHead> getBassAmpHeadByBrandIn(@RequestParam("brands") Collection<Integer> brands, Pageable pageable) {
		return bassAmpHeadService.findByBrandIn(brands, pageable);
	}

	@RequestMapping(value = "/search-by-id/bass-amp-head", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BassAmpHead getBassAmpHeadById(@RequestParam("id") int id) {
		return bassAmpHeadService.findById(id);
	}

	@RequestMapping(value = "/get-count/bass-amp-head", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableBassAmpHeadCount() {
		return bassAmpHeadService.countTable();
	}
	
	/* Bass Combo Amp */
	
	@RequestMapping(value = "/bass-combo-amp/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BassComboAmp> getBassComboAmpList() {
		return bassComboAmpService.findAll();
	}
	
	@RequestMapping(value = "/bass-combo-amp/catalog-pagination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassComboAmp> getBassComboAmpListWithPagination(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		Page<BassComboAmp> catalogWithPagination = bassComboAmpService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}
	
	@RequestMapping(value = "/search-by-brand/bass-combo-amp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BassComboAmp> getBassComboAmpByBrandIn(@RequestParam("brands") Collection<Integer> brands, Pageable pageable) {
		return bassComboAmpService.findByBrandIn(brands, pageable);
	}
	
	@RequestMapping(value = "/search-by-id/bass-combo-amp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BassComboAmp getBassComboAmpById(@RequestParam("id") int id) {
		return bassComboAmpService.findById(id);
	}
	
	@RequestMapping(value = "/get-count/bass-combo-amp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableBassComboAmpCount() {
		return bassComboAmpService.countTable();
	}
	
	/* Guitar Amp Cabinet */
	
	@RequestMapping(value = "/guitar-amp-cabinet/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuitarAmpCabinet> getGuitarAmpCabinetList() {
		return guitarAmpCabinetService.findAll();
	}
	
	@RequestMapping(value = "/guitar-amp-cabinet/catalog-pagination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpCabinet> getGuitarAmpCabinetListWithPagination(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		Page<GuitarAmpCabinet> catalogWithPagination = guitarAmpCabinetService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}
	
	@RequestMapping(value = "/search-by-brand/guitar-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpCabinet> getGuitarAmpCabinetByBrandIn(@RequestParam("brands") Collection<Integer> brands, Pageable pageable) {
		return guitarAmpCabinetService.findByBrandIn(brands, pageable);
	}
	
	@RequestMapping(value = "/search-by-id/guitar-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GuitarAmpCabinet getGuitarAmpCabinetById(@RequestParam("id") int id) {
		return guitarAmpCabinetService.findById(id);
	}
	
	@RequestMapping(value = "/get-count/guitar-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableGuitarAmpCabinetCount() {
		return guitarAmpCabinetService.countTable();
	}
	
	/* Guitar Amp Head */
	
	@RequestMapping(value = "/guitar-amp-head/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuitarAmpHead> getGuitarAmpHeadList() {
		return guitarAmpHeadService.findAll();
	}
	
	@RequestMapping(value = "/guitar-amp-head/catalog-pagination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpHead> getGuitarAmpHeadListWithPagination(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		Page<GuitarAmpHead> catalogWithPagination = guitarAmpHeadService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}
	
	@RequestMapping(value = "/search-by-brand/guitar-amp-head", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarAmpHead> getGuitarAmpHeadByBrandIn(@RequestParam("brands") Collection<Integer> brands, Pageable pageable) {
		return guitarAmpHeadService.findByBrandIn(brands, pageable);
	}
	
	@RequestMapping(value = "/search-by-id/guitar-amp-head", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GuitarAmpHead getGuitarAmpHeadById(@RequestParam("id") int id) {
		return guitarAmpHeadService.findById(id);
	}
	
	@RequestMapping(value = "/get-count/guitar-amp-head", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableGuitarAmpHeadCount() {
		return guitarAmpHeadService.countTable();
	}
	
	/* Guitar Combo Amp */
	
	@RequestMapping(value = "/guitar-combo-amp/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GuitarComboAmp> getGuitarComboAmpList() {
		return guitarComboAmpService.findAll();
	}
	
	@RequestMapping(value = "/guitar-combo-amp/catalog-pagination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarComboAmp> getGuitarComboAmpListWithPagination(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		Page<GuitarComboAmp> catalogWithPagination = guitarComboAmpService.findAllWithPagination(offset, limit);
		return catalogWithPagination;
	}
	
	@RequestMapping(value = "/search-by-brand/guitar-combo-amp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<GuitarComboAmp> getGuitarComboAmpByBrandIn(@RequestParam("brands") Collection<Integer> brands, Pageable pageable) {
		return guitarComboAmpService.findByBrandIn(brands, pageable);
	}
	
	@RequestMapping(value = "/search-by-id/guitar-combo-amp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GuitarComboAmp getGuitarComboAmpById(@RequestParam("id") int id) {
		return guitarComboAmpService.findById(id);
	}
	
	@RequestMapping(value = "/get-count/guitar-combo-amp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableGuitarComboAmpCount() {
		return guitarComboAmpService.countTable();
	}
	
	/* Brands */

	@RequestMapping(value = "/get-brands/brand-by-ids", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Brand> getBrandByIds(@RequestParam("ids") Collection<Integer> ids) {
		return brandService.getBrandByIdIn(ids);
	}

}
