package com.dpmall.datasvr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.IPrepayService;
import com.dpmall.api.bean.PrepayModel;
import com.dpmall.api.bean.SaleLeadsGoodsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.db.dao.PrePayDao;

/**
 * 特权定金实现
 * @author river
 * @date 2017-07-14
 */
public class PrepayServiceImpl implements IPrepayService {
	
	@Autowired
	private PrePayDao prePayDao;

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
		
		return prePayDao.get2DistributeCount(distributorId, status);
	}

	public List<PrepayModel> getOnePage4StoreId(String storeId, String status, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2StoreCount(String storeId, String status) {
		// TODO Auto-generated method stub
		return prePayDao.get2StoreCount(storeId, status);
	}

	public List<PrepayModel> getOnePage4AcceptorId(String acceptorId, String status, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2AcceptorCount(String acceptorId, String status) {
		// TODO Auto-generated method stub
		int result = prePayDao.get2AcceptorCount(acceptorId, status);
		return result;
	}

	public PrepayModel get4ConsignmentId(String consignmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer distribute(String distributorId, String orderCode, String storeId, String remark) {
		int result = 0;
		prePayDao.distribute(distributorId, orderCode, storeId);//更新状态
		int result2 = prePayDao.distributeO2o(orderCode, remark); //更新备注
		
		if( result2 != 0 ) {
			result =1;
		}
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
