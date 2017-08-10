package com.dpmall.datasvr.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IUserService;
import com.dpmall.api.bean.LoginResModel;
import com.dpmall.api.bean.UserModel;


public class UserServiceFacade implements IUserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceFacade.class);
	
	@Autowired
	private IUserService userService;

	public LoginResModel login(String username, String passwd) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'UserServiceFacade::getStoreAllUser',in:{username:'" + username + "passwd:"+passwd+"'}}");
		}
		LoginResModel result = userService.login(username, passwd);
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'UserServiceFacade::getStoreAllUser',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
	}

	public int createStoreUser(UserModel usr) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateUser(UserModel usr) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<UserModel> getStoreAllUser(Long storeId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'UserServiceFacade::getStoreAllUser',in:{storeId:'" + storeId + "'}}");
		}
		List<UserModel> result = userService.getStoreAllUser(storeId);
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'UserServiceFacade::getStoreAllUser',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
	}

	public Integer updatePasswd(String username, String passwd,String oldPasswd) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'UserServiceFacade::updatePasswd',in:{username:'" + username + "passwd"+passwd+"oldPasswd:"+oldPasswd+"'}}");
		}
		Integer result = userService.updatePasswd(username, passwd, oldPasswd);
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'UserServiceFacade::updatePasswd',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
	}

	public UserModel getUserInfo(String role, String id) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'UserServiceFacade::getUserInfo',in:{role:'" + role + "id"+id+"'}}");
		}
		UserModel result = userService.getUserInfo(role, id);
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'UserServiceFacade::getUserInfo',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
	}

}
