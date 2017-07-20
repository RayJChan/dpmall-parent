package com.dpmall.datasvr.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IStoreService;
import com.dpmall.api.bean.StoreModel;

/**
 * 门店接口服务
 * @author river
 * @since 2017-07-10
 */
public class StoreServiceFacade implements IStoreService {
	
	private Logger LOG = LoggerFactory.getLogger(StoreServiceFacade.class);
	
	@Autowired
	private IStoreService storeService;

	public List<StoreModel> listDistributorStores(String distributorId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'StoreServiceFacade::listDistributorStores',in:{distributorId:'" + distributorId + "'}}");
		}
		List<StoreModel> result = storeService.listDistributorStores(distributorId);
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'StoreServiceFacade::listDistributorStores',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
	}

}
