package com.dpmall.datasvr.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;

/**
 * 实物订单服务facade
 * @author river
 * @date 2017-07-14
 */
public class OrderServiceFacade implements IOrderService {
	
	private final Logger LOG = LoggerFactory.getLogger(OrderServiceFacade.class);
	
	@Autowired
	private IOrderService orderService;

	public List<OrderModel> getOnePage4Distribute(String distributorId, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     */
	public Integer get2DistributeCount(String distributorId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::get2DistributeCount',in:{distributorId:'" + distributorId + "'}}");
		}
		
		Integer out = orderService.get2DistributeCount(distributorId);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'OrderServiceFacade::get2DistributeCount',out:"+JSON.toJSONString(out)+"}");
		}
		return out;
	}

	public int distribute(String distributorId, String orderCode, String storeId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::distribute',in:{distributorId:'" + distributorId +"orderCode"+orderCode+"storeId"+storeId+ "'}}");
		}
		
		Integer out = orderService.distribute(distributorId, orderCode, storeId);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'OrderServiceFacade::distribute',out:"+JSON.toJSONString(out)+"}");
		}
		return out;
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
		Integer count = 0;
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::get2AcceptCount',in:{storeId:'" + storeId + "'}}");
		}
		try {
			count = orderService.get2AcceptCount(storeId);
		} catch (Throwable e) {
			LOG.error(e.getMessage(),e);
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'OrderServiceFacade::get2AcceptCount',out:"+count+"}");
		}
		return count;
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
