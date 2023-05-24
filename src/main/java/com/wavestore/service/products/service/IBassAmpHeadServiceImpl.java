package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavestore.service.products.commons.entity.BassAmpHead;
import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.dao.BassAmpHeadDao;

@Service
public class IBassAmpHeadServiceImpl implements IBassAmpHeadService {
	
	@Autowired
	private BassAmpHeadDao bassAmpHeadDao;

	@Override
	@Transactional(readOnly = true)
	public List<BassAmpHead> findAll() {
		return (List<BassAmpHead>) bassAmpHeadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BassAmpHead> findAllWithPagination(int offset, int limit) {
		Page<BassAmpHead> bassAmpHead = bassAmpHeadDao.findAll(PageRequest.of(offset, limit));
		return bassAmpHead;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BassAmpHead> findByBrandIn(Collection<Integer> brands, Pageable pageable) {
		return (Page<BassAmpHead>) bassAmpHeadDao.findByBrandIn(brands, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public BassAmpHead findById(int id) {
		return bassAmpHeadDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long countTable() {
		return bassAmpHeadDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Brand> findDistinctBrand() {
		return (List<Brand>) bassAmpHeadDao.findDistinctBrand();
	}

}
