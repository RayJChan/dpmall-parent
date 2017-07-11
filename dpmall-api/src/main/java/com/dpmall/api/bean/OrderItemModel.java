package com.dpmall.api.bean;

import java.io.Serializable;

/**
 * 订单明细
 * @author river
 * @since 2017-07-10
 */
public class OrderItemModel implements Serializable {
	
	private static final long serialVersionUID = -3671800765534980401L;

	public String orderItemId;
	
	public String catelogId;
	
	public String catelogName;
	
	public String unit;
	
	public Integer number;
	
	public Double price;
}
