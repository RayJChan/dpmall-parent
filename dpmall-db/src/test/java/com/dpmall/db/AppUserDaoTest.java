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
		AppUserEntity entity =appUserDao.login("6", "123456");
		System.out.println("result:"+String.valueOf(entity==null));
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
}
