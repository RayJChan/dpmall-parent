package com.dpmall.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IProductStatisticService;
import com.dpmall.api.bean.ProductStatisticModel;
import com.dpmall.web.controller.form.ProductStatisticSearchForm;


@Controller
@RequestMapping("/productStatistic")
public class ProductStatisticController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductStatisticController.class);
    
	@Autowired
	private IProductStatisticService productStatisticService;
    
    @RequestMapping(value="/search",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<ProductStatisticModel> search(ProductStatisticSearchForm form){
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'ProductStatisticController::search',in:{productCode:'" + form.productCode + "',fromTime:'"
					+ form.fromTime + "',endTime:'" + form.endTime + "',start:'" + form.start + "',pageSize:'" + form.pageSize + "'}}");
		}
    	List<ProductStatisticModel> result = productStatisticService.search(form.productCode, form.fromTime, form.endTime, form.start, form.pageSize);

		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'ProductStatisticController::search',out:"+JSON.toJSONString(result)+"}");
		}
    	return result;
    }
    
}
