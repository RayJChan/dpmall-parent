package com.dpmall.datasvr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IStoreService;
import com.dpmall.common.SpringTestCase;

public class StoreServiceFacadeTest  extends SpringTestCase{
	private Logger LOG = LoggerFactory.getLogger(StoreServiceFacadeTest.class);
	
	@Autowired
	private IStoreService storeService;
	
	@Test
	public void listDistributorStoresTest() {
		LOG.info(JSON.toJSONString(storeService.listDistributorStores("310157")));
	}
}
