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
		// TODO Auto-generated method stub
		return null;
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

	public Integer updatePasswd(String username, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
