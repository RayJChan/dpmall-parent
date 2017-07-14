package com.dpmall.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.bean.StoreModel;

/**
 * 门店接口服务
 * @author river
 * @since 2017-07-10
 */
@Controller
@RequestMapping("/store")
public class StoreController {
	
    /**
     * 获取经销商所有门店
     * @param distributorId 经销商ID
     * @return
     */
    @RequestMapping(value="/listDistributorStores",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<StoreModel> listDistributorStores(String distributorId) {
    	return null;
    }
}
