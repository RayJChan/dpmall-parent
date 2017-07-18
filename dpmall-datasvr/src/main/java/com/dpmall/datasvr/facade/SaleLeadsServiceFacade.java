package com.dpmall.datasvr.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IProductStatisticService;
import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.ProductStatisticModel;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.param.SaleLeadStatisticForm;

public class SaleLeadsServiceFacade implements ISaleLeadsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SaleLeadsServiceFacade.class);
	
	private ISaleLeadsService saleLeadsService;

	public List<SaleLeadsModel> getOnePage4Distribute(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::search',in:{distributorId:'" + distributorId + "',startNum:'"
					+ startNum + "',pageSize:'" + pageSize +"'}}");
		}
		
		List<SaleLeadsModel> out = saleLeadsService.getOnePage4Distribute(distributorId, startNum, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::search',out:"+JSON.toJSONString(out)+"}");
		}
		return out;
	}
	
	public void setISaleLeadsService(ISaleLeadsService saleLeadsService) {
		this.saleLeadsService = saleLeadsService;
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
	

	public void setSaleLeadsService(ISaleLeadsService saleLeadsService) {
		this.saleLeadsService = saleLeadsService;
	}

	
}
