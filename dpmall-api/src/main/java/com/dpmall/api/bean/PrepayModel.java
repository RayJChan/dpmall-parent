package com.dpmall.api.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 特权定金
 * @author river
 * @since 2017-07-10
 */
public class PrepayModel implements Serializable {
	
	private static final long serialVersionUID = -1248442523373720040L;

	/**预付ID*/
	public String prepayId;
	
	/**客户名称*/
	public String clientName;
	
	/**客户电话*/
	public String clientTel;
	
	/**预约时间*/
	public Date appointmentTime;
	
	/**特权定金下单时间*/
	public Date orderTime;
	
	/**结束时间*/
	public Date closeTime;
	
	/**订单成交金额*/
	public Double totalAmount;
	
	/**订单成交商品*/
	public List<SaleLeadsGoodsModel> goodsList=new ArrayList<SaleLeadsGoodsModel>();;
}
