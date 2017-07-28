package com.dpmall.db.bean;

import java.math.BigDecimal;

public class SalesLeadsOrderItemEntity {
	
	/**ID*/
	public Long id;
	
	/**留资订单ID**/
	public Long orderId;
	
	/**商品ID**/
	public Long productId;
	
	/**商品数目*/
	public Integer quantity;
	
	/**商品名称*/
	public String productName;
	
	/**成交价格*/
	public BigDecimal dealPrice;
	
	/**品类**/
	public String catetory;
}
