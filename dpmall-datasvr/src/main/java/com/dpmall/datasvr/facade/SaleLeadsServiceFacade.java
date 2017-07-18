package com.dpmall.datasvr.facade;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IProductStatisticService;
import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.ProductStatisticModel;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.param.SaleLeadStatisticForm;

public class SaleLeadsServiceFacade implements ISaleLeadsService {
	
	@Autowired
	@Qualifier("saleLeadsService")
	ISaleLeadsService saleLeadsService;
	
	private final Logger LOG = LoggerFactory.getLogger(SaleLeadsServiceFacade.class);

	public List<SaleLeadsModel> getOnePage4Distribute(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get2DistributeCount(String distributorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 /**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param shopId 店铺ID
     * @return 结果  1为下派成功，0为下派失败
     */
	public int distribute(String distributorId, String saleLeadsId, String shopId) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::distribute',in:{distributorId:'" + distributorId + "',saleLeadsId:'"
					+ saleLeadsId + "',shopId:'" + shopId + "'}}");
		}
		int result = saleLeadsService.distribute(distributorId, saleLeadsId, shopId);
		if (LOG.isDebugEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::distribute',out:"+result+"}");
		}
		return result;
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
		Integer count = 0;
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::get2AcceptCount',in:{storeId:'" + storeId + "'}}");
		}
		try {
			count = saleLeadsService.get2AcceptCount(storeId);
		} catch (Throwable e) {
			LOG.error(e.getMessage(),e);
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::get2AcceptCount',out:"+count+"}");
		}
		return count;
	}

	public int accept(String acceptorId, String saleLeadsId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int edit(SaleLeadsModel model) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
     * 获取导购员已接单的一页销售线索信息
     * @param acceptorId 导购员ID
     * @param startNum 上一次加载的最后项位移
     * @param pageSize 页大小
     * @return 导购员已接单的一页销售线索信息
     */
	public List<SaleLeadsModel> getOnePage4Acceptor2Followup(String acceptorId, Integer startNum, Integer pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePage4Acceptor2Followup',in:{acceptorId:'" + acceptorId + "',startNum:'"
					+ startNum + "',shopId:'" + pageSize + "'}}");
		}
		List<SaleLeadsModel> result = saleLeadsService.getOnePage4Acceptor2Followup(acceptorId, startNum, pageSize);
		if (LOG.isDebugEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePage4Acceptor2Followup',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
	}

	public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId, Integer startNum, Integer pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePage4AcceptorClosed',in:{acceptorId:'" + acceptorId + "',startNum:'"
					+ startNum + "',shopId:'" + pageSize + "'}}");
		}
		List<SaleLeadsModel> result = saleLeadsService.getOnePage4AcceptorClosed(acceptorId, startNum, pageSize);
		if (LOG.isDebugEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePage4AcceptorClosed',out:"+JSON.toJSONString(result)+"}");
		}
		return result;
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
