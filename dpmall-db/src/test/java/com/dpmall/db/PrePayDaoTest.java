package com.dpmall.db;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.PrePayEntity;
import com.dpmall.db.dao.PrePayDao;

public class PrePayDaoTest extends SpringTestCase {
	private final Logger logger = LoggerFactory.getLogger(PrePayDaoTest.class);
	
	@Autowired
	private PrePayDao prePayDao;
	
	@Test
	public void get2DistributeCountTest() {
		logger.info("result:"+prePayDao.get2DistributeCount("8796125974074", "4"));
	}
	
	@Test
	public void get2StoreCountTest() {
		logger.info("result:"+prePayDao.get2StoreCount("8796129429496", "6"));
	}
	@Test
	public void testGet4ConsignmentId() {
		logger.info("=====================testGet4ConsignmentId=======================");
		PrePayEntity result = prePayDao.get4ConsignmentId("aSITB100572001");
    	logger.info(JSON.toJSONString(result));
	}
	@Test
    public void testGetOnePage4AcceptorId(){
		logger.info("=====================getOnePage4AcceptorId=======================");
		List<PrePayEntity> result = prePayDao.getOnePage4AcceptorId("1", "8796105637979", 0, 20);
    	logger.info(JSON.toJSONString(result));
    }
	@Test
    public void testGet4Search(){
		logger.info("=====================get4Search=======================");
		List<PrePayEntity> result = prePayDao.get4Search("18234101551", "12306", "");
    	logger.info(JSON.toJSONString(result));
    }
	
	/**
	 * 特权定金销商商订单状态列表
	 * @param distributorId 经销商Id
	 * @param status 状态
	 * @param startNum 上一次加载的最后项
	 * @param pageSize 页的大小
	 * @return 特权定金销商商订单状态列表
	 */
	@Test
	public void testGetOnePage4Distribute() {
		logger.info("=================testGetOnePage4Distribute====================");
		List<PrePayEntity> entitieList = prePayDao.getOnePage4Distribute("310145", "3", "天" ,1, 999);
		logger.info(JSON.toJSONString(entitieList));
	}
	
	/**
	 * 特权定金销商商订单状态列表
	 * @param distributorId 经销商Id
	 * @param status 状态
	 * @param startNum 上一次加载的最后项
	 * @param pageSize 页的大小
	 * @return 特权定金销商商订单状态列表
	 */
	@Test
	public void testGetOnePage4StoreId() {
		logger.info("=================testGetOnePage4StoreId====================");
		List<PrePayEntity> entitieList = prePayDao.getOnePage4StoreId("8796129527800", "2", 1, 999);
		logger.info(JSON.toJSONString(entitieList));
	}
	
}
