package com.dpmall.datasvr;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IOrderService;
import com.dpmall.common.SpringTestCase;

public class OrderServiceFacadeTest extends SpringTestCase{
	@Autowired
	private IOrderService orderService;
	
	@Test
	public void get2DistributeCountTest() {
		orderService.get2DistributeCount("8796294532666");
	}
}
