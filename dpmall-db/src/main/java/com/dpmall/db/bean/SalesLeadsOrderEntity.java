package com.dpmall.db.bean;


import java.math.BigDecimal;
import java.util.Date;

public class SalesLeadsOrderEntity  {
	/**id**/
    public Long id;
    
    /**销售线索**/
    public Long salesleads;
    
    /**经销商ID**/
    public Long agency;
    
    /**线索订单状态**/
    public String status;
    
    /**是否完成订单**/
    public String resolved;

    /**派单时间**/
    public Date distributedate;
    
    /**派单员**/
    public String distributer; //
    
    /**经销商接单时间**/
    public Date agencyacceptdate;
    
    /**经销商操作员**/
    public String agencyaccept;
    
    /**拒单时间**/
    public Date refusedate;
    
    /**建议服务店铺**/
    public String suggeststore;
    
    /**接单店铺**/
    public String acceptstore;
    
    /**店铺接单人**/
    public String  acceptreceivedby;
    
    /**店铺接单时间**/
    public Date acceptdate;
    
    /**预约时间**/
    public Date appointmentdate;
    
    /**客户到店时间**/
    public Date actualdate;
    
    /**完单金额**/
    public BigDecimal amount;

    /**订单图片**/
    public String orderpicture;

    /**客户电话**/
    public String telephone;
    
    /**客户昵称**/
    public String nickname;
    
    /**客户名称**/
    public String name;
    
    /**客户区域**/
    public String  district;
    
    /**客户地址**/
    public String address;
    
    /**服务区域**/
    public String  servedistrict;

    /**服务地址**/
    public String serveaddress;

    /**服务意向**/
    public String sercerpurpose;

    /**装修时间**/
    public Date fitmentdate;

    /**风格喜好**/
    public String stylepreferences;

    /**客户备注**/
    public String comment;
    
    /**品牌偏好**/
    public String brandpreferences;

    /**预算**/
    public BigDecimal budget;

    /**客服账户**/
    public Long handler; //todo

    /**客服备注**/
    public String handlercomment;

    /**关闭时间**/
    public Date closedate;

    /**关闭原因**/
    public String closereason;
    
    /**客服电话 **/   
    public Long serveTel;

    
    /**经销商操作时间**/
    public Date distributorOperateDate;

	/**经销商用户名**/
    public String distributorUserName;
    
    /**服务摘要**/
    public String serviceTitle;
    
    /**服务种类**/
    public String serviceCatelog;
}