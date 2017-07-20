package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.AppUserEntity;

public interface AppUserDao {
	/*AppUserEntity login(@Param("username")String username, @Param("passwd")String passwd);
	
	 int createStoreUser(@Param("user")AppUserEntity user);
	
	 int updateUser(@Param("user")AppUserEntity user);*/
	 
	 List<AppUserEntity> getStoreAllUser(@Param("storeId")Long storeId);
}
