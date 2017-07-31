package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.OrderEntity;

public interface AppOrderDao {
	
	 public Integer get2DistributeCount(@Param("distributorId")String distributorId);
	 
	 public int distribute(@Param("orderCode")String orderCode, @Param("storeId")String storeId);
	 
	 public List<OrderEntity> getOnePage4Acceptor2Followup(String acceptorId,Integer offset, Integer pageSize);
	 
	 /**
	  * 获取店铺待接单的实物订单数
	  * @param storeId 经销商ID
	  * @return 经销商待分配的实物订单数
	 */
	public Integer get2AcceptCount(@Param("storeId")String storeId);
	
	/**
	 * 实物类经销商订单状态列表
	 * @param distributorId 经销商Id
	 * @param status 状态
	 * @param offset 上一次加载的最后项offset
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的实物订单列表
	 */
	 public List<OrderEntity> getOnePage4Distribute(@Param("distributorId")String distributorId,@Param("status")String status,@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
   
   /**
	 * author: crown
	 * 根据经销商ID查询待跟进一页的实物订单数据
	 * @param template
	 * @param page
	 * @return
	 */
  public List<OrderEntity> getOnePage4Followup(@Param(value="distributorId")String distributorId,@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
  
  /**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param offset 上一次加载的位移
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
  public List<OrderEntity> getOnePage4Accept(@Param(value="storeId")String storeId,@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
  
  /**
   * author:crown
   * 导购员接单
   * @param acceptorId 导购员ID
   * @param orderCode 订单编码
   * @return 成功返回200
   */
  public int accept(@Param(value="acceptorId")String acceptorId, @Param("orderCode")String orderCode, @Param("acceptComment")String acceptComment);
   
  
  /**
	 * author : cwj 
	 * 编辑实物订单信息
	 * @param entity
	 * @return 1为成功，0为失败
	 */
	int edit (@Param("entity") OrderEntity entity);

	/**
	 * author : cwj 
	 * 确认发货，更新B2C发货单模型发货状态
	 * @param entity
	 * @return 1为成功，0为失败
	 */
	int deliver4Consignments (@Param("entity") OrderEntity entity);
	
  
}
