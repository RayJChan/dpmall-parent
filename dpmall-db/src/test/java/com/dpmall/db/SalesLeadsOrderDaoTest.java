package com.dpmall.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SalesLeadsOrderDaoTest extends SpringTestCase {
	
	 private static final Logger LOG = LoggerFactory.getLogger(SalesLeadsOrderDaoTest.class);
	
	@Autowired
	private SalesLeadsOrderDao salesLeadsOrderDao;

	@Test
	public void test() {
		for(SalesLeadsOrderEntity salesLeadsOrderEntity: salesLeadsOrderDao.getOnePage4Acceptor2Followup(null, null, null) ) {
			LOG.info(JSON.toJSONString(salesLeadsOrderEntity));
			System.out.println(JSON.toJSONString(salesLeadsOrderEntity));
		}
	}

}