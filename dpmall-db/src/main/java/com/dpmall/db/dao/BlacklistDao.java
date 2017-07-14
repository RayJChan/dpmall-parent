package com.dpmall.db.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.dpmall.db.bean.BlacklistEntity;

@MapperScan
public interface BlacklistDao {
	List<BlacklistEntity> getByPK(Long pk);
}
