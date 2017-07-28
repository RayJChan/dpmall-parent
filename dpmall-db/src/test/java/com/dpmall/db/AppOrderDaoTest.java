package com.dpmall.db;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.OrderEntity;
import com.dpmall.db.dao.AppOrderDao;

public class AppOrderDaoTest extends SpringTestCase{
	
	private final Logger logger=LoggerFactory.getLogger(AppOrderDaoTest.class); 
	
	@Autowired
	private AppOrderDao appOrderDao;

	@Test
	public void getOnePage4DistributeTest() {
		logger.info(JSON.toJSONString(appOrderDao.get2DistributeCount("8796294532666")));
	}
	
	@Test
	public void testGet2AcceptCount() {
		logger.info("获取店铺待接单的实物订单数:"+appOrderDao.get2AcceptCount("10086"));
	}
	
	@Test
	public void distributeTest() {
		logger.info("result:"+JSON.toJSONString(appOrderDao.distribute("1", "10086")));
	}
	
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Distribute(){
		logger.info("=====================crown=========================");
    	List<OrderEntity> result = appOrderDao.getOnePage4Distribute("310145", 0,5);
    	logger.info(JSON.toJSONString(result));
    }
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Followup(){
		logger.info("=====================crown==123=======================");
    	List<OrderEntity> result = appOrderDao.getOnePage4Followup("310145", 0,20);
    	logger.info(JSON.toJSONString(result));
    }
	
	/**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param offset 上一次加载的位移
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
	@Test
    public void testGetOnePage4Accept(){
		logger.info("=====================getOnePage4Accept=======================");
    	List<OrderEntity> result = appOrderDao.getOnePage4Accept("10086", 0,20);
    	logger.info(JSON.toJSONString(result));
    }
	
	/**
	 * 编辑实物订单信息
	 * @param entity
	 * @return 1为成功，0为失败
	 */
	@Test 
	public void testEdit() {
		logger.info("=====================edit=======================");
		OrderEntity  entity = new OrderEntity();
		Date date = new Date();
		entity.status = "33";
		entity.orderCode = "aSIT100020032";
		entity.deliveryTime = date;
		System.out.println(entity.toString());
		int count = appOrderDao.edit(entity);
		System.out.println(count +"======testEdit======");
		logger.info(Integer.toString(count));
	}
	
	/**
	 * author : cwj 
	 * 确认发货，更新B2C发货单模型发货状态
	 * @param entity
	 * @return 1为成功，0为失败
	 */	
	@Test
	public void testDeliver4Consignments() {
		logger.info("=====================deliver4Consignments=======================");
		OrderEntity  entity = new OrderEntity();
		Date date = new Date();
		entity.orderCode = "aSIT100020032";
		entity.deliveryTime = date;
		int count = appOrderDao.deliver4Consignments(entity);
		System.out.println(count+"=======testDeliver4Consignments======");
		logger.info(Integer.toString(count));
	}
	
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testAccept(){
		logger.info("=====================1Crown=======================");
    	int result = appOrderDao.accept("12306", "8803499018195", "水印");
    	logger.info(JSON.toJSONString(result));
    }
	
}
