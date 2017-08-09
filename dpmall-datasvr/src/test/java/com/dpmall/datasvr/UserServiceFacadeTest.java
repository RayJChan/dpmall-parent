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
	
	@Test
	public void test() {
		Logger.info(JSON.toJSONString(userService.getStoreAllUser(2L)));
	}
	
	@Test
	public void testLogin() {
		System.out.println("result:"+userService.login("6", "e10adc3949ba59abbe56e057f20f883e")==null);
	}
}
