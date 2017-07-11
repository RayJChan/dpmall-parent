package com.dpmall.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.bean.ProductStatisticModel;


@Controller
@RequestMapping("productStatistic")
public class ProductStatisticController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductStatisticController.class);
    
    
    @RequestMapping(method = RequestMethod.GET,produces = "application/json") 
    @ResponseBody
    public List<ProductStatisticModel> search(HttpServletRequest req){
        LOG.info("shit----------------------to-------------------come here");
    	List<ProductStatisticModel> result = new ArrayList<ProductStatisticModel>();
    	return result;
    }
}
