package com.dpmall.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
	public BigDecimal orderTotal=BigDecimal.ZERO;
	
	/**订单列表*/
	public List<OrderItemModel> orderItemList = new ArrayList<OrderItemModel>();
	
	/**经销商ID**/
	public String allocatCode;
	
	/**收货地址**/
	public String shippingAddress;
	
	/**客户姓名**/
	public String buyerNick;
	
	/**商品编码**/
	public String productCode;
	
	/**商品品类**/
	public String productCategory;
	
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
	
	public List<Object> items=new ArrayList<Object>();
}
