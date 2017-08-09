package com.dpmall.datasvr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IUserService;
import com.dpmall.api.bean.LoginResModel;
import com.dpmall.api.bean.UserModel;
import com.dpmall.db.bean.AppUserEntity;
import com.dpmall.db.dao.AppUserDao;

public class UserServiceImpl implements IUserService {
	
	@Autowired
	private AppUserDao userDao;
	
	private UserModel entityToModel(AppUserEntity entity) {
		UserModel model=new UserModel();
		model.id=entity.id;
		model.agencyId=entity.agencyId;
		model.cnName=entity.cnName;
		model.roleCode=entity.roleCode;
		model.storeId=entity.storeId;
		model.username=entity.username;
		return model;
	}
	
	private LoginResModel entityToLoginModel(AppUserEntity entity) {
		LoginResModel model=new LoginResModel();
		model.id=entity.id;
		model.agencyId=entity.agencyId;
		model.cnName=entity.cnName;
		model.roleCode=entity.roleCode;
		model.storeId=entity.storeId;
		model.username=entity.username;
		return model;
	}

	public LoginResModel login(String username, String passwd) {
		AppUserEntity entity= userDao.login(username, passwd);
		if (entity==null) {
			return null;
		}
		else {
			LoginResModel result = entityToLoginModel(entity);
			return result;
		}
		
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
		List<AppUserEntity> entities = userDao.getStoreAllUser(storeId);
		List<UserModel> result=new ArrayList<UserModel>(entities.size());
		for(AppUserEntity entity:entities) {
			result.add(entityToModel(entity));
		}
		return result;
	}

	public Integer updatePasswd(String username, String passwd,String oldPasswd) {
		// TODO Auto-generated method stub
		return userDao.changePassword(username, passwd, oldPasswd);
	}

}
