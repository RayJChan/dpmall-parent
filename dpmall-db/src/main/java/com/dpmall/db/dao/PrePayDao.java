package com.dpmall.db.dao;

import org.apache.ibatis.annotations.Param;

public interface PrePayDao {
	Integer get2DistributeCount(@Param("distributorId")String distributorId,@Param("status")String status);
	
    Integer distribute(@Param("distributorId")String distributorId,@Param("orderCode")String orderCode, @Param("storeId")String storeId);
	
	Integer distributeO2o(@Param("orderCode")String orderCode,@Param("remark")String remark);
	
	Integer get2AcceptorCount(@Param("acceptorId")String acceptorId, @Param("status")String status);

    Integer get2StoreCount(@Param("storeId")String storeId,@Param("status")String status);
}
