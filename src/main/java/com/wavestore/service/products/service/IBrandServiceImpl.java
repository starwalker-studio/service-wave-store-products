package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavestore.service.products.commons.entity.Brand;
import com.wavestore.service.products.dao.BrandDao;

@Service
public class IBrandServiceImpl implements IBrandService {

	@Autowired
	private BrandDao brandDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Brand> getBrandByIdIn(Collection<Integer> ids) {
		return (List<Brand>) brandDao.findByIdIn(ids);
	}

}
