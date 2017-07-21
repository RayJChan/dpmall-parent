package com.dpmall.web.controller.form;

/**
 * 订单项 
 * @author river
 * @since 2017-07-10
 */
public class SaleLeadsGoodsForm{
	
	/**订单项ID*/
	public String orderItemId;
	
	/**订单项数目*/
	public Integer itemNum;
	
	/**商品编码*/
	public String productCode;
	
	/**商品名称*/
	public String productName;
	
	/**成交价格*/
	public Double dealPrice;
	
    public String token;
    public Integer startNum;
    public Integer pageSize;
}
