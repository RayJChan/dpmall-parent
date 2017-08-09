package com.dpmall.db;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.AppUserEntity;
import com.dpmall.db.dao.AppUserDao;

public class AppUserDaoTest extends SpringTestCase {
	private Logger LOG = LoggerFactory.getLogger(AppUserDaoTest.class);
	
	@Autowired
	private AppUserDao appUserDao;
	
	@Test
	public void testLogin() {
		AppUserEntity entity =appUserDao.login("6", "e10adc3949ba59abbe56e057f20f883e");
		logger.info("result:"+JSON.toJSONString(entity));
	}
	
	@Test
	public void testChangePassword() {
		Integer result =appUserDao.changePassword("1", "xiecong2","xiecong");
		logger.info("result:"+JSON.toJSONString(result));
	}
	/*
	@Test
	public void  createStoreUserTest() {
		AppUserEntity entity=new AppUserEntity();
		entity.id=5L;
		entity.username="123";
		entity.password="456";
		LOG.info(appUserDao.createStoreUser(entity)+"");
	}
	*/
	@Test
	public void getStoreAllUserTest() {
		
		LOG.info(JSON.toJSONString(appUserDao.getStoreAllUser(2L)));
	}
	
	
	@Test
	public void getStoreAllUserTest2() {
		
		LOG.info(JSON.toJSONString(appUserDao.getStoreAllUser(2L)));
	}
	
	
	
}
