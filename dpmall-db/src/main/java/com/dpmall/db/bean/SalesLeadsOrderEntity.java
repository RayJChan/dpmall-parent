package com.dpmall.db.bean;


import java.math.BigDecimal;
import java.util.Date;

public class SalesLeadsOrderEntity  {
	/**留资订单ID*/
	public Long id;
	
	/**客户姓名*/
	public String clientName;
	
	/**客户电话**/
	public String clientTel;	
	
	/**客户地址*/
	public String clientAddr;
	
	/**客户备注**/
	public String clientRemark;
	
	/**服务地址*/
	public String serviceAddress;
	
	/**服务品类*/
	public String serviceCatelog;
	
	/**服务摘要*/
	public String serviceTitle;
	
	/**预计服务时间*/
	public Date serviceDate;
	
	/**风格偏好*/
	public String style;
	
	/**品牌偏好*/
	public String brand;
	
	/**客户预算*/
	public BigDecimal budget;
	
	/**客服电话*/
	public String callServiceTel;
	
	/**客服备注*/
	public String callServiceRemark;
	
	/**销售线索订单状态*/
	public String saleLeadsStatus;
	
	/**下派时间*/
	public Date distributeTime;
	
	/**经销商Id*/
	public Long distributorId;
	
	/**经销商操作时间*/
	public Date distributorOperateTime;
	
	/**经销商用户名*/
	public String distributorUserName;
	
	/**建议店铺ID*/
	public Long recommendstoreId;
	
	/**建议店铺名称*/
	public String recommendstoreName;

	/**店铺接单人*/
	public String storeAcceptor;
	
	/**店铺接单时间*/
	public Date storeAcceptTime;
	
	/**预约到店时间*/
	public Date appointmentTime;
	
	/**结单时间*/
	public Date closeTime;
	
	/**成单金额*/
	public BigDecimal total;
	
	/**拒单类型*/
	public Integer rejectType;
	
	/**拒单原因*/
	public String rejectRemark;
	
	/**拒单时间*/
	public Date refuseTime;
	
}