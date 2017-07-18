package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
}
