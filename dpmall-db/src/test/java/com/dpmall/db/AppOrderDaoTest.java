package com.dpmall.db;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.dao.AppOrderDao;

public class AppOrderDaoTest extends SpringTestCase{
	
	private final Logger logger=LoggerFactory.getLogger(AppOrderDaoTest.class); 
	
	@Autowired
	private AppOrderDao appOrderDao;

	@Test
	public void getOnePage4DistributeTest() {
		logger.info(JSON.toJSONString(appOrderDao.get2DistributeCount("8796294532666")));
	}
	
	@Test
	public void testGet2AcceptCount() {
		logger.info("获取店铺待接单的实物订单数:"+appOrderDao.get2AcceptCount("10086"));
	}
	
	@Test
	public void distributeTest() {
		logger.info("result:"+JSON.toJSONString(appOrderDao.distribute("1", "10086")));
	}
}
