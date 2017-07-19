package com.dpmall.datasvr;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.common.DateUtils;
import com.dpmall.common.SpringTestCase;

public class SaleLeadsServiceFacadeTestCase extends SpringTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(SaleLeadsServiceFacadeTestCase.class);
    
    @Autowired
    private com.dpmall.api.ISaleLeadsService saleLeadsService;
    
    @Test
    public void testSearch(){
    	List<SaleLeadsModel> result = saleLeadsService.getOnePage4Distribute("8", 0, 20);
        LOG.info("result:" + JSON.toJSONString(result));
    }
    @Test
    public void testOnePage4FollowupSearch(){
    	List<SaleLeadsModel> result = saleLeadsService.getOnePage4Followup("8", 0, 20);
        LOG.info("result:" + JSON.toJSONString(result));
    }
    @Test
    public void testGet2DistributeCount(){
    	Integer result = saleLeadsService.get2DistributeCount("8");
        LOG.info("result:" + JSON.toJSONString(result));
    }
    @Test
    public void testGet2AcceptCount(){
    	Integer result = saleLeadsService.get2AcceptCount("13");
        LOG.info("result:" + result);
    }
    @Test
    public void testGetOnePage4Accept(){
    	List<SaleLeadsModel> acceptModel = saleLeadsService.getOnePage4Accept("1", 0, 5);
        LOG.info("result:" + JSON.toJSONString(acceptModel));
    }
    
    @Test
    public void testEdit() {
    	SaleLeadsModel model=new SaleLeadsModel();
    	model.id=1L;
    	model.budget=22.22;
    	LOG.info("result:"+saleLeadsService.edit(model));
    	
    }
    @Test
    public void testGetSaleLeads(){
    	SaleLeadsModel acceptModel = saleLeadsService.getSaleLeads("2");
    	LOG.info("=======================开始执行=======================");
        LOG.info("\n\nresult:" + JSON.toJSONString(acceptModel)+"\n\n");
    }
    
    @Test
    public void testDistributeBatch() {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("1", "1111111");
    	map.put("2", "22222222");
    	LOG.info("result:"+saleLeadsService.distributeBatch("", map));
    }
    @Test
    public void testGetOnePageClosedSaleLeads() throws ParseException{
    	TimeScope scope = new TimeScope();

    	scope.begin = new Timestamp(DateUtils.parse("2017-07-18 00:00:00", DateUtils.YYYY_MM_DD_HH_MM_SS).getTime());
    	scope.end = new Timestamp(DateUtils.parse("2017-07-20 10:30:00", DateUtils.YYYY_MM_DD_HH_MM_SS).getTime());
    	List<SaleLeadsModel> acceptModel = saleLeadsService.getOnePageClosedSaleLeads("1", scope, "13", "1", "22", "1", 0, 5);
        LOG.info("result:" + JSON.toJSONString(acceptModel));
    }
}
