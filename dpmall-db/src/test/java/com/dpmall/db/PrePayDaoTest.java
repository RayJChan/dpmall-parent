package com.dpmall.db;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.common.SpringTestCase;
import com.dpmall.db.dao.PrePayDao;

public class PrePayDaoTest extends SpringTestCase {
	private final Logger logger = LoggerFactory.getLogger(PrePayDaoTest.class);
	
	@Autowired
	private PrePayDao prePayDao;
	
	@Test
	public void get2DistributeCountTest() {
		logger.info("result:"+prePayDao.get2DistributeCount("", ""));
	}
}
