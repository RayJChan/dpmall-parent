package com.dpmall.datasvr.service;

import java.util.List;

import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;

/**
 * 实物订单服务实现
 * @author river
 * @date 2017-07-14
 */
public class OrderServiceImpl implements IOrderService {

	public List<OrderModel> getOnePage4Distribute(String distributorId, String startItemId, Integer pageSize) {
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

	public List<OrderModel> getOnePage4Followup(String distributorId, String startItemId, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePageClosedOrder(String distributorId, TimeScope distributeTime, String storeId,
			String orderCode, String clientName, String clientTel, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4Accept(String storeId, String startItemId, Integer pageSize) {
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

	public List<OrderModel> getOnePage4Acceptor2Followup(String acceptorId, String startItemId, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4AcceptorClosed(String acceptorId, String startItemId, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
