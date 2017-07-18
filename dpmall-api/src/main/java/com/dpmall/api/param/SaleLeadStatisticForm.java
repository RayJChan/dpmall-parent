package com.dpmall.api.param;

import java.util.Date;

/**
 * 统计参数
 * @author river
 * @date 2017-07-18
 */
public class SaleLeadStatisticForm {
	/**门店ID*/
    public Long storeId;
    
    /**导购员用户名*/
    public String acceptorName;
    
    /**商品品类*/
    public String productCatelog;
    
    /**统计开始时间*/
    public Date fromTime;
    
    /**统计时间*/
    public Date toTime;
}
