package com.training.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.training.common.util.FileHelper;
import com.training.dao.IBrandDao;
import com.training.entity.BrandEntity;
import com.training.model.ResponseDataModel;
import com.training.service.IBrandService;
@Service
public class BrandServiceImpl implements IBrandService {
	
	@Value("${parent.folder.images.brand}")
	private String brandLogoFolderPath;
	
	@Autowired
	IBrandDao brandDao;
	
	/* Add new brand */
	@Override
	public BrandEntity add(BrandEntity brandEntity) {
		try {
			String imagePath = FileHelper.addNewFile(brandLogoFolderPath, brandEntity.getLogoFiles());
			brandEntity.setLogo(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return brandDao.saveAndFlush(brandEntity);
	}
	
	/* Update brand */
	@Override
	public BrandEntity update(BrandEntity brandEntity) {

		try {
			if (brandEntity.getLogoFiles()[0].getSize() > 0) {
				/* Store file into local storage after that remove old file and get image path to save in database */
				String imagePath = FileHelper.editFile(brandLogoFolderPath, brandEntity.getLogoFiles(), brandEntity.getLogo());
				brandEntity.setLogo(imagePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return brandDao.saveAndFlush(brandEntity);
	}
	
	/* Delete brand */
	public ResponseDataModel delete(Long brandId) {
		
		BrandEntity brandEntity = brandDao.findByBrandId(brandId);
		if (brandEntity != null) {
			brandDao.deleteById(brandId);
			brandDao.flush();
			
			try {
				/* Remove logo of brand form store folder */
				FileHelper.deleteFile(brandEntity.getLogo());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	@Override
	public List<BrandEntity> findAll() {
		return brandDao.findAll(Sort.by(Sort.Direction.DESC,"brandId"));
	}
	
	@Override
	public BrandEntity findByBrandName(String brandName) {
		return brandDao.findByBrandName(brandName);
	}

	@Override
	public BrandEntity findByBrandId(Long brandId) {
		return brandDao.findByBrandId(brandId);
	}

	
}
