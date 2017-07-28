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

public class OrderServiceFacadeTest extends SpringTestCase{
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceFacadeTest.class);
	@Autowired
	private IOrderService orderService;
	
	@Test
	public void get2DistributeCountTest() {
		orderService.get2DistributeCount("8796294532666");
	}
	
	@Test
	public void testGet2AcceptCount() {
		Integer result = orderService.get2AcceptCount("10086");
		LOG.info("result:" + result);
	}
	
	@Test
	public void distributeTest() {
		orderService.distribute("", "3", "10002");
	}
	/**
	 * author:crown
	 * getOnePage4Distribute
	 */
	@Test
    public void testGetOnePage4Distribute(){
    	List<OrderModel> result = orderService.getOnePage4Distribute("310145", 0, 20);
        LOG.info("\n\nresult:" + JSON.toJSONString(result)+"\n\n");
    }
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
	/**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param offset 上一次加载的位移
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
	@Test
    public void testGetOnePage4Accept(){
    	List<OrderModel> result = orderService.getOnePage4Accept("10086", 0, 20);
    	LOG.info("=====================getOnePage4Accept====================");
        LOG.info("result:" + JSON.toJSONString(result));
    }
	
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
}
