package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarAmpCabinet;
import com.wavestore.service.products.dao.GuitarAmpCabinetDao;

@Service
public class IGuitarAmpCabinetServiceImpl implements IGuitarAmpCabinetService {
	
	@Autowired
	private GuitarAmpCabinetDao guitarAmpCabinetDao;

	@Override
	@Transactional(readOnly = true)
	public List<GuitarAmpCabinet> findAll() {
		return (List<GuitarAmpCabinet>) guitarAmpCabinetDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarAmpCabinet> findAllWithPagination(int offset, int limit) {
		Page<GuitarAmpCabinet> bassAmpHead = guitarAmpCabinetDao.findAll(PageRequest.of(offset, limit));
		return bassAmpHead;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarAmpCabinet> findByBrandIn(Collection<Integer> brands, Pageable pageable) {
		return (Page<GuitarAmpCabinet>) guitarAmpCabinetDao.findByBrandIn(brands, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public GuitarAmpCabinet findById(int id) {
		return guitarAmpCabinetDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long countTable() {
		return guitarAmpCabinetDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarAmpCabinet> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands, 
			Optional<String> inStock, int offset, int limit) {
		return (Page<GuitarAmpCabinet>) guitarAmpCabinetDao.findByCustomSearch(mayor, minor, brands, inStock, PageRequest.of(offset, limit));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Brand> findDistinctBrand() {
		return (List<Brand>) guitarAmpCabinetDao.findDistinctBrand();
	}

	@Override
	@Transactional(readOnly = true)
	public GuitarAmpCabinet findByItemID(String itemID) {
		return guitarAmpCabinetDao.findByItemID(itemID);
	}

}
