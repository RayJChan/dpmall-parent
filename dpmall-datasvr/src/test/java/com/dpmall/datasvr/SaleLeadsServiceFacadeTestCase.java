package com.dpmall.datasvr;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.bean.SaleLeadsModel;
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
}
