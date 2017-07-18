package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.SalesLeadsOrderEntity;

public interface SalesLeadsOrderDao {
	List<SalesLeadsOrderEntity> getOnePage4Acceptor2Followup(@Param("acceptorId")String acceptorId,@Param("startNum")Integer startNum, @Param("pageSize")Integer pageSize);
	
	Integer get2AcceptCount(@Param("storeId")String storeId);
}
