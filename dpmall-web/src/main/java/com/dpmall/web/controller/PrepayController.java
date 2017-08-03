package com.dpmall.web.controller;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IPrepayService;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.web.controller.form.AppPrepayForm;
import com.dpmall.web.controller.form.Response;

@Controller
@RequestMapping("/prepay")
public class PrepayController {

	private static final Logger LOG = LoggerFactory.getLogger(PrepayController.class);
	
	@Autowired
	private IPrepayService prepayService;
	
	
	
	/**
	 * 特权定金销商商订单状态列表
	 * @param distributorId 经销商Id
	 * @param status 状态
	 * @param startNum 上一次加载的最后项
	 * @param pageSize 页的大小
	 * @return 特权定金销商商订单状态列表
	 */
	@RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4Distribute(@RequestBody AppPrepayForm form){
    	return null;
    }
    
    /**
     * 特权定金经销商订单状态条数
     * @param distributorId 经销商ID
     * @param status 状态
     * @return 特权定金经销商订单状态条数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2DistributeCount(@RequestBody AppPrepayForm form){
    	Response response=new Response();
    	if (StringUtils.isEmpty(form.distributorId)||StringUtils.isEmpty(form.status)) {
			response.resultCode=ErrorCode.INVALID_PARAM;
			response.message="参数错误";
		}
    	else {
    		try {
				response.data=prepayService.get2DistributeCount(form.distributorId, form.status);
				response.resultCode=ErrorCode.SUCCESS;
			} catch (Exception e) {
				response.resultCode=ErrorCode.INTERNAL_ERR;
				response.message="未知错误";
			}
    	}
    	return response;
    }
    
    /**
	 * 特权定金门店订单状态列表
	 * @param storeId 门店Id
	 * @param status 状态
	 * @param startNum 上一次加载的最后项
	 * @param pageSize 页的大小
	 * @return 特权定金门店订单状态列表
	 */
    @RequestMapping(value="/getOnePage4StoreId",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4StoreId(@RequestBody AppPrepayForm form){
    	return null;
    }
    
    /**
     * 特权定金门店订单状态条数
     * @param storeId 门店ID
     * @param status 状态
     * @return 特权定金门店订单状态条数
     */
    @RequestMapping(value="/get2StoreCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2StoreCount(@RequestBody AppPrepayForm form){
    	Response response=new Response();
    	if (StringUtils.isEmpty(form.storeId)||StringUtils.isEmpty(form.status)) {
			response.resultCode=ErrorCode.INVALID_PARAM;
			response.message="参数错误";
		}
    	else {
    		try {
				response.data=prepayService.get2StoreCount(form.storeId, form.status);
				response.resultCode=ErrorCode.SUCCESS;
			} catch (Exception e) {
				response.resultCode=ErrorCode.INTERNAL_ERR;
				response.message="未知错误";
			}
    	}
    	return response;
    }
    
    /**
	 * 特权定金导购员状态列表
	 * @param acceptorId 导购员Id
	 * @param status 状态
	 * @param startNum 上一次加载的最后项
	 * @param pageSize 页的大小
	 * @return 特权定金导购员状态列表
	 */
    @RequestMapping(value="/getOnePage4AcceptorId",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4AcceptorId(@RequestBody AppPrepayForm form){
    	return null;
    }
    
    /**
     * 特权定金导购员状态条数
     * @param acceptorId 导购员ID
     * @param status 状态
     * @return 特权定金导购员状态条数
     */
    @RequestMapping(value="/get2AcceptorCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2AcceptorCount(@RequestBody AppPrepayForm form){
        LOG.info("{method:'PrepayController::get2AcceptorCount',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
        try{
        	res.data = prepayService.get2AcceptorCount(form.acceptorId, form.status);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
		LOG.info("{method:'PrepayController::get2AcceptorCount',out:{res'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    
    /**
     * 特权定金获取单据明细
     * @param consignmentId 发货单ID
     * @return 特权定金获取单据明细
     */
    @RequestMapping(value="/get4ConsignmentId",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get4ConsignmentId(@RequestBody AppPrepayForm form){
    	return null;
    }
    
    
    /**
     * 特权定金经销商接单/下派
     * @param distributorId 经销商ID
     * @param orderCode 发货单id
     * @param storeId 店铺ID
     * @param remark 备注
     * @return 成功返回200
     */
    @RequestMapping(value="/distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response distribute(@RequestBody AppPrepayForm form){
        LOG.info("{method:'PrepayController::distribute',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
        try{
        	res.data = prepayService.distribute(form.distributorId, form.orderCode, form.storeId, form.remark);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
		LOG.info("{method:'PrepayController::distribute',out:{res'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 特权定金编辑订单
     * @param orderCode 发货单id
     * @param status 状态
     * @param remark 备注
     * @return 成功返回200
     */
    @RequestMapping(value="/updateOrder",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response updateOrder(@RequestBody AppPrepayForm form){
    	return null;
    }
    
    
    /**
     * 特权定金被动查询订单
     * @param phone 电话号码
     * @param storeId 门店ID
     * @param acceptorId 导购ID
     * @return 特权定金被动查询订单
     */
    @RequestMapping(value="/get4Search",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get4Search(@RequestBody AppPrepayForm form){
    	return null;
    }
    
    /**
     * 特权定金获取拒单原因
     * @param orderStyle 订单类型
     * @return 特权定金获取拒单原因
     */
    @RequestMapping(value="/getReason4Order",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getReason4Order(@RequestBody AppPrepayForm form){
    	return null;
    }
    

    

}
