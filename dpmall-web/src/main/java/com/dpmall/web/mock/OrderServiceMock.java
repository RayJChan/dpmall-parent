package com.dpmall.web.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dpmall.api.IOrderService;
import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.err.ErrorCode;

public class OrderServiceMock implements IOrderService {

	@Override
	public OrderModel getOrderDetails(String consignmentId) {

		OrderModel tmp = new OrderModel();
		BigDecimal bg1 = new BigDecimal("1.1");
		BigDecimal bg2 = new BigDecimal("736");
		BigDecimal bg3 = new BigDecimal("736");
		BigDecimal bg4 = new BigDecimal("368");
		BigDecimal bg5 = new BigDecimal("368");
		Long id=new Long(87961914);
		tmp.address = "测试测试测试";
		tmp.consignmentCode="a100015013";
		tmp.deliveryCost = bg1;
		tmp.orderCode = null;
		tmp.id = id;
		tmp.orderTotal = bg2;	
		tmp.payAmount = bg3; 
		tmp.phone1 = "15218365660";
		tmp.productBaseprice = bg4;
		tmp.productQuantity = "2";
		tmp.productTotal = bg3;
		tmp.salesApplication = "8796111634523";
		tmp.serviceAmount = bg5;
		tmp.shippingAddress = "8796420833303";
		tmp.status = "8796105703515";
		tmp.buyerNick = "测试";
		tmp.buyerNick = "测试";
		tmp.productCategory = "wu";
		tmp.name = "wu";
		tmp.productCode = "47598749686797";
		tmp.deliveryMethods = "1";
		tmp.cusComment = "测试";
		tmp.serverComment = "测试";
		tmp.agencyComment = "测试";
		tmp.deliveryMode = "1";
		tmp.logisticsCompany = "新邦物流";
		tmp.trackingId = "457956793457";
		tmp.acceptedBy = "dianyuan";
		tmp.acceptedComment = "无";
		tmp.deliverPic = "wu" ;
		return tmp;
	}
	
	@Override
	public Integer get2StoreCount(String storeId,String status){
		return ErrorCode.SUCCESS;
	}
	
   public List<OrderModel> getOnePage4Distribute(String distributorId,String status,String search,Integer offset, Integer pageSize){
	   List<OrderModel> mockResults = new ArrayList<OrderModel>();
	   return mockResults;
   }
    
    
    /**
     * 实物类经销商订单状态条数
     * @param distributorId 经销商ID
     * @param status 状态
     * @return 经销商待分配的实物订单数
     */
    public Integer get2DistributeCount(String distributorId,String status){
    	return ErrorCode.SUCCESS;
    }
    
    
    
    /**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param orderCode 订单编码
     * @param storeId 店铺ID
     * @param remark 备注
     * @return 成功返回200
     */
    public int distribute(String distributorId,String orderCode, String storeId,String remark){
    	return ErrorCode.SUCCESS;
    }
    
    
    /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param orderCode 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return 成功返回200
     */
    public int reject(String distributorId, String orderCode, String rejectType, String rejectRemark){
    	return ErrorCode.SUCCESS;
    }
    
    
    /**
     * 经销商获取待跟进的一页实物订单数据
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
     * @return 经销商待跟进的一页实物订单数据
     */
    public List<OrderModel> getOnePage4Followup(String distributorId,Integer offset, Integer pageSize){
    	List<OrderModel> mockResults = new ArrayList<OrderModel>();
 	    return mockResults;
    }
    
    /**
     * 根据条件查询已发货的实物订单
     * @param distributorId 经销商Id
     * @param distributeTime 订单下派时间
     * @param storeId
     * @param orderCode
     * @param clientName
     * @param clientTel
     * @param startNum
     * @param pageSize
     * @return 根据条件查询已发货的实物订单
     */
    public List<OrderModel> getOnePageClosedOrder(String distributorId,TimeScope distributeTime, String storeId,String orderCode, String clientName,String clientTel,Integer startNum, Integer pageSize){
    	List<OrderModel> mockResults = new ArrayList<OrderModel>();
 	    return mockResults;
    }
    
    
	/**
	 * 实物类门店订单状态列表
	 * @param storeId 店铺ID
	 * @param status 状态
	 * @param offset 上一次加载的位移
	 * @param pageSize 页的大小
	 * @return 实物类门店订单状态条数
	 */
    public List<OrderModel> getOnePage4StoreId(String storeId,String status,String acceptorId,String search,Integer offset, Integer pageSize){
    	List<OrderModel> mockResults = new ArrayList<OrderModel>();
 	    return mockResults;
    }
    
    /**
     * 实物类导购员订单状态条数
     * @param acceptorId 导购员ID
     * @param status 状态
     * @return 实物类导购员订单状态条数
     */
    public Integer get2AcceptorCount(String acceptorId,String status){
    	return ErrorCode.SUCCESS;
    }
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param orderCode 订单编码
     * @return 成功返回200
     */
    public int accept(String acceptorId, String orderCode, String acceptComment){
    	return ErrorCode.SUCCESS;
    }
    
    /**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
    public int deliver(String orderCode){
    	return ErrorCode.SUCCESS;
    }
 
    
    /**
     * 实物类导购员订单状态列表
     * @param acceptorId 导购员ID
     * @param status 状态
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return 导购员已接单的一页实物订单信息
     */
    public List<OrderModel> getOnePage4AcceptorId(String acceptorId,String status,Integer offset, Integer pageSize){
    	List<OrderModel> mockResults = new ArrayList<OrderModel>();
 	    return mockResults;
    }
    
    /**
     * 获取导购员已结单的一页实物订单信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return 导购员已结单的一页实物订单信息
     */
    public List<OrderModel> getOnePage4AcceptorClosed(String acceptorId,Integer startItemId, Integer pageSize){
    	List<OrderModel> mockResults = new ArrayList<OrderModel>();
 	    return mockResults;
    }
    
    /**
     * 实物类获取单据明细
     * @param consignmentId 发货单ID
     * @return 订单详情
     */
    public OrderModel getReturnRequestDetails(String consignmentId){
    	OrderModel tmp = new OrderModel();
		BigDecimal bg1 = new BigDecimal("1.1");
		BigDecimal bg2 = new BigDecimal("736");
		BigDecimal bg3 = new BigDecimal("736");
		BigDecimal bg4 = new BigDecimal("368");
		BigDecimal bg5 = new BigDecimal("368");
		Long id=new Long(87961914);
		tmp.address = "测试测试测试";
		tmp.consignmentCode="a100015013";
		tmp.deliveryCost = bg1;
		tmp.orderCode = null;
		tmp.id = id;
		tmp.orderTotal = bg2;	
		tmp.payAmount = bg3; 
		tmp.phone1 = "15218365660";
		tmp.productBaseprice = bg4;
		tmp.productQuantity = "2";
		tmp.productTotal = bg3;
		tmp.salesApplication = "8796111634523";
		tmp.serviceAmount = bg5;
		tmp.shippingAddress = "8796420833303";
		tmp.status = "8796105703515";
		tmp.buyerNick = "测试";
		tmp.buyerNick = "测试";
		tmp.productCategory = "wu";
		tmp.name = "wu";
		tmp.productCode = "47598749686797";
		tmp.deliveryMethods = "1";
		tmp.cusComment = "测试";
		tmp.serverComment = "测试";
		tmp.agencyComment = "测试";
		tmp.deliveryMode = "1";
		tmp.logisticsCompany = "新邦物流";
		tmp.trackingId = "457956793457";
		tmp.acceptedBy = "dianyuan";
		tmp.acceptedComment = "无";
		tmp.deliverPic = "wu" ;
		return tmp;
    }

}
