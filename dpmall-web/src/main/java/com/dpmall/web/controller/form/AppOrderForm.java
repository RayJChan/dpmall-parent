package com.dpmall.web.controller.form;

public class AppOrderForm extends RequestForm{
	
	/**经销商Id**/
	public String distributorId;
	
	/**实物类订单Id**/
	public String orderCode;
	
	/**商店Id**/
	public String storeId;
	
	/**拒单类型**/
	public String rejectType;
	
	/**拒单备注**/
	public String rejectRemark;
	
	/**订单下派时间**/
	public String distributeTime;
	
	/**客户姓名**/
	public String clientName;
	
	/**客户电话**/
	public String clientTel;
	
	/**导购员ID**/
	public String acceptorId;
	
	/**开始页码**/
	public Integer startNum;
	
	public Integer pageSize;
	
	/**导购员接单备注**/
	public String acceptComment;
	
	/**订单状态**/
	public String status;
	
}
