package com.dpmall.datasvr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IOrderService;
import com.dpmall.common.SpringTestCase;

public class OrderServiceFacadeTest extends SpringTestCase{
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceFacadeTest.class);
	@Autowired
	private IOrderService orderService;
	
	@Test
	public void get2DistributeCountTest() {
		orderService.get2DistributeCount("8796294532666");
	}
	
	@Test
	public void testGet2AcceptCount() {
		Integer result = orderService.get2AcceptCount("10086");
		LOG.info("result:" + result);
	}
	
	@Test
	public void distributeTest() {
		orderService.distribute("", "3", "10002");
	}
}
