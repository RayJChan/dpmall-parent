package com.dpmall.api;

import java.util.List;

import com.dpmall.api.bean.PrepayModel;
import com.dpmall.api.bean.SaleLeadsGoodsModel;
import com.dpmall.api.common.TimeScope;

/**
 * 特权定金服务接口
 * @author river
 * @since 2017-07-10
 */
public interface IPrepayService {
    
	/**
	 * 核销
	 * @param prepayCode 核销码
	 * @param ttlAmount 核销订单总金额
	 * @param goodsList 订单数据
	 * @return
	 */
	public Integer writeoff(String prepayCode,Double ttlAmount,List<SaleLeadsGoodsModel> goodsList);
	
	
	/**
	 * 获取待核销的一页特权定金
	 * @param storeId 门店ID
	 * @param prepayTime 预付时间
	 * @param clientName 客户名称
	 * @param clientTel 客户电话
	 * @param startNum 开始数
	 * @param pageSize 页码
	 * @return
	 */
	public List<PrepayModel> getOnePage2WriteOff(String storeId,TimeScope prepayTime, String clientName, String clientTel,Integer startNum, Integer pageSize);
	
	/**
	 * 获取待核销的一页特权定金
	 * @param storeId 门店ID
	 * @param prepayTime 预付时间
	 * @param clientName 客户名称
	 * @param clientTel 客户电话
	 * @param startNum 开始数
	 * @param pageSize 页码
	 * @return
	 */
	public List<PrepayModel> getOnePageClosedPrepay(String storeId,TimeScope prepayTime, String clientName, String clientTel,Integer startNum, Integer pageSize);
}
