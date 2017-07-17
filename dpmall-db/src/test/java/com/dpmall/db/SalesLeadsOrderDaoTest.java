package com.dpmall.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SalesLeadsOrderDaoTest extends SpringTestCase {
	
	@Autowired
	private SalesLeadsOrderDao salesLeadsOrderDao;

	@Test
	public void test() {
		for(SalesLeadsOrderEntity salesLeadsOrderEntity: salesLeadsOrderDao.searchAll() ) {
			System.out.println(salesLeadsOrderEntity.toString());
		}
	}

}
