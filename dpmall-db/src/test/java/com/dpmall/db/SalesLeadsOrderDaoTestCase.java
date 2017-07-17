package com.dpmall.db;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.common.SpringTestCase;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SalesLeadsOrderDaoTestCase  extends SpringTestCase{
	private static final Logger LOG = LoggerFactory.getLogger(SalesLeadsOrderDaoTestCase.class);
	
	@Autowired
	private SalesLeadsOrderDao salesLeadsOrderDao;
	
	@Test
	 public void testGet2AcceptCount(){
    	Integer number = salesLeadsOrderDao.get2AcceptCount("13");
    	System.out.println("获取店铺待接单的线索数======================"+number.toString());
    	
    }
}
