package com.dpmall.web.controller;

import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.IUserService;
import com.dpmall.api.bean.LoginResModel;
import com.dpmall.api.bean.UserModel;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.common.MD5Utils;
import com.dpmall.utils.RedisUtils;
import com.dpmall.web.controller.form.Response;
import com.dpmall.web.controller.form.UserForm;
import com.dpmall.web.mock.UserServiceMock;

import redis.clients.jedis.Jedis;

/**
 * <p>
 * 用户相关服务
 * @author river
 * @date 2017-07-19
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private IUserService userServiceMock = new UserServiceMock();
	
	private Jedis jedis=RedisUtils.getClient();
	
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
    public Response login(@RequestBody UserForm form){
    	Response res = new Response();
    	if (StringUtils.isEmpty(form.username)||StringUtils.isEmpty(form.password)) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="用户名或者密码不能为空";
		}
    	else {
    		try{
            	LoginResModel resModel = userService.login(form.username, MD5Utils.MD5Encode(form.password));
            	if (resModel==null) {
    				res.resultCode=ErrorCode.LOGIN_ERR;
    				res.message="用户名或密码错误";				
    			} else {
    				String token=UUID.randomUUID().toString().replaceAll("-", "")+RandomUtils.nextInt(0, 100);
    				jedis.set(String.valueOf(resModel.id),token);
    				jedis.sadd("tokens", token);
    				resModel.token=token;
    				res.data=resModel;
    				res.resultCode=ErrorCode.SUCCESS;
    			}
            } catch(Throwable e){
            	LOG.error(e.getMessage(),e);
            	res.resultCode=ErrorCode.INTERNAL_ERR;
            	res.message="系统错误";
        	}
            finally {
    			jedis.close();
    		}
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
	public Response getStoreAllUser(@RequestBody UserForm userForm) {
		Response res = new Response();
		if (userForm.storeId==null) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
		else {
			try {
				res.data=userService.getStoreAllUser(userForm.storeId);
				res.resultCode=ErrorCode.SUCCESS;
			} catch (Exception e) {
				LOG.error(e.getMessage());
				res.resultCode=ErrorCode.INTERNAL_ERR;
				res.message="未知错误";
			}
		}
		return res;
	}
	
	@RequestMapping(value="/updatePasswd",method= {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	@ResponseBody
    public Response updatePasswd(@RequestBody UserForm form) {
    	Response res = new Response();
    	if (StringUtils.isEmpty(form.username)||StringUtils.isEmpty(form.password)||StringUtils.isEmpty(form.oldPasswd)) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
    	else {
    		try {
    			Integer result = userService.updatePasswd(form.username, MD5Utils.MD5Encode(form.password), MD5Utils.MD5Encode(form.oldPasswd));
    			res.data=result;
    			if (result<1) {
					res.resultCode=ErrorCode.TOKEN_ERR;
					res.message="密码错误";
				}
    			else {				
    				res.resultCode=ErrorCode.SUCCESS;
    				jedis.del(form.username);
    			}			
			
			} catch (Exception e) {
				res.resultCode=ErrorCode.INTERNAL_ERR;
				res.message="系统错误";
			}
    	}
    	return res;
    }
	


}
