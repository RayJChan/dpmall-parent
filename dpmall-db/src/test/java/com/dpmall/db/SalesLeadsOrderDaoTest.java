package com.dpmall.db;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.SalesLeadsOrderEntity;
import com.dpmall.db.dao.SalesLeadsOrderDao;

public class SalesLeadsOrderDaoTest extends SpringTestCase {
	
	 private static final Logger LOG = LoggerFactory.getLogger(SalesLeadsOrderDaoTest.class);
	
	@Autowired
	private SalesLeadsOrderDao salesLeadsOrderDao;
	
	/**
	 * 测试导购员已接单的一页销售线索信息
	 */
	@Test
	public void getOnePage4Acceptor2Followup() {
		for(SalesLeadsOrderEntity salesLeadsOrderEntity: salesLeadsOrderDao.getOnePage4Acceptor2Followup("14", 1, 1) ) {
			LOG.info(JSON.toJSONString(salesLeadsOrderEntity));
			System.out.println(JSON.toJSONString(salesLeadsOrderEntity));
		}
	}
	
	/**
	 * 测试导购员已结单的一页销售线索信息
	 */
	@Test
	public void getOnePage4AcceptorClosed() {
		for(SalesLeadsOrderEntity salesLeadsOrderEntity: salesLeadsOrderDao.getOnePage4AcceptorClosed("14", 1, 1) ) {
			LOG.info(JSON.toJSONString(salesLeadsOrderEntity));
			System.out.println(JSON.toJSONString(salesLeadsOrderEntity));
		}
	}
	
	/**测试分配店铺接口**/
	@Test
	public void distribute() {
		LOG.info("result:"+salesLeadsOrderDao.distribute("1", "2"));
	}
	
	@Test
	public void testGet2AcceptCount() {
		Integer count = salesLeadsOrderDao.get2AcceptCount("13");
		LOG.info("获取店铺待接单的线索数======================"+count);
	}
    @Test
    public void testSearch(){
    	List<SalesLeadsOrderEntity> result = salesLeadsOrderDao.getOnePage4Distribute(Long.parseLong("8"), 0,5);
    	LOG.info(JSON.toJSONString(result));
    }
    @Test
    public void testGetOnePage4Followup(){
    	List<SalesLeadsOrderEntity> result = salesLeadsOrderDao.getOnePage4Followup("8", 0,20);
    	LOG.info(JSON.toJSONString(result));
    }
    @Test
    public void testget2DistributeCount(){
    	Integer result = salesLeadsOrderDao.get2DistributeCount(8);
    	LOG.info(JSON.toJSONString(result));
    }
    @Test
    public void testGetOnePage4Accept(){
    	for(SalesLeadsOrderEntity salesLeadsOrderEntity:salesLeadsOrderDao.getOnePage4Accept("13", 0, 5)){
    		LOG.info(JSON.toJSONString(salesLeadsOrderEntity));
    		System.out.println("店铺获取待接单的销售线索============="+JSON.toJSONString(salesLeadsOrderEntity));
    	}
    }
    /**
     * 测试编辑接口
     * **/
    @Test
    public void eidtTest() {
    	SalesLeadsOrderEntity entity = new SalesLeadsOrderEntity();
    	entity.id=1L;
    	entity.budget=new BigDecimal("20170719");
    	LOG.info("result:"+salesLeadsOrderDao.edit(entity));
    }
    
    /**
     * 测试批量分配店铺接口
     * **/
    @Test
    public void testDistributeBatch() {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("1", "1001");
    	map.put("2", "1002");
    	LOG.info("result:"+salesLeadsOrderDao.distributeBatch(map));
    }
}