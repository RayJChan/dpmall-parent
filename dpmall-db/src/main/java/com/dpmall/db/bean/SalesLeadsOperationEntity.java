package com.dpmall.db.bean;

import java.util.Date;

public class SalesLeadsOperationEntity {
	
	
	/**操作记录ID*/
	public int operateId;
	
	/**操作人*/
	public String operatorBy;
	
	/**操作时间*/
	public Date operatorDate;
	
	/**操作描述*/
	public String operatorDesc;
	
	/**销售线索订单*/
	public String salesLeadsOrder;
	
	/**操作类型*/
	public String operatorType;
}
