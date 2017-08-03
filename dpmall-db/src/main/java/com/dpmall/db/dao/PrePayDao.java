package com.dpmall.db.dao;

import org.apache.ibatis.annotations.Param;

public interface PrePayDao {
	Integer get2DistributeCount(@Param("distributorId")String distributorId,@Param("status")String status);
	
    Integer distribute(@Param("distributorId")String distributorId,@Param("orderCode")String orderCode, @Param("storeId")String storeId);
	
	Integer distributeO2o(@Param("orderCode")String orderCode,@Param("remark")String remark);
}
