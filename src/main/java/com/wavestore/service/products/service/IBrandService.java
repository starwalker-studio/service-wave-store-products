package com.wavestore.service.products.service;

import java.util.Collection;
import java.util.List;

import com.wavestore.service.products.commons.entity.Brand;

public interface IBrandService {
	
	public List<Brand> getBrandByIdIn(Collection<Integer> ids);

}
