package com.dpmall.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.IStoreService;
import com.dpmall.api.bean.StoreModel;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.web.controller.form.Response;

/**
 * 门店接口服务
 * @author river
 * @since 2017-07-10
 */
@Controller
@RequestMapping("/store")
public class StoreController {
	
	private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private IStoreService storeService;
	
    /**
     * 获取经销商所有门店
     * @param distributorId 经销商ID
     * @return
     */
    @RequestMapping(value="/listDistributorStores",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response listDistributorStores(String distributorId,String token) {
    	Response res = new Response();
    	if (distributorId==null||distributorId.trim().length()<1) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
    	else {
    		 try{
    	        	List<StoreModel> data = storeService.listDistributorStores(distributorId);
    	        	res.data=data;
    	        	res.resultCode=ErrorCode.SUCCESS;
    	        } catch(Throwable e){
    	        	LOG.error(e.getMessage(),e);
    	    	}
    	}
       
    	

    	return res;
    }
}
