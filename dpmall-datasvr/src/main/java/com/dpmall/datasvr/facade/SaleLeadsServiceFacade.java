package com.dpmall.datasvr.facade;

import java.util.List;
import java.util.Map;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.param.SaleLeadStatisticForm;

public class SaleLeadsServiceFacade implements ISaleLeadsService {

	public List<SaleLeadsModel> getOnePage4Distribute(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2DistributeCount(String distributorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int distribute(String distributorId, String saleLeadsId, String shopId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<SaleLeadsModel> getOnePage4Followup(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId, TimeScope distributeTime,
			String storeId, String saleLeadId, String clientName, String clientTel, Integer startNum,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaleLeadsModel> getOnePage4Accept(String storeId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2AcceptCount(String storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int accept(String acceptorId, String saleLeadsId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int edit(SaleLeadsModel model) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<SaleLeadsModel> getOnePage4Acceptor2Followup(String acceptorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaleLeadsModel> getOnePageSuccessOrders(SaleLeadStatisticForm form, Integer startNum,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getSuccessOrdersTtlAmount(SaleLeadStatisticForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public int distributeBatch(String distributorId, Map<String, String> saleLeadsId2shopId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectBatch(String distributorId, List<String> saleLeadsIdList, String rejectType, String rejectRemark) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int acceptBatch(String acceptorId, List<String> saleLeadsId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
