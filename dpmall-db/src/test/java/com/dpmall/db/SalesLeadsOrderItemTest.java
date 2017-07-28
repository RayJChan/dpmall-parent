package com.dpmall.db;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.SalesLeadsOrderItemEntity;
import com.dpmall.db.dao.SalesLeadsOrderItemDao;

public class SalesLeadsOrderItemTest extends SpringTestCase{
	
	private final Logger LOG = LoggerFactory.getLogger(SalesLeadsOrderItemTest.class);
	
	@Autowired
	private  SalesLeadsOrderItemDao salesLeadsOrderItemDao; 
	
	@Test
    public void testInsert(){
		SalesLeadsOrderItemEntity entity = new SalesLeadsOrderItemEntity();
		entity.catetory="1";
		entity.dealPrice=new BigDecimal(10086);
		entity.orderId=10086L;
		entity.quantity=20;
		LOG.info("result:"+salesLeadsOrderItemDao.insert(entity));
    }
}
