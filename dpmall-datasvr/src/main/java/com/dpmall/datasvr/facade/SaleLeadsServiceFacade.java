package com.dpmall.datasvr.facade;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.ISaleLeadsService;
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
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::search',in:{distributorId:'" + distributorId +"'}}");
		}
		
		Integer result = saleLeadsService.get2DistributeCount(distributorId);
		return result;
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
	 /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return
     */
	public int reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::reject',in:{saleLeadsId:'" + saleLeadsId + "',rejectType:'"
					+ rejectType + "',rejectRemark:'" + rejectRemark +"'}}");
		}
		
		Integer reject = saleLeadsService.reject(distributorId, saleLeadsId, rejectType, rejectRemark);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::reject',out:"+reject+"}");
		}
		return reject;
	}

	public List<SaleLeadsModel> getOnePage4Followup(String distributorId, Integer startNum, Integer pageSize) {
		// TODO Auto-generated method stub
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::search',in:{distributorId:'" + distributorId + "',startNum:'"
					+ startNum + "',pageSize:'" + pageSize +"'}}");
		}
		
		List<SaleLeadsModel> out = saleLeadsService.getOnePage4Followup(distributorId, startNum, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::search',out:"+JSON.toJSONString(out)+"}");
		}
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
     * @param startNum
     * @param pageSize
     * @return
     */
	public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId, TimeScope distributeTime,
			String storeId, String saleLeadId, String clientName, String clientTel, Integer startNum,
			Integer pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePageClosedSaleLeads',in:{distributorId:'" + distributorId + "',storeId:'" + storeId + "',saleLeadId:'" + saleLeadId + "',sclientName:'" + clientName + "',clientTel:'" + clientTel + "',startNum:'"
					+ startNum + "',pageSize:'" + pageSize +"'}}");
		}
		List<SaleLeadsModel> acceptModel = saleLeadsService.getOnePageClosedSaleLeads(distributorId, distributeTime, storeId, saleLeadId, clientName, clientTel, startNum, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePageClosedSaleLeads',out:"+JSON.toJSONString(acceptModel)+"}");
		}
		return acceptModel;
	}
	 /**
		 * 店铺获取待接单的销售线索
		 * @param storeId 店铺ID
		 * @param startNum 上一次加载的最后项位移
		 * @param pageSize 页的大小
		 * @return 店铺获取待接单的销售线索列表
		 */
	public List<SaleLeadsModel> getOnePage4Accept(String storeId, Integer startNum, Integer pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePage4Accept',in:{storeId:'" + storeId + "',startNum:'"
					+ startNum + "',pageSize:'" + pageSize +"'}}");
		}
		List<SaleLeadsModel> acceptModel = saleLeadsService.getOnePage4Accept(storeId, startNum, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::getOnePage4Accept',out:"+JSON.toJSONString(acceptModel)+"}");
		}
		return acceptModel;
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

	/**
	 * author:daihx
	 * accept方法
	 * saleLeadsId
	 */
	public int accept(String acceptorId, String saleLeadsId) {
		// TODO Auto-generated method stub
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'accept',in:{acceptorId:'" + acceptorId  +"'}}");
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'::accept',out:{acceptorId:'" + acceptorId  +"'}}");
		}
		int result = saleLeadsService.accept(acceptorId, saleLeadsId);
		
		return result;
	}
	
	/**
	 * @param model 传入的model
	 * @return 1为更新成功， 0 为失败
	 * **/
	public int edit(SaleLeadsModel model) {
		int result=0;
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::edit',in:{model:'" + JSON.toJSONString(model) + "'}}");
		}
		try {
			result = saleLeadsService.edit(model);
		} catch (Throwable e) {
			LOG.error(e.getMessage(),e);
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::edit',out:"+result+"}");
		}
		return result;
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
	
	/**
     * 经销商批量分配店铺
     * @param distributorId 经销商ID
     * @param saleLeadsId2shopId 经销商ID=>shopId
     * @return 分配的店铺数
     */
	public int distributeBatch(String distributorId, Map<String, String> saleLeadsId2shopId) {
		int result=0;
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::distributeBatch',in:{distributorId:'" + distributorId + "',saleLeadsId2shopId:'"
					+ JSON.toJSONString(saleLeadsId2shopId) +"}}");
		}
		result=saleLeadsService.distributeBatch(distributorId, saleLeadsId2shopId);
		if (LOG.isDebugEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::distributeBatch',out:"+JSON.toJSONString(result)+"}");
		}
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
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::reject',in:{saleLeadsIdList:'" + saleLeadsIdList + "',rejectType:'"
					+ rejectType + "',rejectRemark:'" + rejectRemark +"'}}");
		}
		Integer temp = 1;
		for (String saleLeadsId : saleLeadsIdList) {
			Integer result = saleLeadsService.reject(distributorId, saleLeadsId, rejectType, rejectRemark);
			if(result!=1){
				temp=0;
			}
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::reject',out:"+temp+"}");
		}
		return temp;
	}

	public int acceptBatch(String acceptorId, List<String> saleLeadsId) {
		// TODO Auto-generated method stub
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'accept',in:{acceptorId:'" + acceptorId  +"'}}");
		}
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'::accept',out:{saleLeadsId:'" + saleLeadsId  +"'}}");
		}
		int result = saleLeadsService.acceptBatch(acceptorId, saleLeadsId);
		
		return result;
	}

	/**
	 * author:daihx
	 * 根据sealLeadsId 获取详情
	 * saleLeadsId
	 */
	public SaleLeadsModel getSaleLeads(String saleLeadsId) {
		// TODO Auto-generated method stub
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade:getSaleLeads',in:{saleLeadsId:'" + saleLeadsId  +"'}}");
		}
		SaleLeadsModel acceptModel = saleLeadsService.getSaleLeads(saleLeadsId);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::getSaleLeads',out:"+JSON.toJSONString(acceptModel)+"}");
		}
		return acceptModel;
	}
	
}
