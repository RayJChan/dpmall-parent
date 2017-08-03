package com.dpmall.datasvr.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dpmall.api.IPrepayService;
import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.PrepayModel;
import com.dpmall.api.bean.SaleLeadsGoodsModel;
import com.dpmall.api.common.TimeScope;

/**
 * 特权定金facade
 * @author river
 * @date 2017-07-14
 */
public class PrepayServiceFacade implements IPrepayService {
	
	@Autowired
	@Qualifier("prepayService")
	IPrepayService prepayService;
	
	private final Logger LOG = LoggerFactory.getLogger(PrepayServiceFacade.class);

	public Integer writeoff(String prepayCode, Double ttlAmount, List<SaleLeadsGoodsModel> goodsList) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> getOnePage2WriteOff(String storeId, TimeScope prepayTime, String clientName,
			String clientTel, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> getOnePageClosedPrepay(String storeId, TimeScope prepayTime, String clientName,
			String clientTel, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> getOnePage4Distribute(String distributorId, String status, Integer offset,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2DistributeCount(String distributorId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> getOnePage4StoreId(String storeId, String status, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2StoreCount(String storeId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> getOnePage4AcceptorId(String acceptorId, String status, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2AcceptorCount(String acceptorId, String status) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'PrepayServiceFacade::get2AcceptorCount',in:{acceptorId:'" + acceptorId +"'status:'"+status+ "'}");
		}
		
		Integer result = prepayService.get2AcceptorCount(acceptorId, status);
		return result;
	}

	public PrepayModel get4ConsignmentId(String consignmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer distribute(String distributorId, String orderCode, String storeId, String remark) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'PrepayServiceFacade::distribute',in:{distributorId:'" + distributorId +"'orderCode:'"+orderCode+ "',storeId:'"
					+ storeId + "',remark:'" + remark +"'}}");
		}
		
		Integer result = prepayService.distribute(distributorId, orderCode, storeId, remark);
		return result;
	}

	public Integer updateOrder(String orderCode, String status, String remark) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> get4Search(String phone, String storeId, String acceptorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrepayModel> getReason4Order(String orderStyle) {
		// TODO Auto-generated method stub
		return null;
	}

}
