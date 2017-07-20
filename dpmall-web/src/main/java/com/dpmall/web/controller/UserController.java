package com.dpmall.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.IUserService;
import com.dpmall.api.bean.UserModel;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.web.controller.form.Response;
import com.dpmall.web.mock.UserServiceMock;

/**
 * <p>
 * 用户相关服务
 * @author river
 * @date 2017-07-19
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private IUserService userServiceMock = new UserServiceMock();
	
	@Autowired
	private IUserService userService;
	
	/**
	 * <p>
	 * 登录接口
	 * @param username
	 * @param passwd
	 * @return
	 */
	@RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
	@ResponseBody
    public Response login(String username, String passwd){
    	Response res = new Response();
    
        try{
        	res.data = userServiceMock.login(username, passwd);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	

    	return res;
    
	}
    
    /***
     * 门店创建用户
     * @param usr
     * @return
     */	
	@RequestMapping(value="/createStoreUser",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
 	@ResponseBody
    public Response createStoreUser(UserModel usr,String token){
    	Response res = new Response();
    
        try{
        	res.resultCode = userServiceMock.createStoreUser(usr);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    
	
    }
    
    /**
     * 更新用户
     * @param usr
     * @return
     */
	@RequestMapping(value="/updateUser",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
 	@ResponseBody
    public Response updateUser(UserModel usr,String token){
    	Response res = new Response();
        try{
        	res.resultCode = userServiceMock.createStoreUser(usr);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    }
	
	@RequestMapping(value="/getStoreAllUser",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	@ResponseBody
	public Response getStoreAllUser(Long storeId,String token) {
		Response res = new Response();
		if (storeId==null) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
		else {
			try {
				res.data=userService.getStoreAllUser(storeId);
				res.resultCode=ErrorCode.SUCCESS;
			} catch (Exception e) {
				LOG.error(e.getMessage());
				res.resultCode=ErrorCode.INTERNAL_ERR;
				res.message="未知错误";
			}
		}
		return res;
	}

}
