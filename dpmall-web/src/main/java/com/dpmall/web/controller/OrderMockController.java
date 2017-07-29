package com.dpmall.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的实物订单列表
	 */
    @RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<OrderModel> getOnePage4Distribute(@RequestBody AppOrderForm form){
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
    	return results;
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
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
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
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
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
    public Response reject(@RequestBody AppOrderForm form){
    	Response response=new Response();
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
    	return response;
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
    public List<OrderModel> getOnePage4Followup(@RequestBody AppOrderForm form){
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
        	order.orderItemList=new ArrayList<OrderItemModel>();
        	order.orderItemList.addAll(orderItemList);
        	results.add(order);
    	}
    	return results;
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
        	order.orderItemList=new ArrayList<OrderItemModel>();
        	order.orderItemList.addAll(orderItemList);
        	results.add(order);
    	}
    	return results;
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
    public List<OrderModel> getOnePage4Accept(@RequestBody AppOrderForm form){
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
        	order.orderItemList=new ArrayList<OrderItemModel>();
        	order.orderItemList.addAll(orderItemList);
        	results.add(order);
    	}
    	return results;
    }
    
    /**
     * 获取店铺待接单的实物订单数
     * @param storeId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    @RequestMapping(value="/get2AcceptCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Response get2AcceptCount(@RequestBody AppOrderForm form) {
    	Response response=new Response();
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
    	return response;
	}
    
     
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param orderCode 订单编码
     * @return 成功返回200
     */
    @RequestMapping(value="/accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response accept(@RequestBody AppOrderForm form){
    	Response response=new Response();
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
    	return response;
    }
    
    /**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
    @RequestMapping(value="/deliver",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response deliver(@RequestBody AppOrderForm form){
    	Response response=new Response();
    	response.resultCode=ErrorCode.SUCCESS;
    	response.message="666";
    	return response;
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
        	order.orderItemList=new ArrayList<OrderItemModel>();
        	order.orderItemList.addAll(orderItemList);
        	results.add(order);
    	}
    	return results;
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
        	order.orderItemList=new ArrayList<OrderItemModel>();
        	order.orderItemList.addAll(orderItemList);
        	results.add(order);
    	}
    	return results;
    }

}
