package com.dpmall.datasvr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.param.SaleLeadStatisticForm;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SaleLeadsServiceImpl implements ISaleLeadsService {
	
	private static Logger LOG = LoggerFactory.getLogger(SaleLeadsServiceImpl.class);
	
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
		model.budget=entity.budget==null?null:entity.budget.doubleValue();
		model.callServiceRemark=entity.callServiceRemark;
		model.callServiceTel=entity.callServiceTel;
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
		model.total=entity.total==null?null:entity.total.doubleValue();

		return model;
		
	}
	
	/**
	 * 把model转换成entity
	 * @param entity 需要转换的model
	 * @return 转化后的entity
	 */
	private SalesLeadsOrderEntity modelToEntity(SaleLeadsModel model) {
		SalesLeadsOrderEntity entity=new SalesLeadsOrderEntity();
		entity.budget=model.budget==null?null:new BigDecimal(model.budget);
		entity.callServiceRemark=model.callServiceRemark;
		entity.callServiceTel=model.callServiceTel;
		entity.clientAddr=model.clientAddr;
		entity.clientName=model.clientName;
		entity.clientTel=model.clientTel;
		entity.closeTime=model.closeTime;
		entity.distributeTime=model.distributeTime;
		entity.distributorId=model.distributorId;
		entity.distributorOperateTime=model.distributorOperateTime;
		entity.distributorUserName=model.distributorUserName;
		entity.id=model.id;
		entity.recommendstoreId=model.recommendstoreId;
		entity.saleLeadsStatus=model.saleLeadsStatus;
		entity.serviceDate=model.serviceDate;
		entity.serviceAddress=model.serviceAddress;
		entity.serviceCatelog=model.serviceCatelog;
		entity.serviceTitle=model.serviceTitle;
		entity.storeAcceptTime=model.storeAcceptTime;
		entity.style=model.style;
		entity.total=model.total==null?null:new BigDecimal(model.total);
		return entity;
	}

	public List<SaleLeadsModel> getOnePage4Distribute(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		List<SaleLeadsModel> out = null;

		List<SalesLeadsOrderEntity> outEntityList = salesLeadsOrderDao.getOnePage4Distribute(Long.valueOf(distributorId),startNum,pageSize);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
		
		out = this.entitysaleModel(outEntityList);
		return out;
	}
	
	private List<SaleLeadsModel> entitysaleModel(List<SalesLeadsOrderEntity> in){
		if(in == null || in.isEmpty()){
			return null;
		}
		
		List<SaleLeadsModel> out = new ArrayList<SaleLeadsModel>();
		for(SalesLeadsOrderEntity tmp : in){
			out.add(entityToModel(tmp));
		}
		
		return out;
		
	}

	public Integer get2DistributeCount(String distributorId) {
		// TODO Auto-generated method stub
		Integer result = salesLeadsOrderDao.get2DistributeCount(Integer.valueOf(distributorId));
		return result;
	}

	public int distribute(String distributorId, String saleLeadsId, String shopId) {
		// TODO Auto-generated method stub
		int result = salesLeadsOrderDao.distribute(saleLeadsId, shopId);
		LOG.info("result:"+result);
		return result;
	}

	public int reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * author:daihx
	 * 经销商 待分配 一页 订单数据
	 */
	public List<SaleLeadsModel> getOnePage4Followup(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		List<SaleLeadsModel> out = null;

		List<SalesLeadsOrderEntity> outEntityList = salesLeadsOrderDao.getOnePage4Followup(distributorId, startNum, pageSize);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
		
		out = this.entitysaleModel(outEntityList);
		return out;
	}
	
	public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId, TimeScope distributeTime,
			String storeId, String saleLeadId, String clientName, String clientTel, Integer startNum,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	 /**
		 * 店铺获取待接单的销售线索
		 * @param storeId 店铺ID
		 * @param startNum 上一次加载的最后项位移
		 * @param pageSize 页的大小
		 * @return 店铺获取待接单的销售线索列表
		 */
	public List<SaleLeadsModel> getOnePage4Accept(String storeId, Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> accept = null;
		List<SalesLeadsOrderEntity> acceptEntity = salesLeadsOrderDao.getOnePage4Accept(storeId, startNum, pageSize);
		if(acceptEntity.isEmpty()){
			return null;
		}
		accept = this.entitysaleModel(acceptEntity);
		return accept;
	}

	public Integer get2AcceptCount(String storeId) {
		Integer count = salesLeadsOrderDao.get2AcceptCount(storeId);
		return count;
	}

	public int accept(String acceptorId, String saleLeadsId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * @param model 传入的model
	 * @return 1为更新成功， 0 为失败
	 * **/
	public int edit(SaleLeadsModel model) {
		SalesLeadsOrderEntity entity = modelToEntity(model);
		int result=salesLeadsOrderDao.edit(entity);	
		// TODO Auto-generated method stub
		return result;
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
	
	/**
     * 获取导购员已结单的一页销售线索信息
     * @param acceptorId 导购员ID
     * @param startNum 上一次加载的最后项位移
     * @param pageSize 页大小
     * @return
     */
	public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId, Integer startNum, Integer pageSize) {
		List<SalesLeadsOrderEntity> searchResult = salesLeadsOrderDao.getOnePage4AcceptorClosed(acceptorId, startNum, pageSize);
		List<SaleLeadsModel> result = new ArrayList<SaleLeadsModel>(searchResult.size());
		for(SalesLeadsOrderEntity entity:searchResult) {
			result.add(entityToModel(entity));
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
	
	
	public void setSalesLeadsOrderDao(SalesLeadsOrderDao salesLeadsOrderDao) {
		this.salesLeadsOrderDao = salesLeadsOrderDao;
	}

	/**
	 * author:daihx
	 * 根据sealLeadsId 获取详情
	 * saleLeadsId
	 */
	public SaleLeadsModel getSaleLeads(String saleLeadsId) {
		SaleLeadsModel out = null;

		List<SalesLeadsOrderEntity> outEntityList = salesLeadsOrderDao.getSaleLeads(saleLeadsId);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
		
		out = this.entitysaleModel(outEntityList).get(0);
		return out;
	}
}
