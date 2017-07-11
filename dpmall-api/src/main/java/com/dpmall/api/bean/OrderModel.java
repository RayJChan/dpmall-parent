package com.dpmall.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 实物订单信息
 * @author river
 * @since 2017-07-10
 */
public class OrderModel implements Serializable {

	public static final long serialVersionUID = -7230929100050324381L;
	
	/**订单编号*/
	public String orderCode;
	
	/**订单参考编号*/
	public String orderRefCode;
	
	/**客户名称*/
	public String clientName;
	
	/**客户电话*/
	public String clientTel;
	
	/**发票信息*/
	public String receiptInfo;
	
	/**客户备注*/
	public String clientRemark;
	
	/**送货方式*/
	public String deliverMode;
	
	/**付费方式*/
	public String payMode;
	
	/**订单金额*/
	public Double orderTotal;
	
	/**订单列表*/
	public List<OrderItemModel> orderItemList;

}
