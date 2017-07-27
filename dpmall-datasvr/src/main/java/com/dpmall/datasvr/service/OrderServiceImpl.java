package com.dpmall.datasvr.service;

import java.util.List;

import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.db.bean.OrderEntity;

/**
 * 实物订单服务实现
 * @author river
 * @date 2017-07-14
 */
public class OrderServiceImpl implements IOrderService {
	
	private OrderEntity modelToEntity(OrderModel model) {
		OrderEntity entity=new OrderEntity();
		entity.clientName=model.clientName;
		entity.clientTel=model.clientTel;
		return entity;
	}
	
	private OrderModel entityToModel(OrderEntity entity) {
		return null;
	}
	public List<OrderModel> getOnePage4Distribute(String distributorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2DistributeCount(String distributorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int distribute(String distributorId, String orderCode, String storeId) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
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
