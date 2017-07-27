package com.dpmall.db.dao;

import java.util.List;

import com.dpmall.db.bean.OrderEntity;

public interface AppOrderDao {
	 public List<OrderEntity> getOnePage4Distribute(String distributorId,Integer offset, Integer pageSize);
}
