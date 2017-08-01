package com.dpmall.api;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dpmall.common.SpringTestCase;

public class ProductStatisticServiceTestCase extends SpringTestCase {
	private static final Logger LOG = LoggerFactory.getLogger(ProductStatisticServiceTestCase.class);
	
	@Autowired
	private IProductStatisticService productStatisticService;
	
	@Test
	public void testSearch(){
    	System.out.println(BigDecimal.ZERO);
	}

}
