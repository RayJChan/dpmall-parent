package com.dpmall.datasvr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.db.bean.OrderEntity;
import com.dpmall.db.bean.OrderItemEntity;
import com.dpmall.db.dao.AppOrderDao;

/**
 * 实物订单服务实现
 * @author river
 * @date 2017-07-14
 */
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private AppOrderDao orderDao;
	
	private OrderEntity modelToEntity(OrderModel model) {
		OrderEntity entity=new OrderEntity();
		entity.clientName=model.clientName;
		entity.clientTel=model.clientTel;
		
		entity.allocatCode=model.allocatCode;
		entity.shippingAddress=model.shippingAddress;
		entity.buyerNick=model.buyerNick;
		entity.productCode=model.productCode;
		entity.productCategory=model.productCategory;
		entity.productQuantity=model.productQuantity;;
		entity.productBaseprice=model.productBaseprice;
		entity.productTotal=model.productTotal;
		entity.phone1=model.phone1;
		entity.firstName=model.firstName;
		entity.address=model.address;
		entity.orderTotal=model.orderTotal;
		entity.status=model.status;
		entity.id=model.id;
		entity.consignmentCode=model.consignmentCode;
		entity.logisticsInfo=model.logisticsInfo;
		entity.trackingId=model.trackingId;
		entity.deliveryCost=model.deliveryCost;
		entity.salesApplication=model.salesApplication;
		entity.juntanPrice=model.juntanPrice;
		entity.payAmount=model.payAmount;
		entity.serviceAmount=model.serviceAmount;
		entity.deliveryMethods=model.deliveryMethods;
		entity.name=model.name;
		for(Object obj:model.items) {
			entity.items.add((OrderItemEntity) obj);
		}
		return entity;
	}
	
	private OrderModel entityToModel(OrderEntity entity) {
		OrderModel model=new OrderModel();
		model.allocatCode=entity.allocatCode;
		model.shippingAddress=entity.shippingAddress;
		model.buyerNick=entity.buyerNick;
		model.productCode=entity.productCode;
		model.productCategory=entity.productCategory;
		model.productQuantity=entity.productQuantity;;
		model.productBaseprice=entity.productBaseprice;
		model.productTotal=entity.productTotal;
		model.phone1=entity.phone1;
		model.firstName=entity.firstName;
		model.address=entity.address;
		model.status=entity.status;
		model.id = entity.id;
		model.consignmentCode=entity.consignmentCode;
		model.logisticsInfo=entity.logisticsInfo;
		model.trackingId=entity.trackingId;
		model.deliveryCost=entity.deliveryCost;
		model.salesApplication=entity.salesApplication;
		model.juntanPrice=entity.juntanPrice;
		model.payAmount=entity.payAmount;
		model.serviceAmount=entity.serviceAmount;
		model.deliveryMethods=entity.deliveryMethods;
		model.name=entity.name;
		for (OrderItemEntity item:entity.items) {
			model.orderTotal=model.orderTotal.add(item.deliveryCost==null?BigDecimal.ZERO:item.deliveryCost).add(item.payAmount==null?BigDecimal.ZERO:item.payAmount).add(item.serviceAmount==null?BigDecimal.ZERO:item.serviceAmount);
			model.items.add(item);
		}
		return model;
	}

	
	private List<OrderModel> entitysaleModel(List<OrderEntity> in){
		if(in == null || in.isEmpty()){
			return null;
		}
		
		List<OrderModel> out = new ArrayList<OrderModel>();
		for(OrderEntity tmp : in){
			out.add(entityToModel(tmp));
		}
		
		return out;
		
	}
	
	public int reject(String distributorId, String orderCode, String rejectType, String rejectRemark) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OrderModel> getOnePage4Followup(String distributorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		List<OrderModel> out = null;

		List<OrderEntity> outEntityList = orderDao.getOnePage4Followup(distributorId,offset,pageSize);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
						
		out = this.entitysaleModel(outEntityList);
		return out;
	}

	public List<OrderModel> getOnePageClosedOrder(String distributorId, TimeScope distributeTime, String storeId,
			String orderCode, String clientName, String clientTel, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param offset 上一次加载的位移
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
	public List<OrderModel> getOnePage4Accept(String storeId, Integer offset, Integer pageSize) {
		List<OrderModel> orderModel = null;
		
		List<OrderEntity> orderEntityList = orderDao.getOnePage4Accept(storeId,offset,pageSize);
		if(orderEntityList == null || orderEntityList.isEmpty()){
			return null;
		}
		orderModel = this.entitysaleModel(orderEntityList);
		return orderModel;
	}

	public Integer get2AcceptCount(String storeId) {
		return orderDao.get2AcceptCount(storeId);
	}

	/**
     * 导购员接单
     * @param model
     * @return 成功返回200
     */
	public int accept(String acceptorId, String orderCode, String acceptComment) {
		OrderEntity entity = new OrderEntity();
		
		entity.acceptedBy = acceptorId;
		entity.acceptedComment = acceptComment;
		entity.acceptedTime = new Date();
		/*entity.status = "15"; */
		entity.orderCode = orderCode;
		
		int result = orderDao.edit(entity);
		
		return result;
	}

	/**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
	public int deliver(String orderCode) {
		int count = 0;
		Date date = new Date();
		OrderEntity entity = new OrderEntity();
		//orderCode 为空 返回错误代码 500
		if (orderCode == null) {	
			return count;
		}
		//赋值给实体类
		entity.orderCode = orderCode;
		entity.deliveryTime = date;
		entity.status = "20";
		
		int count1 = orderDao.deliver4Consignments(entity);
		int count2 = orderDao.edit(entity);
		if(count1 != 0 && count2 != 0 ) {
			count =1;
		}
		return count;
	}

	public List<OrderModel> getOnePage4Acceptor2Followup(String acceptorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4AcceptorClosed(String acceptorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4Distribute(String distributorId, String status, Integer offset,
			Integer pageSize) {
		List<OrderEntity> entities = orderDao.getOnePage4Distribute(distributorId, status, offset, pageSize);
		List<OrderModel> result = new ArrayList<OrderModel>(entities.size());
		result=entitysaleModel(entities);
		return result;
	}

	public Integer get2DistributeCount(String distributorId, String status) {
		return orderDao.get2DistributeCount(distributorId, status);
	}

	/**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param orderCode 订单编码
     * @param storeId 店铺ID
     * @param remark 备注
     */
	public int distribute(String distributorId, String orderCode, String storeId, String remark) {
		int result = 0;
		int result1 = orderDao.distribute4O2o(orderCode, storeId, remark);
		int result2 = orderDao.distribute4Consignment(orderCode, storeId);
		
		if(result1 != 0 && result2 != 0 ) {
			result =1;
		}
		return result;
	}

	public List<OrderModel> getOnePage4StoreId(String storeId, String status,String acceptorId,Integer offset, Integer pageSize) {
		List<OrderEntity> entities = orderDao.getOnePage4StoreId(storeId, status,acceptorId, offset, pageSize);
		List<OrderModel> result = new ArrayList<OrderModel>(entities.size());
		result=entitysaleModel(entities);
		return result;
	
	}
	/**
     * 实物类门店订单状态条数
     * @param storeId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
	public Integer get2StoreCount(String storeId, String status) {
		return orderDao.get2StoreCount(storeId, status);
	}

	/**
     * 实物类导购员订单状态条数
     * @param acceptorId 导购员ID
     * @param status 状态
     * @return 实物类导购员订单状态条数
     */
	public Integer get2AcceptorCount(String acceptorId, String status) {
		
		return orderDao.get2AcceptorCount(acceptorId, status);
	}

	public List<OrderModel> getOnePage4AcceptorId(String acceptorId, String status, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		List<OrderModel> out = null;

		List<OrderEntity> outEntityList = orderDao.getOnePage4AcceptorId(acceptorId,status,startNum,pageSize);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
								
		out = this.entitysaleModel(outEntityList);
		return out;
	}

	public OrderModel getOrderDetails(String consignmentId) {
		// TODO Auto-generated method stub
		OrderModel out = null;

		OrderEntity outEntityList = orderDao.getOrderDetails(consignmentId);
				
		out = this.entityToModel(outEntityList);
		return out;
	}

	public OrderModel getReturnRequestDetails(String consignmentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
