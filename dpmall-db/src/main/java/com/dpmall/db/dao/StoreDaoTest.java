package com.dpmall.db.dao;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.StoreEntity;
import com.dpmall.db.dao.StoreDao;

public class StoreDaoTest extends SpringTestCase{
	
	private final Logger LOG = LoggerFactory.getLogger(StoreDaoTest.class);
	
	@Autowired
	private  StoreDao storeDao; 
	
	@Test
	public void listDistributorStores() {
		List<StoreEntity> result =  storeDao.listDistributorStores("310157");
		LOG.info("result:"+JSON.toJSONString(result));
	}
}
