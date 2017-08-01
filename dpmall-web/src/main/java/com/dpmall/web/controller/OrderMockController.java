package com.dpmall.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.bean.OrderModel;
import com.dpmall.web.controller.form.AppOrderForm;
import com.dpmall.web.controller.form.Response;

/**
 * 实物订单服务接口
 * @author river
 * @since 2017-07-10
 */
@Controller
@RequestMapping("/orderMock")
public class OrderMockController {
	
	/**
	 * 经销商获取待分配的实物订单
	 * @param distributorId 经销商Id
	 *  @param status 状态
	 * @param startNum 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的实物订单列表
	 */
    @RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4Distribute(@RequestBody AppOrderForm form){
    	Response response=new Response();
    	List<OrderModel> result = new ArrayList<>();
    	return response;
    }
    
    /**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2DistributeCount(@RequestBody AppOrderForm form){
    	Response response=new Response(); 
    	return response;
    }
    
    
    
    /**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param orderCode 订单编码
     * @param storeId 店铺ID
     * @param remack 备注
     * @return 成功返回200
     */
    @RequestMapping(value="/distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response distribute(@RequestBody AppOrderForm form){
    	Response response=new Response(); 
    	return response;
    }
    
    
	/**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param status 状态
	 * @param startNum 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
    @RequestMapping(value="/getOnePage4StoreId",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4StoreId(@RequestBody AppOrderForm form){
    	Response response=new Response(); 
    	return response;
    }
    
    /**
     * 获取店铺待接单的实物订单数
     * @param storeId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2StoreCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Response get2StoreCount(@RequestBody AppOrderForm form) {
    	Response response=new Response(); 
    	return response;
	}
    
  

    /**
	 * 实物类导购员订单状态列表
	 * @param acceptorId 导购员ID
	 * @param status 状态
	 * @param startNum 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 实物类导购员订单状态列表
	 */
    @RequestMapping(value="/getOnePage4AcceptorId",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4AcceptorId(@RequestBody AppOrderForm form){
    	Response response=new Response(); 
    	return response;
    }
    
    /**
     * 实物类导购员订单状态条数
     * @param acceptorId 导购员ID
     * @param status 状态
     * @return 实物类导购员订单状态条数
     */
    @RequestMapping(value="/get2AcceptorCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Response get2AcceptorCount(@RequestBody AppOrderForm form) {
    	Response response=new Response(); 
    	return response;
	}
    
    /**
     * 实物类获取单据明细
     * @param consignmentId 发货单ID
     * @return 实物类获取单据明细
     */
    @RequestMapping(value="/getOrderDetails",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Response getOrderDetails(@RequestBody AppOrderForm form) {
    	Response response=new Response(); 
    	return response;
	}
    
    /**
     * 实物类退货单明细
     * @param consignmentId 发货单ID
     * @return 实物类退货单明细
     */
    @RequestMapping(value="/getReturnRequestDetails",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Response getReturnRequestDetails(@RequestBody AppOrderForm form) {
    	Response response=new Response(); 
    	return response;
	}

}
