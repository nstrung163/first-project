package com.training.service;

import java.util.List;

import com.training.entity.BrandEntity;
import com.training.model.ResponseDataModel;

public interface IBrandService {

	List<BrandEntity> findAll();

	BrandEntity add(BrandEntity brandEntity);

	BrandEntity findByBrandName(String brandName);

	BrandEntity findByBrandId(Long brandId);

	BrandEntity update(BrandEntity brandEntity);

	ResponseDataModel delete(Long brandId);


}
