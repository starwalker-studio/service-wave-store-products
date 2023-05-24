package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavestore.service.products.commons.entity.BassAmpCabinet;
import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.dao.BassAmpCabinetDao;

@Service
public class IBassAmpCabinetServiceImpl implements IBassAmpCabinetService {

	@Autowired
	private BassAmpCabinetDao bassAmpCabinetDao;

	@Override
	@Transactional(readOnly = true)
	public List<BassAmpCabinet> findAll() {
		return (List<BassAmpCabinet>) bassAmpCabinetDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<BassAmpCabinet> findAllWithPagination(int offset, int limit) {
		Page<BassAmpCabinet> bassAmpCabinet = bassAmpCabinetDao.findAll(PageRequest.of(offset, limit));
		return bassAmpCabinet;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<BassAmpCabinet> findByBrandIn(Collection<Integer> brands, Pageable pageable) {
		return (Page<BassAmpCabinet>) bassAmpCabinetDao.findByBrandIn(brands, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public BassAmpCabinet findById(int id) {
		return bassAmpCabinetDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long countTable() {
		return bassAmpCabinetDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Brand> findDistinctBrand() {
		return (List<Brand>) bassAmpCabinetDao.findDistinctBrand();
	}


}
