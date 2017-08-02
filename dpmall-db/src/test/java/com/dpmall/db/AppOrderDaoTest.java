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
//		logger.info(JSON.toJSONString(appOrderDao.get2DistributeCount("8796294532666")));
	}
	
	@Test
	public void testGet2AcceptCount() {
//		logger.info("获取店铺待接单的实物订单数:"+appOrderDao.get2AcceptCount("10086"));
	}
	
	@Test
	public void distributeTest() {
//		logger.info("result:"+JSON.toJSONString(appOrderDao.distribute("1", "10086")));
	}
	
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Distribute(){
		logger.info("=====================crown=========================");
    	List<OrderEntity> result = appOrderDao.getOnePage4Distribute("10086", "1", 0, 5);
    	logger.info(JSON.toJSONString(result));
    }
	
	@Test
    public void testGetOnePage4StoreId(){
		logger.info("=====================crown=========================");
    	List<OrderEntity> result = appOrderDao.getOnePage4StoreId("10086", "1", 0, 5);
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
//		int count = appOrderDao.edit(entity);
//		System.out.println(count +"======testEdit======");
//		logger.info(Integer.toString(count));
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
//    	int result = appOrderDao.accept("12306", "8803499018195", "水印");
//    	logger.info(JSON.toJSONString(result));
    }
	
	/**
     * 经销商下派到店铺
     * @param orderCode 订单编码
     * @param storeId 店铺ID
     * @param remark 备注
     */
	@Test
	public void testDistributes() {
		logger.info("==============testDistributes==============");
//		int result1 = appOrderDao.distribute4O2o("aSIT100016018", "1111", "Test备注");
		int result2 = appOrderDao.distribute4Consignment("aSIT100016018", "2222");
		logger.info(Integer.toString(result2));
		
	}
	
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOrderDetails(){
		logger.info("=====================getOrderDetails=======================");
		OrderEntity result = appOrderDao.getOrderDetails("a100015013");
    	logger.info(JSON.toJSONString(result));
    }
	
	/**
     * 实物类经销商订单状态条数
     * @param distributorId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
	@Test
    public void testGet2DistributeCount(){
		logger.info("=====================testGet2DistributeCount=======================");
		Integer result = appOrderDao.get2DistributeCount("310145", "8796105670747");
    	logger.info(JSON.toJSONString(result));
    }
	
	/**
     * 实物类导购员订单状态条数
     * @param acceptorId 导购员ID
     * @param status 状态
     * @return 实物类导购员订单状态条数
     */
	@Test
	public void testGet2AcceptorCount() {
		logger.info("=================testGet2AcceptorCount====================");
		Integer count = appOrderDao.get2AcceptorCount("5590590", "8796105375835");
		logger.info(JSON.toJSONString(count));
	}
	
	/**
     * 实物类经销商订单状态条数
     * @param distributorId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
	@Test
    public void testGetOnePage4AcceptorId(){
		logger.info("=====================getOnePage4AcceptorId=======================");
		List<OrderEntity> result = appOrderDao.getOnePage4AcceptorId("123456", "8796105637979", 0, 20);
    	logger.info(JSON.toJSONString(result));
    }
	
	/**
     * 实物类门店订单状态条数
     * @param storeId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
	@Test
	public void testGet2StoreCount() {
		logger.info("=================testGet2StoreCount====================");
		Integer count = appOrderDao.get2StoreCount(null, "8796105375835");
		logger.info(JSON.toJSONString(count));
	}
}
