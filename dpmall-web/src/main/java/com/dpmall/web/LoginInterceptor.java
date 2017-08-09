package com.dpmall.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.utils.RedisUtils;
import com.dpmall.web.controller.form.Response;

import redis.clients.jedis.Jedis;

public class LoginInterceptor implements HandlerInterceptor{
	private Jedis jedis = RedisUtils.getClient();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		if (url.indexOf("/user/login")>0) {
			return true;
		}
		Response res = new Response();
		try {
			 String id = request.getHeader("id");
			 String token = request.getHeader("token");
			 String checkToken=jedis.get(id);
			 if (token==null||!token.equals(checkToken)) {
				res.resultCode=ErrorCode.TOKEN_ERR;
				res.message="请先登录";
				response.getWriter().append(JSON.toJSONString(res));
				return false;
			}
			 else {
				 return true;
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
