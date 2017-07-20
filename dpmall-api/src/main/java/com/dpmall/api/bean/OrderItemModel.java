package com.dpmall.api.bean;

import java.io.Serializable;

/**
 * 订单明细
 * @author river
 * @since 2017-07-10
 */
public class OrderItemModel implements Serializable {
	
	private static final long serialVersionUID = -3671800765534980401L;

	/**订单明细ID，逻辑主键*/
	public String orderItemId;
	
	/**商品品类*/
	public String catelogId;
	
	/**品类名称*/
	public String catelogName;
	
	/**单位*/
	public String unit;
	
	/**数量*/
	public Integer number;
	
	/**价格*/
	public Double price;
}
