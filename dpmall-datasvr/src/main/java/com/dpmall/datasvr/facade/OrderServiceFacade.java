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

	
	/**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     */
	public Integer get2DistributeCount(String distributorId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::get2DistributeCount',in:{distributorId:'" + distributorId + "'}}");
		}
		
//		Integer out = orderService.get2DistributeCount(distributorId);
		
		if(LOG.isDebugEnabled()){
//			LOG.info("{method:'OrderServiceFacade::get2DistributeCount',out:"+JSON.toJSONString(out)+"}");
		}
		return null;
	}

	public int distribute(String distributorId, String orderCode, String storeId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::distribute',in:{distributorId:'" + distributorId +"orderCode"+orderCode+"storeId"+storeId+ "'}}");
		}
		
//		Integer out = orderService.distribute(distributorId, orderCode, storeId);
		
		if(LOG.isDebugEnabled()){
//			LOG.info("{method:'OrderServiceFacade::distribute',out:"+JSON.toJSONString(out)+"}");
		}
		return 0;
	}

	public int reject(String distributorId, String orderCode, String rejectType, String rejectRemark) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OrderModel> getOnePage4Followup(String distributorId, Integer offset, Integer pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::getOnePage4Followup',in:{distributorId:'" + distributorId + "',offset:'"
					+ offset + "',pageSize:'" + pageSize +"'}}");
		}
		
		List<OrderModel> out = orderService.getOnePage4Followup(distributorId, offset, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'OrderServiceFacade::getOnePage4Followup',out:"+JSON.toJSONString(out)+"}");
		}
		return out;
	}

	public List<OrderModel> getOnePageClosedOrder(String distributorId, TimeScope distributeTime, String storeId,
			String orderCode, String clientName, String clientTel, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4Accept(String storeId, Integer offset, Integer pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::getOnePage4Accept',in:{storeId:'" + storeId + "',offset:'"
					+ offset + "',pageSize:'" + pageSize +"'}}");
		}
		
//		List<OrderModel> orderModel = orderService.getOnePage4Accept(storeId, offset, pageSize);
		
		if(LOG.isDebugEnabled()){
//			LOG.info("{method:'OrderServiceFacade::getOnePage4Accept',out:"+JSON.toJSONString(orderModel)+"}");
		}
		return null;
	}

	public Integer get2AcceptCount(String storeId) {
		Integer count = 0;
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::get2AcceptCount',in:{storeId:'" + storeId + "'}}");
		}
		try {
//			count = orderService.get2AcceptCount(storeId);
		} catch (Throwable e) {
			LOG.error(e.getMessage(),e);
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'OrderServiceFacade::get2AcceptCount',out:"+count+"}");
		}
		return count;
	}

	public int accept(String acceptorId, String orderCode, String acceptComment) {
		Integer result = 0  ;
		if(LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::accept',in:"
					+ "{acceptorId:'" + acceptorId + "'}+{orderCode:'" + orderCode + "'}+{acceptComment:'" + acceptComment + "'}}");
		}
		try {
			result = orderService.accept(acceptorId, orderCode, acceptComment);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		}
		if(LOG.isDebugEnabled()) {
			LOG.info("{method:'OrderServiceFacade::accept',out:"
					+ "{acceptorId:'" + acceptorId + "'}+{orderCode:'" + orderCode + "'}+{acceptComment:'" + acceptComment + "'}}");
		}
		return result;
	}

	/**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
	public int deliver(String orderCode) {
		Integer deliver = 0 ;
		if(LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::deliver',in:{orderCode:'" + orderCode + "'}}");
		}
		try {
			 deliver = orderService.deliver(orderCode);
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		}
		if(LOG.isDebugEnabled()) {
			LOG.info("{method:'OrderServiceFacade::reject',out:" + deliver + "}");
		}
		return deliver;
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
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'OrderServiceFacade::getOnePage4Distribute',in:{distributorId:'" + distributorId +"'status:'"+status+ "',offset:'"
					+ offset + "',pageSize:'" + pageSize +"'}}");
		}
		
		List<OrderModel> out = orderService.getOnePage4Distribute(distributorId, status, offset, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'OrderServiceFacade::getOnePage4Distribute',out:"+JSON.toJSONString(out)+"}");
		}
		return out;
	}

	public Integer get2DistributeCount(String distributorId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public int distribute(String distributorId, String orderCode, String storeId, String remark) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OrderModel> getOnePage4StoreId(String storeId, String status, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2StoreCount(String storeId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2AcceptorCount(String acceptorId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderModel> getOnePage4AcceptorId(String acceptorId, String status, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderModel getOrderDetails(String consignmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderModel getReturnRequestDetails(String consignmentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
