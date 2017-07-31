package com.dpmall.web.controller;

import java.util.List;

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
import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.web.controller.form.AppOrderForm;
import com.dpmall.web.controller.form.Response;

/**
 * 实物订单服务接口
 * @author river
 * @since 2017-07-10
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;

	/**
	 * 经销商获取待分配的实物订单
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的实物订单列表
	 */
    @RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4Distribute(@RequestBody AppOrderForm form){
    	LOG.info("{method:'OrderController::getOnePage4Distribute',in:" + JSON.toJSONString(form) + "}");

    	Response res = new Response();
        try{
        	res.resultCode=ErrorCode.SUCCESS;
        	res.data = orderService.getOnePage4Distribute(form.distributorId, form.offset, form.pageSize);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'OrderController::getOnePage4Distribute',out:{res:'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2DistributeCount(@RequestBody AppOrderForm form){
    	Response response=new Response();
    	if (StringUtils.isEmpty(form.distributorId)) {
			response.resultCode=ErrorCode.INVALID_PARAM;
			response.message="参数错误";
		}
    	else {
			try {
				response.data=orderService.get2DistributeCount(form.distributorId);
				response.resultCode=ErrorCode.SUCCESS;
			} catch (Exception e) {
				response.resultCode=ErrorCode.INTERNAL_ERR;
				response.message="未知错误";
			}
		}
    	return response;
    }
    
    
    
    /**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param orderCode 订单编码
     * @param storeId 店铺ID
     * @return 成功返回200
     */
    @RequestMapping(value="/distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response distribute(@RequestBody AppOrderForm form){
    	Response response=new Response();
    	if (StringUtils.isEmpty(form.distributorId)||StringUtils.isEmpty(form.orderCode)||StringUtils.isEmpty(form.storeId)) {
    		response.resultCode=ErrorCode.INVALID_PARAM;
			response.message="参数错误";
		}
    	else {
			try {
				response.resultCode=ErrorCode.SUCCESS;
				response.data=orderService.distribute(form.distributorId, form.orderCode, form.storeId);
			} catch (Exception e) {
				response.resultCode=ErrorCode.INTERNAL_ERR;
				response.message="未知错误";
			}
		}
    	return response;
    }
    
    
    /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param orderCode 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return 成功返回200
     */
    @RequestMapping(value="/reject",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int reject(@RequestBody AppOrderForm form){
    	return 0;
    }
    
    
    /**
     * 经销商获取待跟进的一页实物订单数据
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
     * @return 经销商待跟进的一页实物订单数据
     */
    @RequestMapping(value="/getOnePage4Followup",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4Followup(@RequestBody AppOrderForm form){
    	LOG.info("{method:'OrderController::getOnePage4Followup',in:" + JSON.toJSONString(form) + "}");

    	Response res = new Response();
        try{
        	res.data = orderService.getOnePage4Followup(form.distributorId, form.offset, form.pageSize);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'OrderController::getOnePage4Followup',out:{res:'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 根据条件查询已发货的实物订单
     * @param distributorId 经销商Id
     * @param distributeTime 订单下派时间
     * @param storeId
     * @param orderCode
     * @param clientName
     * @param clientTel
     * @param startNum
     * @param pageSize
     * @return 根据条件查询已发货的实物订单
     */
    @RequestMapping(value="/getOnePageClosedOrder",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<OrderModel> getOnePageClosedOrder(@RequestBody AppOrderForm form){
    	return null;
    }
    
    
	/**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
    @RequestMapping(value="/getOnePage4Accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4Accept(@RequestBody AppOrderForm form){
    	LOG.info("{method:'OrderController::getOnePage4Accept',in:" + JSON.toJSONString(form) + "}");

    	Response res = new Response();
        try{
        	res.data = orderService.getOnePage4Accept(form.storeId, form.offset, form.pageSize);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'OrderController::getOnePage4Accept',out:{res:'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 获取店铺待接单的实物订单数
     * @param storeId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2AcceptCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Integer get2AcceptCount(@RequestBody AppOrderForm form) {
		LOG.info("{method:'OrderController::get2AcceptCount',in:" + JSON.toJSONString(form) + "}");
		Response res = new Response();
		if (form.storeId == null) {
			res.resultCode = ErrorCode.INVALID_PARAM;
			return res.resultCode;
		}
		try {
			res.data = orderService.get2AcceptCount(form.storeId == null ? null : String.valueOf(form.storeId));
		} catch (Throwable e) {
			LOG.error(e.getMessage(), e);
		}
		LOG.info("{method:'OrderController::get2AcceptCount',out:{res:'" + JSON.toJSONString(res) + "'}}");
		return (Integer) res.data;
	}
    
     
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param orderCode 订单编码
     * @return 成功返回200
     */
    @RequestMapping(value="/accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int accept(@RequestBody AppOrderForm form){
    	return 0;
    }
    
    /**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
    @RequestMapping(value="/deliver",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int deliver(@RequestBody AppOrderForm form){
    	return 0;
    }
 
    
    /**
     * 获取导购员已接单的一页实物订单信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return 导购员已接单的一页实物订单信息
     */
    @RequestMapping(value="/getOnePage4Acceptor2Followup",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<OrderModel> getOnePage4Acceptor2Followup(@RequestBody AppOrderForm form){
    	return null;
    }
    
    /**
     * 获取导购员已结单的一页实物订单信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return 导购员已结单的一页实物订单信息
     */
    @RequestMapping(value="/getOnePage4AcceptorClosed",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<OrderModel> getOnePage4AcceptorClosed(@RequestBody AppOrderForm form){
    	return null;
    }

}
