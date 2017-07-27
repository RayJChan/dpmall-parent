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
	 * author: crown
	 * 根据经销商ID查询待分配销售线索
	 * @param template
	 * @param page
	 * @return
	 */
   public List<OrderEntity> getOnePage4Distribute(@Param(value="distributorId")String distributorId,@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
   
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
   
}
