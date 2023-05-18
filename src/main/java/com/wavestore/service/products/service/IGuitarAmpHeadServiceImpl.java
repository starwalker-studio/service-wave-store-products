package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavestore.service.products.commons.entity.GuitarAmpHead;
import com.wavestore.service.products.dao.GuitarAmpHeadDao;

@Service
public class IGuitarAmpHeadServiceImpl implements IGuitarAmpHeadService {
	
	@Autowired
	private GuitarAmpHeadDao guitarAmpHeadDao;

	@Override
	@Transactional(readOnly = true)
	public List<GuitarAmpHead> findAll() {
		return (List<GuitarAmpHead>) guitarAmpHeadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarAmpHead> findAllWithPagination(int offset, int limit) {
		Page<GuitarAmpHead> bassAmpHead = guitarAmpHeadDao.findAll(PageRequest.of(offset, limit));
		return bassAmpHead;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GuitarAmpHead> findByBrandIn(Collection<Integer> brands, Pageable pageable) {
		return (Page<GuitarAmpHead>) guitarAmpHeadDao.findByBrandIn(brands, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public GuitarAmpHead findById(int id) {
		return guitarAmpHeadDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long countTable() {
		return guitarAmpHeadDao.count();
	}

}
