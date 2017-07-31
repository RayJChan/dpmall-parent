package com.dpmall.web.mock;

import java.util.ArrayList;
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
		List<UserModel> out = new ArrayList<UserModel>();
		for(int i = 0; i<20; i++){
			UserModel tmp = new UserModel();
			tmp.agencyId = 1l;
			tmp.cnName = "张三";
			tmp.id = 1l;
			tmp.roleCode = "store_user";
			tmp.storeId = 1l;
			tmp.username = "zhangsan";
			out.add(tmp);
		}
		return out;
	}

	@Override
	public int createStoreUser(UserModel usr) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public int updateUser(UserModel usr) {
		return ErrorCode.SUCCESS;
	}


	@Override
	public Integer updatePasswd(String username, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}


}
