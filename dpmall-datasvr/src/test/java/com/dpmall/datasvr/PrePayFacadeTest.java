package com.dpmall.datasvr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IPrepayService;
import com.dpmall.common.SpringTestCase;

public class PrePayFacadeTest extends SpringTestCase{
	private static final Logger LOG = LoggerFactory.getLogger(PrePayFacadeTest.class);
	@Autowired
	private IPrepayService prepayService;
	
	/**
     * 实物类门店订单状态条数
     * @param storeId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
	@Test
	public void testDistribute() {
		logger.info("=================distribute====================");
		Integer count = prepayService.distribute("110", "a100015013", "165434", "daihx");
		logger.info(JSON.toJSONString(count));
	}
}
