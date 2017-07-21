package com.dpmall.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 销售线索操作记录
 * @author crown
 * @since 2017-07-21
 */
public class SalesLeadsOperationModel implements Serializable{
	
	private static final long serialVersionUID = -4699869236557727902L;

	/**操作记录ID*/
	public String operateId;
	
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
