package com.dpmall.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;

/**
 * 实物订单服务接口
 * @author river
 * @since 2017-07-10
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	/**
	 * 经销商获取待分配的实物订单
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的实物订单列表
	 */
    @RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<OrderModel> getOnePage4Distribute(String distributorId,String startItemId, Integer pageSize){
    	return null;
    }
    
    /**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Integer get2DistributeCount(String distributorId){
    	return 0;
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
    public int distribute(String distributorId,String orderCode, String storeId){
    	return 0;
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
    public int reject(String distributorId, String orderCode, String rejectType, String rejectRemark){
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
    public List<OrderModel> getOnePage4Followup(String distributorId,String startItemId, Integer pageSize){
    	return null;
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
    public List<OrderModel> getOnePageClosedOrder(String distributorId,TimeScope distributeTime, String storeId,String orderCode, String clientName,String clientTel,Integer startNum, Integer pageSize){
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
    public List<OrderModel> getOnePage4Accept(String storeId,String startItemId, Integer pageSize){
    	return null;
    }
    
    /**
     * 获取店铺待接单的实物订单数
     * @param storeId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2AcceptCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Integer get2AcceptCount(String storeId){
    	return 0;
    }
    
    
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param orderCode 订单编码
     * @return 成功返回200
     */
    @RequestMapping(value="/accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int accept(String acceptorId, String orderCode){
    	return 0;
    }
    
    /**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
    @RequestMapping(value="/deliver",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int deliver(String orderCode){
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
    public List<OrderModel> getOnePage4Acceptor2Followup(String acceptorId,String startItemId, Integer pageSize){
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
    public List<OrderModel> getOnePage4AcceptorClosed(String acceptorId,String startItemId, Integer pageSize){
    	return null;
    }

}
