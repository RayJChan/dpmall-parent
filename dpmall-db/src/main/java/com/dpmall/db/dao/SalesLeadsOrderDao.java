package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.SalesLeadsOrderEntity;

public interface SalesLeadsOrderDao {
	List<SalesLeadsOrderEntity> getOnePage4Acceptor2Followup(@Param("acceptorId")String acceptorId,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
	
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
