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

	public List<SaleLeadsModel> getOnePage4Distribute(String distributorId, String startItemId, Integer pageSize) {
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

	public List<SaleLeadsModel> getOnePage4Followup(String distributorId, String startItemId, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId, TimeScope distributeTime,
			String storeId, String saleLeadId, String clientName, String clientTel, Integer startNum,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SaleLeadsModel> getOnePage4Accept(String storeId, String startItemId, Integer pageSize) {
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

	public List<SaleLeadsModel> getOnePage4Acceptor2Followup(String acceptorId, String startItemId, Integer pageSize) {
		List<SalesLeadsOrderEntity> in= salesLeadsOrderDao.getOnePage4Acceptor2Followup(StringUtils.isEmpty(acceptorId)?null:Long.parseLong(acceptorId), StringUtils.isEmpty(acceptorId)?null:Long.parseLong(startItemId), pageSize);
		List<SaleLeadsModel> out = new ArrayList<SaleLeadsModel>(in.size());
		return null;
	}

	public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId, String startItemId, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<SaleLeadsModel> facede(List<SalesLeadsOrderEntity> in,List<SaleLeadsModel> out){
		for(SalesLeadsOrderEntity entity: in) {
			
		}
		return out;
	}
	
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
		
		
		
	}
}
