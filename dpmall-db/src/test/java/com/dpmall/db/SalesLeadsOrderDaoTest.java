package com.dpmall.db;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.DateUtils;
import com.dpmall.common.SpringTestCase;
import com.dpmall.common.TimeScope;
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
    	LOG.info("===================开始执行daihx====================");
    	List<SalesLeadsOrderEntity> result = salesLeadsOrderDao.getOnePage4Followup("2", 0,20);
    	LOG.info("\n\nresult:"+JSON.toJSONString(result)+"\n\n");
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
    /**测试销售线索接口daihx**/
    @Test
    public void testgetSaleLeads(){
    	SalesLeadsOrderEntity result = salesLeadsOrderDao.getSaleLeads("1");
    	LOG.info("====================开始执行====================");
    	LOG.info("\n\nresult:" +JSON.toJSONString(result)+"\n\n");
    }
    /**
     * 测试编辑接口
     * **/
    @Test
    public void eidtTest() {
    	
    }
    @Test
    public void testGetOnePageClosedSaleLeads() throws ParseException{
    	TimeScope scope = new TimeScope();

    	scope.begin = new Timestamp(DateUtils.parse("2017-07-18 00:00:00", DateUtils.YYYY_MM_DD_HH_MM_SS).getTime());
    	scope.end = new Timestamp(DateUtils.parse("2017-07-20 10:30:00", DateUtils.YYYY_MM_DD_HH_MM_SS).getTime());
    	for(SalesLeadsOrderEntity salesLeadsOrderEntity:salesLeadsOrderDao.getOnePageClosedSaleLeads("1", scope, "13", "1", "22", "1", 0, 5)){
    		LOG.info(JSON.toJSONString(salesLeadsOrderEntity));
    	}
    }
    /**
     * 测试获取根据form条件查询一页的成功结单的数据
     * @param form
     * @param startNum
     * @param pageSize
     * @return
     * @throws ParseException 
     */
    @Test
    public void testGetOnePageSuccessOrders() throws ParseException {
    	Date fromTime = DateUtils.parse("2016-07-20 20:55:00", DateUtils.YYYY_MM_DD_HH_MM_SS);
    	Date toTime = DateUtils.parse("2017-07-20 20:55:00", DateUtils.YYYY_MM_DD_HH_MM_SS);
    	for (SalesLeadsOrderEntity SuccessOrders : salesLeadsOrderDao.getOnePageSuccessOrders(13L,"310146","1111", fromTime, toTime,0,5)) {
    		LOG.info(JSON.toJSONString(SuccessOrders));
		}
    }
    /**
     * 获取根据form条件查询成功结单的金额
     * @param form
     * @return
     */
    @Test
    public void testGetSuccessOrdersTtlAmount() throws ParseException {
    	Date fromTime = DateUtils.parse("2016-07-20 20:55:00", DateUtils.YYYY_MM_DD_HH_MM_SS);
    	Date toTime = DateUtils.parse("2017-07-20 20:55:00", DateUtils.YYYY_MM_DD_HH_MM_SS);
    	Double TtlAmount = salesLeadsOrderDao.getSuccessOrdersTtlAmount(13L,"310146","1111", fromTime, toTime);
    	LOG.info(JSON.toJSONString(TtlAmount));
    }
}