package com.dpmall.api;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.bean.ProductStatisticModel;
import com.dpmall.common.SpringTestCase;

public class ProductStatisticServiceTestCase extends SpringTestCase {
	private static final Logger LOG = LoggerFactory.getLogger(ProductStatisticServiceTestCase.class);
	
	@Autowired
	private IProductStatisticService productStatisticService;
	
	@Test
	public void testSearch(){
    	List<ProductStatisticModel> result = productStatisticService.search("1234567", "2017-05-01 11:11:11", "2018-05-01 11:11:11", 0,50);
        LOG.info("result:" + JSON.toJSONString(result));
        System.out.println("\n\nresult:" + JSON.toJSONString(result)+"\n\n");
	}

}
