package com.wavestore.service.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;
import com.wavestore.service.products.service.IBassAmpCabinetService;

@RestController
public class ProductController {

	@Autowired
	public IBassAmpCabinetService bassAmpCabinetService;

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
	public List<BassAmpCabinet> getBassAmpCabinetByBrand(@RequestParam("brand") int brand) {
		return bassAmpCabinetService.findByBrand(brand);
	}

	@RequestMapping(value = "/search-by-id/bass-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BassAmpCabinet getBassAmpCabinetById(@RequestParam("id") int id) {
		return bassAmpCabinetService.findById(id);
	}
	
	@RequestMapping(value = "/get-count/bass-amp-cabinet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public long getTableCount() {
		return bassAmpCabinetService.countTable();
	}

}
