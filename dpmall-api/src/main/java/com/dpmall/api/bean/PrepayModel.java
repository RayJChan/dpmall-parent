package com.dpmall.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;
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
	public BigDecimal orderTotal=BigDecimal.ZERO;
	
	/**订单列表*/
	public List<OrderItemModel> orderItemList = new ArrayList<OrderItemModel>();
	
	/**经销商ID**/
	public String allocatCode;
	
	/**收货地址**/
	public String shippingAddress;
	
	/**客户姓名**/
	public String buyerNick;
	
	/**商品数量**/
	public String productQuantity;
	
	/**商品单价**/
	public BigDecimal productBaseprice=BigDecimal.ZERO;
	
	/**商品汇总价格**/
	public BigDecimal productTotal=BigDecimal.ZERO;
	
	/**收货人名字**/
	public String firstName;
	
	/**收货人电话号码**/
	public String phone1;
	
	/**送货地址**/
	public String address;
	
	/**服务门店**/
	public String deliveryPointOfService;
	
	/**订单状态**/
	public String status;
	
	/**ID**/
	public Long id;
	
	/**订单编号**/
	public String consignmentCode;
	
	/**包邮**/
	public String logisticsInfo;
	
	/**物流单号**/
	public String trackingId;
	
	/**运费**/
	public BigDecimal deliveryCost;
	
	/**站方*/
	public String salesApplication;
	
	/**均摊金额*/
	public BigDecimal juntanPrice;
	
	/**付款数量*/
	public BigDecimal payAmount;
	
	/**服务金额*/
	public BigDecimal serviceAmount;
	
	/**送货方式*/
	public String deliveryMethods;
	
	/**物流公司名称*/
	public String name;
	
	/**客户备注**/
	public String cusComment;
	
	/**客服备注**/
	public String serverComment;
	
	/**客户退货备注**/
	public String cusRefuseComment;
	
	/**门店接单人拒单备注**/
	public String acceptedRefuseComment;
	
	/**门店接单人**/
	public String acceptedBy;
	
	/**发货凭证**/
	public String deliverPic;
	
	/**经销商备注**/
	public String agencyComment;
	
	/**门店接单人备注**/
	public String acceptedComment;
	
	/**发货方式**/
	public String deliveryMode;
	
	/**汇总金额*/
	public BigDecimal totalSum;
	
	/**物流公司名称*/
	public String logisticsCompany;
	
	/**操作状态*/
	public String operateStatus;
	
	/**返回状态*/
	public String returnStatus;
	
	/**省*/
	public String RegionName;

	/**市*/
	public String CityName;

	/**区*/
	public String DistrictName;
	
	/**发货备注*/
	public String deliveryRemark;
	
	/**下单时间**/
	public Date createds;
	
	/**订单详情**/
	public List<Object> items=new ArrayList<Object>();
}
