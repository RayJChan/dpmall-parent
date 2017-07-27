package com.dpmall.datasvr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.db.bean.OrderEntity;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
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
		return model;
	}
	/**
     * 实物类经销商获取待分配的实物订单
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     * author:crown
     */
	public List<OrderModel> getOnePage4Distribute(String distributorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		List<OrderModel> out = null;

		List<OrderEntity> outEntityList = orderDao.getOnePage4Distribute(distributorId,offset,pageSize);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
				
		out = this.entitysaleModel(outEntityList);
		return out;
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
	
	/**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     */
	public Integer get2DistributeCount(String distributorId) {	
		return orderDao.get2DistributeCount(distributorId);
	}

	public int distribute(String distributorId, String orderCode, String storeId) {
		int result = orderDao.distribute(orderCode, storeId);
		return result;
	}

	public int reject(String distributorId, String orderCode, String rejectType, String rejectRemark) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OrderModel> getOnePage4Followup(String distributorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePageClosedOrder(String distributorId, TimeScope distributeTime, String storeId,
			String orderCode, String clientName, String clientTel, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4Accept(String storeId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2AcceptCount(String storeId) {
		return orderDao.get2AcceptCount(storeId);
	}

	public int accept(String acceptorId, String orderCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deliver(String orderCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OrderModel> getOnePage4Acceptor2Followup(String acceptorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4AcceptorClosed(String acceptorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
