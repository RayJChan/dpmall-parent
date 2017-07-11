package com.dpmall.datasvr.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.IProductStatisticService;
import com.dpmall.api.bean.ProductStatisticModel;

/**
 * 统计数据facade
 * 
 * @author river
 * @since 2017-06-30
 */
public class ProductStatisticServiceFacade implements IProductStatisticService {
	private static final Logger LOG = LoggerFactory.getLogger(ProductStatisticServiceFacade.class);

	private IProductStatisticService productStatisticService;

	public List<ProductStatisticModel> search(String productCode, String fromTime, String endTime, int start,int pageSize) {
		if (LOG.isInfoEnabled()) {
			LOG.info("{method:'ProductStatisticServiceFacade::search',in:{productCode:'" + productCode + "',fromTime:'"
					+ fromTime + "',endTime:'" + endTime + "',start:'" + start + "',pageSize:'" + pageSize + "'}}");
		}
		
		List<ProductStatisticModel> out = productStatisticService.search(productCode, fromTime, endTime, start, pageSize);
		
		if(LOG.isDebugEnabled()){
			LOG.info("{method:'ProductStatisticServiceFacade::search',out:"+JSON.toJSONString(out)+"}");
		}
		return out;
	}
	
	public void setProductStatisticService(IProductStatisticService productStatisticService) {
		this.productStatisticService = productStatisticService;
	}

}
