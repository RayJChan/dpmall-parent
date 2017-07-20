package com.dpmall.web.mock;

import java.util.List;

import com.dpmall.api.IUserService;
import com.dpmall.api.bean.LoginResModel;
import com.dpmall.api.bean.UserModel;
import com.dpmall.api.enums.ERoleType;
import com.dpmall.api.err.ErrorCode;

public class UserServiceMock implements IUserService {

	@Override
	public LoginResModel login(String username, String passwd) {
		LoginResModel res = new LoginResModel();
		res.username = username;
		res.token = "wxxssjjkkasdasadasdasasasdasdasdasas";
		if(username.startsWith("store_user")){
			res.roleCode = ERoleType.STORE_USER.getRoleCode();
		} else if(username.startsWith("store_mgr")){
			res.roleCode = ERoleType.STORE_MGR.getRoleCode();
		} else if(username.startsWith("agency")){
			res.roleCode = ERoleType.AGENCY.getRoleCode();
		}
		return res;
	}
	

	@Override
	public List<UserModel> getStoreAllUser(Long storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createStoreUser(UserModel usr) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public int updateUser(UserModel usr) {
		return ErrorCode.SUCCESS;
	}


}
