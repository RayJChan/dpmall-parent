package com.dpmall.datasvr;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IUserService;
import com.dpmall.api.bean.UserModel;
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
		logger.info("result:"+JSON.toJSONString(userService.login("310597", "14e1b600b1fd579f47433b88e8d85291")));
	}
	
	@Test
	public void testGetUserInfo() {
		UserModel result=userService.getUserInfo("2", "6");
		logger.info("result:"+JSON.toJSONString(result));
	}
	
}
