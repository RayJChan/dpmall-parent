package com.dpmall.datasvr.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SaleLeadsServiceImpl implements ISaleLeadsService {
	
	@Autowired
	private SalesLeadsOrderDao salesLeadsOrderDao;
	
	/**
	 * 把entity转换成model
	 * @param entity 需要转换的entity
	 * @return 转化后的model
	 */
	private SaleLeadsModel entityToModel(SalesLeadsOrderEntity entity) {
		SaleLeadsModel model=new SaleLeadsModel();
		model.appointmentTime=entity.appointmentTime;
		model.budget=entity.budget.doubleValue();
		model.callServiceRemark=entity.callServiceRemark;
		model.callServiceTel=entity.callServiceTel.toString();
		model.clientAddr=entity.clientAddr;
		model.clientName=entity.clientName;
		model.clientTel=entity.clientTel;
		model.closeTime=entity.closeTime;
		model.distributeTime=entity.distributeTime;
		model.distributorId=entity.distributorId;
		model.distributorOperateTime=entity.distributorOperateTime;
		model.distributorUserName=entity.distributorUserName;
		model.id=entity.id;
		model.recommendstoreId=entity.recommendstoreId;
		model.saleLeadsStatus=entity.saleLeadsStatus;
		model.serviceDate=entity.serviceDate;
		model.serviceAddress=entity.serviceAddress;
		model.serviceCatelog=entity.serviceCatelog;
		model.serviceTitle=entity.serviceTitle;
		model.storeAcceptTime=entity.storeAcceptTime;
		model.style=entity.style;
		model.total=entity.total.doubleValue();
		
		return model;
		
	}

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
	
	 /**
     * 获取导购员已接单的一页销售线索信息
     * @param acceptorId 导购员ID
     * @param startNum 上一次加载的最后项位移
     * @param pageSize 页大小
     * @return
     */
	public List<SaleLeadsModel> getOnePage4Acceptor2Followup(String acceptorId, Integer startNum, Integer pageSize) {
		List<SalesLeadsOrderEntity> searchResult = salesLeadsOrderDao.getOnePage4Acceptor2Followup(acceptorId, startNum, pageSize);
		List<SaleLeadsModel> result = new ArrayList<SaleLeadsModel>(searchResult.size());
		for(SalesLeadsOrderEntity entity:searchResult) {
			result.add(entityToModel(entity));
		}
		return result;
	}

	public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}
