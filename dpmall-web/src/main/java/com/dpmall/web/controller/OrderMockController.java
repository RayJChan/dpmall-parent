package com.dpmall.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.bean.OrderItemModel;
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
    	response.resultCode=ErrorCode.SUCCESS;
    	List<OrderModel> results=new ArrayList<OrderModel>();
    	for(int i=0;i<=3;i++){
    		OrderModel order=new OrderModel();
    		order.clientName="客户名称"+i+i+i+i;
        	order.clientRemark="客户备注"+i+i+i;
        	order.clientTel="客户电话"+i+i+i+i;
        	order.deliverMode="送货方式"+i+i+i+i;
        	order.orderCode="订单编号"+i+i+i+i;
        	order.orderRefCode="订单参考编号"+i+i+i+i;
        	order.orderTotal=BigDecimal.valueOf(i+i+i+i);
        	order.payMode="付费方式"+i+i+i+i;
        	order.receiptInfo="发票信息"+i+i+i+i;
        	List<OrderItemModel> orderItemList=new ArrayList<OrderItemModel>();
        	for(int j=0;j<=3;j++){
        		OrderItemModel item=new OrderItemModel();
        		item.catelogId="catelogId"+i+j;
        		item.catelogName="商品品类"+i+j;
        		item.number=i+j;
        		item.orderItemId="订单明细ID"+i+j;
        		item.price=i+j+0D;
        		item.unit="单位"+i+j;
        		orderItemList.add(item);
        	}
        	order.orderItemList=orderItemList;
        	results.add(order);
    	}
    	response.data=results;
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
    	response.resultCode=ErrorCode.SUCCESS;
    	Integer number=10;
    	response.data=number;
    	response.message="666";
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
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
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
    	response.resultCode=ErrorCode.SUCCESS;
    	List<OrderModel> results=new ArrayList<OrderModel>();
    	for(int i=0;i<=3;i++){
    		OrderModel order=new OrderModel();
    		order.clientName="客户名称"+i+i+i+i;
        	order.clientRemark="客户备注"+i+i+i;
        	order.clientTel="客户电话"+i+i+i+i;
        	order.deliverMode="送货方式"+i+i+i+i;
        	order.orderCode="订单编号"+i+i+i+i;
        	order.orderRefCode="订单参考编号"+i+i+i+i;
        	order.orderTotal=BigDecimal.valueOf(i+i+i+i);
        	order.payMode="付费方式"+i+i+i+i;
        	order.receiptInfo="发票信息"+i+i+i+i;
        	List<OrderItemModel> orderItemList=new ArrayList<OrderItemModel>();
        	for(int j=0;j<=3;j++){
        		OrderItemModel item=new OrderItemModel();
        		item.catelogId="catelogId"+i+j;
        		item.catelogName="商品品类"+i+j;
        		item.number=i+j;
        		item.orderItemId="订单明细ID"+i+j;
        		item.price=i+j+0D;
        		item.unit="单位"+i+j;
        		orderItemList.add(item);
        	}
        	order.orderItemList=orderItemList;
        	results.add(order);
    	}
    	response.data=results;
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
    	response.resultCode=ErrorCode.SUCCESS;
    	Integer number=11;
    	response.data=number;
    	response.message="666";
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
    	response.resultCode=ErrorCode.SUCCESS;
    	List<OrderModel> results=new ArrayList<OrderModel>();
    	for(int i=0;i<=3;i++){
    		OrderModel order=new OrderModel();
    		order.clientName="客户名称"+i+i+i+i;
        	order.clientRemark="客户备注"+i+i+i;
        	order.clientTel="客户电话"+i+i+i+i;
        	order.deliverMode="送货方式"+i+i+i+i;
        	order.orderCode="订单编号"+i+i+i+i;
        	order.orderRefCode="订单参考编号"+i+i+i+i;
        	order.orderTotal=BigDecimal.valueOf(i+i+i+i);
        	order.payMode="付费方式"+i+i+i+i;
        	order.receiptInfo="发票信息"+i+i+i+i;
        	List<OrderItemModel> orderItemList=new ArrayList<OrderItemModel>();
        	for(int j=0;j<=3;j++){
        		OrderItemModel item=new OrderItemModel();
        		item.catelogId="catelogId"+i+j;
        		item.catelogName="商品品类"+i+j;
        		item.number=i+j;
        		item.orderItemId="订单明细ID"+i+j;
        		item.price=i+j+0D;
        		item.unit="单位"+i+j;
        		orderItemList.add(item);
        	}
        	order.orderItemList=orderItemList;
        	results.add(order);
    	}
    	response.data=results;
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
    	response.resultCode=ErrorCode.SUCCESS;
    	Integer number=12;
    	response.data=number;
    	response.message="666";
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
		Response response = new Response();
		response.resultCode = ErrorCode.SUCCESS;
		int i = 0;
		OrderModel order = new OrderModel();
		order.clientName = "客户名称" + i + i + i + i;
		order.clientRemark = "客户备注" + i + i + i;
		order.clientTel = "客户电话" + i + i + i + i;
		order.deliverMode = "送货方式" + i + i + i + i;
		order.orderCode = "订单编号" + i + i + i + i;
		order.orderRefCode = "订单参考编号" + i + i + i + i;
		order.orderTotal = BigDecimal.valueOf(i + i + i + i);
		order.payMode = "付费方式" + i + i + i + i;
		order.receiptInfo = "发票信息" + i + i + i + i;
		List<OrderItemModel> orderItemList = new ArrayList<OrderItemModel>();
		for (int j = 0; j <= 3; j++) {
			OrderItemModel item = new OrderItemModel();
			item.catelogId = "catelogId" + i + j;
			item.catelogName = "商品品类" + i + j;
			item.number = i + j;
			item.orderItemId = "订单明细ID" + i + j;
			item.price = i + j + 0D;
			item.unit = "单位" + i + j;
			orderItemList.add(item);
		}
		order.orderItemList = orderItemList;
    	response.data=order;
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
    	Response response = new Response();
		response.resultCode = ErrorCode.SUCCESS;
		int i = 0;
		OrderModel order = new OrderModel();
		order.clientName = "客户名称" + i + i + i + i;
		order.clientRemark = "客户备注" + i + i + i;
		order.clientTel = "客户电话" + i + i + i + i;
		order.deliverMode = "送货方式" + i + i + i + i;
		order.orderCode = "订单编号" + i + i + i + i;
		order.orderRefCode = "订单参考编号" + i + i + i + i;
		order.orderTotal = BigDecimal.valueOf(i + i + i + i);
		order.payMode = "付费方式" + i + i + i + i;
		order.receiptInfo = "发票信息" + i + i + i + i;
		List<OrderItemModel> orderItemList = new ArrayList<OrderItemModel>();
		for (int j = 0; j <= 3; j++) {
			OrderItemModel item = new OrderItemModel();
			item.catelogId = "catelogId" + i + j;
			item.catelogName = "商品品类" + i + j;
			item.number = i + j;
			item.orderItemId = "订单明细ID" + i + j;
			item.price = i + j + 0D;
			item.unit = "单位" + i + j;
			orderItemList.add(item);
		}
		order.orderItemList = orderItemList;
    	response.data=order;
    	return response;
	}

}
