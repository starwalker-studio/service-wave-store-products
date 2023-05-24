package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.commons.entity.GuitarComboAmp;
import com.wavestore.service.products.dao.GuitarComboAmpDao;

@Service
public class IGuitarComboAmpServiceImpl implements IGuitarComboAmpService {
	
	@Autowired
	private GuitarComboAmpDao guitarComboAmpDao;

	@Override
	@Transactional(readOnly = true)
	public List<GuitarComboAmp> findAll() {
		return (List<GuitarComboAmp>) guitarComboAmpDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarComboAmp> findAllWithPagination(int offset, int limit) {
		Page<GuitarComboAmp> bassAmpHead = guitarComboAmpDao.findAll(PageRequest.of(offset, limit));
		return bassAmpHead;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarComboAmp> findByBrandIn(Collection<Integer> brands, Pageable pageable) {
		return (Page<GuitarComboAmp>) guitarComboAmpDao.findByBrandIn(brands, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public GuitarComboAmp findById(int id) {
		return guitarComboAmpDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long countTable() {
		return guitarComboAmpDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Brand> findDistinctBrand() {
		return (List<Brand>) guitarComboAmpDao.findDistinctBrand();
	}
	
}
