package com.dpmall.api;

import java.util.List;

import com.dpmall.api.bean.LoginResModel;
import com.dpmall.api.bean.UserModel;

/**
 * 用户权限服务
 * @author river
 * @date 2017-07-19
 */
public interface IUserService {
	
	/**
	 * <p>
	 * 登录接口
	 * @param username 用户名
	 * @param passwd 密码
	 * @return 用户信息
	 */
    public LoginResModel login(String username, String passwd);
    
    /***
     * 门店创建用户
     * @param usr
     * @return
     */
    public int createStoreUser(UserModel usr);
    
    /**
     * 更新用户
     * @param usr
     * @return
     */
    public int updateUser(UserModel usr);
    
    /**
     * <p>
     * 获取门店的所有用户
     * @param storeId
     * @return
     */
    public List<UserModel> getStoreAllUser(Long storeId);
    
    
    /**
	 * 修改密码
	 * @param username 用户名
	 * @param passwd 密码
	 * @return 成功返回200
	 */
    public Integer updatePasswd(String username, String passwd);
    
    
}
