package com.dpmall.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpmall.db.bean.OrderEntity;

public interface AppOrderDao {
	
	 public Integer get2DistributeCount(@Param("distributorId")String distributorId);
	 
	 public int distribute(String distributorId,String orderCode, String storeId);
	 
	 public List<OrderEntity> getOnePage4Acceptor2Followup(String acceptorId,Integer offset, Integer pageSize);
}
