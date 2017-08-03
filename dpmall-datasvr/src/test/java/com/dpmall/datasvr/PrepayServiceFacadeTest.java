package com.dpmall.datasvr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IPrepayService;
import com.dpmall.common.SpringTestCase;

public class PrepayServiceFacadeTest extends SpringTestCase{
	@Autowired
	IPrepayService prepayService;
	
	private final Logger logger =LoggerFactory.getLogger(PrepayServiceFacadeTest.class);
	@Test
	public void test() {
		logger.info(JSON.toJSONString(prepayService.get2DistributeCount("8796125974074", "4")));
	}
}
