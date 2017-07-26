package com.dpmall.db.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiecong
 *
 */
public class AppOrderEntity {
	/**ID**/
	public Long id;
	
	/**推荐门店**/
	public String recommendStore;
	
	/**发货单ID**/
	public 	String consignment;
	
	/**客户备注**/
	public String cusComment;
	
	/**客服备注**/
	public String serverComment;
	
	/**客户退货备注**/
	public String cusRefuseComment;
	
	/**经销商备注**/
	public String agencyComment;
	
	/**经销商拒单类型**/
	public String refuseType;
	
	/**经销商拒单备注**/
	public String refuseComment;
	
	/**门店接单人拒单备注**/
	public String acceptedRefuseComment;
	
	/**发货凭证**/
	public String deliverPic;
	
	/**订单状态**/
	public String status;
	
	/**门店接单人**/
	public String acceptedBy;
	
	/**门店接单人备注**/
	public String acceptedComment;
	
	/**门店接单人时间**/
	public Date acceptedTime;
	
	/**是否自己仓库发货**/
	public String isDeliverySelf;
	
	/**发货时间**/
	public Date deliveryTime;
	
	/**完成时间**/
	public Date finishTime;
	
	/**服务门店**/
	public String deliveryPoint;
	
	/**发货方式**/
	public String deliveryMode;
	
	/**订单编号（发货单订单编号）**/
	public String orderCode;
	
	/**客户名称*/
	public String clientName;
	
	/**客户电话*/
	public String clientTel;
	
	/**订单金额*/
	public BigDecimal orderTotal;
}
