package com.dpmall.db;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.OrderEntity;
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
	
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Distribute(){
		logger.info("=====================crown=========================");
    	List<OrderEntity> result = appOrderDao.getOnePage4Distribute("310145", 0,5);
    	logger.info(JSON.toJSONString(result));
    }
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Followup(){
		logger.info("=====================crown==123=======================");
    	List<OrderEntity> result = appOrderDao.getOnePage4Followup("310145", 0,20);
    	logger.info(JSON.toJSONString(result));
    }
}
