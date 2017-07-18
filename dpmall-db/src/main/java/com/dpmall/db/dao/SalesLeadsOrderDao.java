package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.SalesLeadsOrderEntity;

public interface SalesLeadsOrderDao {
	List<SalesLeadsOrderEntity> getOnePage4Acceptor2Followup(@Param("acceptorId")Long acceptorId,@Param("startItemId")Long startItemId, @Param("pageSize")Integer pageSize);
	
}
