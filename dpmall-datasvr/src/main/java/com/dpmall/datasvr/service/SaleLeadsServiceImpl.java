package com.dpmall.datasvr.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.param.SaleLeadStatisticParam;
import com.dpmall.common.DateUtils;
import com.dpmall.db.bean.SalesLeadsOperationEntity;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
import com.dpmall.db.dao.SalesLeadsOperationDao;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SaleLeadsServiceImpl implements ISaleLeadsService {
	
	private static Logger LOG = LoggerFactory.getLogger(SaleLeadsServiceImpl.class);
	
	@Autowired
	private SalesLeadsOrderDao salesLeadsOrderDao;
	
	@Autowired
	private SalesLeadsOperationDao salesLeadsOperationDao;
	/**
	 * 把entity转换成model
	 * @param entity 需要转换的entity
	 * @return 转化后的model
	 */
	private SaleLeadsModel entityToModel(SalesLeadsOrderEntity entity) {
		SaleLeadsModel model=new SaleLeadsModel();
		model.appointmentTime=entity.appointmentTime == null?null:DateUtils.format(entity.appointmentTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		model.budget=entity.budget==null?null:entity.budget.doubleValue();
		model.callServiceRemark=entity.callServiceRemark;
		model.callServiceTel=entity.callServiceTel;
		model.clientAddr=entity.clientAddr;
		model.clientName=entity.clientName;
		model.clientTel=entity.clientTel;
		model.closeTime=entity.closeTime==null?null:DateUtils.format(entity.closeTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		model.distributeTime=entity.distributeTime==null?null:DateUtils.format(entity.distributeTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		model.distributorId=entity.distributorId;
		model.distributorOperateTime=entity.distributorOperateTime==null?null:DateUtils.format(entity.distributorOperateTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		model.distributorUserName=entity.distributorUserName;
		model.id=entity.id;
		model.recommendstoreId=entity.recommendstoreId;
		model.recommendstoreName=entity.recommendstoreName;
		model.saleLeadsStatus=entity.saleLeadsStatus;
		model.serviceDate=entity.serviceDate==null?null:DateUtils.format(entity.serviceDate, DateUtils.YYYY_MM_DD_HH_MM_SS);
		model.serviceAddress=entity.serviceAddress;
		model.serviceCatelog=entity.serviceCatelog;
		model.serviceTitle=entity.serviceTitle;
		model.storeAcceptTime=entity.storeAcceptTime==null?null:DateUtils.format(entity.storeAcceptTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		model.style=entity.style;
		model.total=entity.total==null?null:entity.total.doubleValue();
		model.orderCode=entity.orderCode;
		model.acceptStore=entity.acceptStore;
		model.storeAcceptorRemark=entity.storeAcceptorRemark;
		model.agencyRemark=entity.agencyRemark;
		model.storeAcceptor=entity.storeAcceptor;
		model.brand=entity.brand;
		return model;
		
	}
	
	/**
	 * 把model转换成entity
	 * @param entity 需要转换的model
	 * @return 转化后的entity
	 * @throws ParseException 
	 */
	private SalesLeadsOrderEntity modelToEntity(SaleLeadsModel model) throws ParseException {
		SalesLeadsOrderEntity entity=new SalesLeadsOrderEntity();
		entity.budget=model.budget==null?null:new BigDecimal(model.budget);
		entity.callServiceRemark=model.callServiceRemark;
		entity.callServiceTel=model.callServiceTel;
		entity.clientAddr=model.clientAddr;
		entity.clientName=model.clientName;
		entity.clientTel=model.clientTel;
		entity.closeTime=model.closeTime == null ? null : DateUtils.parse(model.closeTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		entity.distributeTime=model.distributeTime == null ? null : DateUtils.parse(model.distributeTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		entity.distributorId=model.distributorId;
		entity.distributorOperateTime=model.distributorOperateTime == null ? null : DateUtils.parse(model.distributorOperateTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		entity.distributorUserName=model.distributorUserName;
		entity.id=model.id;
		entity.recommendstoreName=model.recommendstoreName;
		entity.recommendstoreId=model.recommendstoreId;
		entity.saleLeadsStatus=model.saleLeadsStatus;
		entity.serviceDate=model.serviceDate == null ? null : DateUtils.parse(model.serviceDate, DateUtils.YYYY_MM_DD_HH_MM_SS);
		entity.serviceAddress=model.serviceAddress;
		entity.serviceCatelog=model.serviceCatelog;
		entity.serviceTitle=model.serviceTitle;
		entity.storeAcceptTime=model.storeAcceptTime == null ? null : DateUtils.parse(model.storeAcceptTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		entity.style=model.style;
		entity.total=model.total==null?null:new BigDecimal(model.total);
		entity.orderCode=model.orderCode;
		entity.acceptStore=model.acceptStore;
		entity.storeAcceptorRemark=model.storeAcceptorRemark;
		entity.agencyRemark=model.agencyRemark;
		entity.storeAcceptor=model.storeAcceptor;
		entity.brand=model.brand;
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
	 /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return
     */
	public int reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark) {
		Date date = new Date();
		SalesLeadsOrderEntity entity = new SalesLeadsOrderEntity();
		entity.id = Long.valueOf(saleLeadsId);
		entity.refuseTime = date;
		entity.distributorOperateTime = date;
		entity.rejectType = Integer.valueOf(rejectType);
		entity.rejectRemark=rejectRemark;
		entity.saleLeadsStatus="5";
		return salesLeadsOrderDao.edit(entity);
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
	/**
     * 根据条件查询已完结的销售线索订单
     * @param distributorId 经销商Id
     * @param distributeTime 订单下派时间
     * @param storeId
     * @param saleLeadId
     * @param clientName
     * @param clientTel
     * @param storeName
     * @param acceptorId
     * @param startNum
     * @param pageSize
     * @return
     */
	public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId,TimeScope distributeTime, String storeId,String saleLeadId, String clientName,String clientTel,String storeName,String acceptorId,Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> accept = null;
		com.dpmall.common.TimeScope scopeInternal = new com.dpmall.common.TimeScope();
		scopeInternal.begin = (Timestamp) distributeTime.begin;
		scopeInternal.end = (Timestamp) distributeTime.end;
		List<SalesLeadsOrderEntity> acceptEntity = salesLeadsOrderDao.getOnePageClosedSaleLeads(distributorId, scopeInternal, storeId, saleLeadId, clientName, clientTel, storeName, acceptorId,startNum, pageSize);
		if(acceptEntity.isEmpty()){
			return null;
		}
		accept = this.entitysaleModel(acceptEntity);
		return accept;
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

	/**
	 * author:daihx
	 * accept方法
	 * saleLeadsId
	 */
	public int accept(String acceptorId, String saleLeadsId) {

		SalesLeadsOrderEntity outEntityList = salesLeadsOrderDao.getSaleLeads(saleLeadsId);
		
		outEntityList.saleLeadsStatus = "15";
		outEntityList.storeAcceptTime = new Date();
		outEntityList.storeAcceptor = acceptorId;
		int result=salesLeadsOrderDao.edit(outEntityList);

		return result;
	}
	
	/**
	 * @param model 传入的model
	 * @return 1为更新成功， 0 为失败
	 * **/
	public int edit(SaleLeadsModel model) {
		SalesLeadsOrderEntity entity = null;
		try {
			entity = modelToEntity(model);
		} catch (ParseException e) {
			LOG.error(e.getMessage(),e);
		}
		SalesLeadsOperationEntity operationEntity = new SalesLeadsOperationEntity();
		operationEntity.operatorDesc="编辑SaleLeads订单";
		operationEntity.operatorType="edit";
		operationEntity.salesLeadsOrder=String.valueOf(model.id);
		operationEntity.operatorBy="1111";
		salesLeadsOperationDao.insert(operationEntity);
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
	/**
     * 获取根据form条件查询一页的成功结单的数据
     * @param form
     * @param startNum
     * @param pageSize
     * @return
     * @throws ParseException 
     */
	public List<SaleLeadsModel> getOnePageSuccessOrders(SaleLeadStatisticParam form, Integer startNum,
			Integer pageSize) {
		Long storeId = form.storeId;
		String acceptorName = form.acceptorName;
		String productCatelog = form.productCatelog;
		Date fromTime = null;
		try {
			if(form.fromTime!=null){
				fromTime = DateUtils.parse(form.fromTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date toTime = null;
		try {
			if(form.toTime!=null){
				toTime = DateUtils.parse(form.toTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<SalesLeadsOrderEntity> successOrders =salesLeadsOrderDao.getOnePageSuccessOrders(storeId, acceptorName, productCatelog, fromTime, toTime, startNum, pageSize);
		List<SaleLeadsModel> result = new ArrayList<SaleLeadsModel>(successOrders.size());
		for(SalesLeadsOrderEntity entity:successOrders) {
			result.add(entityToModel(entity));
		}
		return result;
	}
	/**
     * 获取根据form条件查询成功结单的金额
     * @param form
     * @return
     */
	public Double getSuccessOrdersTtlAmount(SaleLeadStatisticParam form) {
		Long storeId = form.storeId;
		String acceptorName = form.acceptorName;
		String productCatelog = form.productCatelog;
		Date fromTime = null;
		try {
			fromTime = DateUtils.parse(form.fromTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date toTime = null;
		try {
			toTime = DateUtils.parse(form.toTime, DateUtils.YYYY_MM_DD_HH_MM_SS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double result = salesLeadsOrderDao.getSuccessOrdersTtlAmount(storeId, acceptorName, productCatelog, fromTime, toTime);
		return result;
	}
	
	/**
     * 经销商批量分配店铺
     * @param distributorId 经销商ID
     * @param saleLeadsId2shopId 经销商ID=>shopId
     * @return 分配的店铺数
     */
	public int distributeBatch(String distributorId, Map<String, String> saleLeadsId2shopId) {
		int result=0;
		for(Entry<String, String> entity : saleLeadsId2shopId.entrySet()) {
			salesLeadsOrderDao.distribute(entity.getKey(), entity.getValue());
			SalesLeadsOperationEntity operationEntity=new SalesLeadsOperationEntity();
			operationEntity.operatorDesc="经销商分配店铺";
			operationEntity.salesLeadsOrder=entity.getKey();
			operationEntity.operatorType="distributeBatch";
			operationEntity.operatorBy="1111";
			//todo
			salesLeadsOperationDao.insert(operationEntity);
			result++;
		}
		// TODO Auto-generated method stub
		return result;
	}
	
	/**
     * 经销商批量拒单
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return
     */
	public int rejectBatch(String distributorId, List<String> saleLeadsIdList, String rejectType, String rejectRemark) {
		Integer temp = 1;
		for (String saleLeadsId : saleLeadsIdList) {
			Date date = new Date();
			SalesLeadsOrderEntity entity = new SalesLeadsOrderEntity();
			entity.id = Long.valueOf(saleLeadsId);
			entity.refuseTime = date;
			entity.distributorOperateTime = date;
			entity.rejectType = Integer.valueOf(rejectType);
			entity.rejectRemark=rejectRemark;
			entity.saleLeadsStatus="5";
			Integer result = salesLeadsOrderDao.edit(entity);
			LOG.info(result.toString());
			if(result!=1){
				temp=0;
			}
		}
		return temp;
	}

	/**
	 * author:daihx
	 * 导购员批量接单
	 * saleLeadsId
	 */
	public int acceptBatch(String acceptorId, List<String> saleLeadsId) {

		Boolean a = true;
		int b = 0;
		//先for循环拿每一条去改状态，得到每一条的结果返回值
		
		for(String id : saleLeadsId){
			SalesLeadsOrderEntity outEntityList = salesLeadsOrderDao.getSaleLeads(id);
			outEntityList.saleLeadsStatus = "15";
			outEntityList.storeAcceptTime = new Date();
			outEntityList.storeAcceptor = acceptorId;
			int result=salesLeadsOrderDao.edit(outEntityList);
			if(result==0){
				a = false;
				break;
			}
		}
		if(a){
			 b = 1;
		}else{
			 b = 0;
		}

		return b;
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

		SalesLeadsOrderEntity outEntityList = salesLeadsOrderDao.getSaleLeads(saleLeadsId);
		if(outEntityList == null){
			return null;
		}
		
		out = this.entityToModel(outEntityList);
		return out;
	}
}
