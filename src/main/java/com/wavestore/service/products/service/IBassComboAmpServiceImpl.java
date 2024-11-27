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

import com.wavestore.service.products.commons.entity.BassComboAmp;
import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.dao.BassComboAmpDao;

@Service
public class IBassComboAmpServiceImpl implements IBassComboAmpService {

	@Autowired
	private BassComboAmpDao bassComboAmpDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<BassComboAmp> findAll() {
		return (List<BassComboAmp>) bassComboAmpDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BassComboAmp> findAllWithPagination(int offset, int limit) {
		Page<BassComboAmp> bassAmpHead = bassComboAmpDao.findAll(PageRequest.of(offset, limit));
		return bassAmpHead;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BassComboAmp> findByBrandIn(Collection<Integer> brands, Pageable pageable) {
		return (Page<BassComboAmp>) bassComboAmpDao.findByBrandIn(brands, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public BassComboAmp findById(int id) {
		return bassComboAmpDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long countTable() {
		return bassComboAmpDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BassComboAmp> findByCustomSearch(Optional<Double> mayor,
			Optional<Double> minor, Optional<Collection<Integer>> brands, 
			Optional<String> inStock, int offset, int limit) {
		return (Page<BassComboAmp>) bassComboAmpDao.findByCustomSearch(mayor, minor, brands, inStock, PageRequest.of(offset, limit));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Brand> findDistinctBrand() {
		return (List<Brand>) bassComboAmpDao.findDistinctBrand();
	}

	@Override
	@Transactional(readOnly = true)
	public BassComboAmp findByItemID(String itemID) {
		return bassComboAmpDao.findByItemID(itemID);
	}

}
