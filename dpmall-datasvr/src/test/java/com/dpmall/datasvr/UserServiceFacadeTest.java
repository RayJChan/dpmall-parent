package com.dpmall.datasvr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IUserService;
import com.dpmall.common.SpringTestCase;

public class UserServiceFacadeTest extends SpringTestCase {

	private Logger Logger = LoggerFactory.getLogger(UserServiceFacadeTest.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	@Test
	public void test() {
		Logger.info(JSON.toJSONString(userService.getStoreAllUser(2L)));
	}
}
