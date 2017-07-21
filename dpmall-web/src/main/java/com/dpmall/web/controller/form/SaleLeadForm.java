package com.dpmall.web.controller.form;

/**
 * 统计参数
 * @author river
 * @date 2017-07-18
 */
public class SaleLeadForm{

	/**门店ID*/
    public Long storeId;
    
    /**导购员用户名*/
    public String acceptorName;
    
    /**导购员ID*/
    public String acceptorId;
    
    /**商品品类*/
    public String productCatelog;
    
    /**统计开始时间*/
    public String fromTime;
    
    /**统计时间*/
    public String toTime;
    
    /**线索ID*/
    public String saleLeadsId;
    
    /**经销商ID*/
    public String distributorId;
    
    /**下派时间*/
    public String distributeTimeBegin;
    /**下派时间*/
    public String distributeTimeEnd;
    /**客户名称*/
    public String clientName;
    /**客户电话*/
    public String clientTel;
    
    /**店铺名称*/
    public String storeName;
    public String token;
    public Integer startNum;
    public Integer pageSize;
}
