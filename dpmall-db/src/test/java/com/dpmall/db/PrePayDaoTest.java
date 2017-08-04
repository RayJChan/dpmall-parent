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
}
