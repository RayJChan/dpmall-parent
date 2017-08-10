package com.dpmall.datasvr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dpmall.api.IPrepayService;
import com.dpmall.api.bean.PrepayModel;
import com.dpmall.api.bean.SaleLeadsGoodsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.db.bean.PrePayEntity;
import com.dpmall.db.bean.PrePayItemEntity;
import com.dpmall.db.dao.PrePayDao;

/**
 * 特权定金实现
 * @author river
 * @date 2017-07-14
 */
public class PrepayServiceImpl implements IPrepayService {
	
	@Autowired
	private PrePayDao prePayDao;
	
	private PrePayEntity modelToEntity(PrepayModel model) {
		PrePayEntity entity=new PrePayEntity();
		entity.clientName=model.clientName;
		entity.clientTel=model.clientTel;
		
		entity.allocatCode=model.allocatCode;
		entity.shippingAddress=model.shippingAddress;
		entity.buyerNick=model.buyerNick;
		entity.productQuantity=model.productQuantity;;
		entity.productBaseprice=model.productBaseprice;
		entity.productTotal=model.productTotal;
		entity.phone1=model.phone1;
		entity.firstName=model.firstName;
		entity.address=model.address;
		entity.orderTotal=model.orderTotal;
		entity.status=model.status;
		entity.id=model.id;
		entity.consignmentCode=model.consignmentCode;
		entity.logisticsInfo=model.logisticsInfo;
		entity.trackingId=model.trackingId;
		entity.deliveryCost=model.deliveryCost;
		entity.salesApplication=model.salesApplication;
		entity.juntanPrice=model.juntanPrice;
		entity.payAmount=model.payAmount;
		entity.serviceAmount=model.serviceAmount;
		entity.deliveryMethods=model.deliveryMethods;
		entity.operateStatus=model.operateStatus;
		entity.name=model.name;
		entity.acceptedBy=model.acceptedBy;
		entity.acceptedComment=model.acceptedComment;
		entity.agencyComment=model.agencyComment;
		entity.cusComment=model.cusComment;
		entity.deliverPic=model.deliverPic;
		entity.deliveryMode=model.deliveryMode;
		entity.logisticsCompany=model.logisticsCompany;
		entity.serverComment=model.serverComment;
		entity.deliveryPoint=model.deliveryPointOfService;
		entity.returnStatus=model.returnStatus;
		entity.RegionName=model.RegionName;
		entity.CityName=model.CityName;
		entity.DistrictName=model.DistrictName;
		entity.deliveryRemark=model.deliveryRemark;
		entity.cusRefuseComment=model.cusRefuseComment;
		entity.acceptedRefuseComment=model.acceptedRefuseComment;
		entity.discountPrice=model.discountPrice;
		entity.writeoffCode=model.writeoffCode;
		entity.limitedTime = model.limitedTime;
		for(Object obj:model.items) {
			entity.items.add((PrePayItemEntity) obj);
		}
		return entity;
	}
	
	private PrepayModel entityToModel(PrePayEntity entity) {
		PrepayModel model=new PrepayModel();
		model.allocatCode=entity.allocatCode;
		model.shippingAddress=entity.shippingAddress;
		model.buyerNick=entity.buyerNick;
		model.productQuantity=entity.productQuantity;;
		model.productBaseprice=entity.productBaseprice;
		model.productTotal=entity.productTotal;
		model.phone1=entity.phone1;
		model.firstName=entity.firstName;
		model.address=entity.address;
		model.status=entity.status;
		model.deliveryPointOfService=entity.deliveryPoint;
		model.id = entity.id;
		model.consignmentCode=entity.consignmentCode;
		model.logisticsInfo=entity.logisticsInfo;
		model.trackingId=entity.trackingId;
		model.deliveryCost=entity.deliveryCost;
		model.salesApplication=entity.salesApplication;
		model.juntanPrice=entity.juntanPrice;
		model.payAmount=entity.payAmount;
		model.serviceAmount=entity.serviceAmount;
		model.deliveryMethods=entity.deliveryMethods;
		model.operateStatus=entity.operateStatus;
		model.name=entity.name;
		model.acceptedBy=entity.acceptedBy;
		model.acceptedComment=entity.acceptedComment;
		model.agencyComment=entity.agencyComment;
		model.cusComment=entity.cusComment;
		model.deliverPic=entity.deliverPic;
		model.deliveryMode=entity.deliveryMode;
		model.logisticsCompany=entity.logisticsCompany;
		model.serverComment=entity.serverComment;
		model.returnStatus=entity.returnStatus;
		model.RegionName=entity.RegionName;
		model.CityName=entity.CityName;
		model.DistrictName=entity.DistrictName;
		model.deliveryRemark=entity.deliveryRemark;
		model.cusRefuseComment=entity.cusRefuseComment;
		model.acceptedRefuseComment=entity.acceptedRefuseComment;
		entity.discountPrice=model.discountPrice;
		entity.writeoffCode=model.writeoffCode;
		model.limitedTime = entity.limitedTime;
		for (PrePayItemEntity item:entity.items) {
			model.orderTotal=model.orderTotal.add(item.deliveryCost==null?BigDecimal.ZERO:item.deliveryCost).add(item.payAmount==null?BigDecimal.ZERO:item.payAmount).add(item.serviceAmount==null?BigDecimal.ZERO:item.serviceAmount);
			model.items.add(item);
		}
		return model;
	}

	
	private List<PrepayModel> entitysaleModel(List<PrePayEntity> in){
		if(in == null || in.isEmpty()){
			return null;
		}
		
		List<PrepayModel> out = new ArrayList<PrepayModel>();
		for(PrePayEntity tmp : in){
			out.add(entityToModel(tmp));
		}
		
		return out;
		
	}
	
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

	public List<PrepayModel> getOnePage4Distribute(String distributorId, String status, String search,Integer offset,
			Integer pageSize) {
		
			List<PrePayEntity> entities = prePayDao.getOnePage4Distribute(distributorId, status,search, offset, pageSize);
			if (entities.isEmpty() || entities == null) {
				return null;
			}
			List<PrepayModel> models = new ArrayList<PrepayModel>(entities.size());
			models = this.entitysaleModel(entities);
		return models;
	}

	public Integer get2DistributeCount(String distributorId, String status) {
		
		return prePayDao.get2DistributeCount(distributorId, status);
	}

	public List<PrepayModel> getOnePage4StoreId(String storeId, String status, String search, Integer offset, Integer pageSize) {
		List<PrePayEntity> entities = prePayDao.getOnePage4StoreId(storeId, status,search, offset, pageSize);
		if (entities.isEmpty() || entities == null) {
			return null;
		}
		List<PrepayModel> models = new ArrayList<PrepayModel>(entities.size());
		models = this.entitysaleModel(entities);
	return models;
	}

	public Integer get2StoreCount(String storeId, String status) {
		// TODO Auto-generated method stub
		return prePayDao.get2StoreCount(storeId, status);
	}

	public List<PrepayModel> getOnePage4AcceptorId(String acceptorId, String status, String search, Integer startNum, Integer pageSize) {
		List<PrepayModel> out = null;

		List<PrePayEntity> outEntityList = prePayDao.getOnePage4AcceptorId(acceptorId,status,search,startNum,pageSize);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
								
		out = this.entitysaleModel(outEntityList);
		return out;
	}

	public Integer get2AcceptorCount(String acceptorId, String status) {
		// TODO Auto-generated method stub
		int result = prePayDao.get2AcceptorCount(acceptorId, status);
		return result;
	}
	
	/**
     * 特权定金获取单据明细
     * @param consignmentId 发货单ID
     * @return 特权定金获取单据明细
     */
	public PrepayModel get4ConsignmentId(String consignmentId) {
		PrepayModel out = null;

		PrePayEntity outEntityList = prePayDao.get4ConsignmentId(consignmentId);
				
		out = this.entityToModel(outEntityList);
		return out;
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
	
	@Transactional
	public Integer updateOrder(String orderCode, String status, String remark){
		Integer result =prePayDao.updateO2oOrder(orderCode, remark);
		Integer result2=prePayDao.updateOrder(orderCode, status);
		return result+result2;
	}

	public List<PrepayModel> get4Search(String phone, String storeId, String acceptorId) {
		List<PrepayModel> out = null;

		List<PrePayEntity> outEntityList = prePayDao.get4Search(phone, storeId, acceptorId);
		if(outEntityList == null || outEntityList.isEmpty()){
			return null;
		}
								
		out = this.entitysaleModel(outEntityList);
		return out;
	}

	public List<PrepayModel> getReason4Order(String orderStyle) {
		// TODO Auto-generated method stub
		return null;
	}

}
