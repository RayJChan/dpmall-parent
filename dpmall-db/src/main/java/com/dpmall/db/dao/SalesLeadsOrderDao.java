package com.dpmall.db.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dpmall.common.TimeScope;
import com.dpmall.db.bean.SalesLeadsOrderEntity;

public interface SalesLeadsOrderDao {
	 /**
	 * 获取导购员已结单的一页销售线索信息
	 * @param acceptorId 导购员ID
	 * @param startNum 上一次加载的最后项位移
	 * @param pageSize 页大小
	 * @return
	 */
	List<SalesLeadsOrderEntity> getOnePage4AcceptorClosed(@Param("acceptorId")String acceptorId,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
	
	/**
	 * 获取导购员已接单的一页销售线索信息
	 * @param acceptorId 导购员ID
	 * @param startNum 上一次加载的最后项位移
	 * @param pageSize 页大小
	 * @return
	 */
	List<SalesLeadsOrderEntity> getOnePage4Acceptor2Followup(@Param("acceptorId")String acceptorId,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
	
	int distribute(@Param("saleLeadsId")String saleLeadsId, @Param("shopId")String shopId);
	
	Integer get2AcceptCount(@Param("storeId")String storeId);
	
	/**
	 * <p>
	 * 根据经销商ID查询待分配销售线索
	 * @param template
	 * @param page
	 * @return
	 */
    public List<SalesLeadsOrderEntity> getOnePage4Distribute(@Param(value="agency")Long agency,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
    
    /**
	 * <p>
	 * 根据经销商获取待跟进的一页线索订单数据
	 * @param template
	 * @param page
	 * @return
	 */
    List<SalesLeadsOrderEntity> getOnePage4Followup(@Param(value="distributorId")String distributorId,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
    
    /**
     * 获取经销商待分配的线索数
     * @param distributorId 经销商ID
     * @return 经销商待分配的线索数
     */
    Integer get2DistributeCount(@Param(value="distributorId")int distributorId);
    
    /**
	 * <p>
	 * 根据sealLeadsId 获取详情
	 * author daihx
	 * @param saleLeadsId
	 * @return
	 */
    SalesLeadsOrderEntity getSaleLeads(@Param(value="saleLeadsId")String saleLeadsId);
    
    /**
	 * 店铺获取待接单的销售线索
	 * @param storeId 店铺ID
	 * @param startNum 上一次加载的最后项位移
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的销售线索列表
	 */
    public List<SalesLeadsOrderEntity> getOnePage4Accept(@Param("storeId")String storeId,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
    
    /**
     * 编辑销售线索订单信息
     * @param entity
     * @return 1为成功，0为失败
     */
     int edit(@Param("entity")SalesLeadsOrderEntity entity);
     
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
     public List<SalesLeadsOrderEntity> getOnePageClosedSaleLeads(@Param("distributorId")String distributorId,@Param("distributeTime")TimeScope distributeTime,@Param("storeId") String storeId,@Param("saleLeadId")String saleLeadId,@Param("clientName") String clientName,@Param("clientTel")String clientTel,@Param("storeName")String storeName,@Param("acceptorId")String acceptorId,@Param("startNum")Integer startNum,@Param("pageSize") Integer pageSize);
     
     /**
      * 获取根据form条件查询一页的成功结单的数据
      * @param form
      * @param startNum
      * @param pageSize
      * @return
      */
     public List<SalesLeadsOrderEntity> getOnePageSuccessOrders(@Param("storeId")Long storeId,@Param("acceptorName")String acceptorName,@Param("productCatelog")String productCatelog,@Param("fromTime")Date fromTime,@Param("toTime")Date toTime,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
     /**
      * 获取根据form条件查询成功结单的金额
      * @param form
      * @return
      */
     public Double getSuccessOrdersTtlAmount(@Param("storeId")Long storeId,@Param("acceptorName")String acceptorName,@Param("productCatelog")String productCatelog,@Param("fromTime")Date fromTime,@Param("toTime")Date toTime);

}
