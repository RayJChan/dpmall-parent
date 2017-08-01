package com.dpmall.datasvr;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.common.SpringTestCase;
import com.dpmall.db.bean.OrderEntity;

public class OrderServiceFacadeTest extends SpringTestCase{
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceFacadeTest.class);
	@Autowired
	private IOrderService orderService;
	
//	@Test
//	public void testGet2AcceptCount() {
//		Integer result = orderService.get2AcceptCount("10086");
//		LOG.info("result:" + result);
//	}
//	
//	@Test
//	public void distributeTest() {
//		orderService.distribute("", "3", "10002");
//	}
//	/**
//	 * author:crown
//	 * getOnePage4Distribute
//	 */
//	@Test
//    public void testGetOnePage4Distribute(){
//    	List<OrderModel> result = orderService.getOnePage4Distribute("310145", 0, 20);
//        LOG.info("\n\nresult:" + JSON.toJSONString(result)+"\n\n");
//    }
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Followup(){
    	List<OrderModel> result = orderService.getOnePage4Followup("310145", 0, 20);
    	LOG.info("=====================daihx====================");
        LOG.info("\n\nresult:" + JSON.toJSONString(result)+"\n\n");
    }
//	/**
//	 * 店铺获取待接单的实物订单
//	 * @param storeId 店铺ID
//	 * @param offset 上一次加载的位移
//	 * @param pageSize 页的大小
//	 * @return 店铺获取待接单的实物订单列表
//	 */
//	@Test
//    public void testGetOnePage4Accept(){
//    	List<OrderModel> result = orderService.getOnePage4Accept("10086", 0, 20);
//    	LOG.info("=====================getOnePage4Accept====================");
//        LOG.info("result:" + JSON.toJSONString(result));
//    }
	
	/**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
	@Test
	public void testDeliver() {
		Integer deliver = orderService.deliver("aSIT100020032");
		LOG.info("===============确认收货================"+deliver);
	}
	
	/**
     * 导购员接单
     * @param model
     * @return 成功返回200
     */
	@Test
	public void testAccept() {
		Integer result = orderService.accept("123456", "aSITA100272016", "110");
		LOG.info("================导购员接单================" + result);
	}
	
	@Test
	public void getOnePage4DistributeTest() {
		logger.info("result:"+JSON.toJSONString(orderService.getOnePage4Distribute("", "", 0, 3)));
	}
	
	/**
     * 经销商下派到店铺
     */
	@Test
	public void testDistribute() {
		Integer result = orderService.distribute("", "aSIT100016018", "33", "TESTDistribute");
		LOG.info("================经销商下派到店铺================" + result);
	}
	
	/**
	 * author:crown
	 * getOrderDetails
	 */
	@Test
    public void testGetOrderDetails(){
		logger.info("=====================getOrderDetails=======================");
		OrderModel result = orderService.getOrderDetails("a100015013");
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
		Integer result = orderService.get2DistributeCount("310145", "8796105670747");
    	logger.info(JSON.toJSONString(result));
    }
}
