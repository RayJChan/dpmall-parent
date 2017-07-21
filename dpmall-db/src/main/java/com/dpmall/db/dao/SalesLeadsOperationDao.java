package com.dpmall.db.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.dpmall.db.bean.SalesLeadsOperationEntity;

@MapperScan
public interface SalesLeadsOperationDao {
	 
	public int insert(@Param(value="template")SalesLeadsOperationEntity template);
}
