package com.dpmall.db.dao;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.SalesLeadsOrderItemEntity;

public interface SalesLeadsOrderItemDao {
	int insert(@Param("orderItem") SalesLeadsOrderItemEntity orderItem);
}
