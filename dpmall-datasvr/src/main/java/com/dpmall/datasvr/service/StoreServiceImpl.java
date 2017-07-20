package com.dpmall.datasvr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IStoreService;
import com.dpmall.api.bean.StoreModel;
import com.dpmall.db.bean.StoreEntity;
import com.dpmall.db.dao.StoreDao;

/**
 * 门店接口服务实现
 * @author river
 * @since 2017-07-10
 */
public class StoreServiceImpl implements IStoreService {
	
	@Autowired
	private StoreDao storeDao;
	
	private StoreModel entityToModel(StoreEntity entity) {
		StoreModel model=new StoreModel();
		model.storeId=entity.storeId;
		model.storeAddr=entity.storeAddr;
		model.storeName=entity.storeName;
		return model;
	}

	public List<StoreModel> listDistributorStores(String distributorId) {
		List<StoreEntity> entities = storeDao.listDistributorStores(distributorId);
		List<StoreModel> result=new ArrayList<StoreModel>(entities.size());
		for(StoreEntity entity:entities) {
			result.add(entityToModel(entity));
		}
		return result;
	}

}
