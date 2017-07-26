package com.dpmall.api;

import java.util.List;

import com.dpmall.api.bean.OrderModel;
import com.dpmall.api.common.TimeScope;

/**
 * 实物订单服务接口
 * @author river
 * @since 2017-07-10
 */
public interface IOrderService {
	/**
	 * 经销商获取待分配的实物订单
	 * @param distributorId 经销商Id
	 * @param offset 上一次加载的最后项offset
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的实物订单列表
	 */
    public List<OrderModel> getOnePage4Distribute(String distributorId,Integer offset, Integer pageSize);
    
    /**
     * 获取经销商待分配的实物订单数
     * @param distributorId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    public Integer get2DistributeCount(String distributorId);
    
    
    
    /**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param orderCode 订单编码
     * @param storeId 店铺ID
     * @return 成功返回200
     */
    public int distribute(String distributorId,String orderCode, String storeId);
    
    
    /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param orderCode 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return 成功返回200
     */
    public int reject(String distributorId, String orderCode, String rejectType, String rejectRemark);
    
    
    /**
     * 经销商获取待跟进的一页实物订单数据
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
     * @return 经销商待跟进的一页实物订单数据
     */
    public List<OrderModel> getOnePage4Followup(String distributorId,Integer offset, Integer pageSize);
    
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
    public List<OrderModel> getOnePageClosedOrder(String distributorId,TimeScope distributeTime, String storeId,String orderCode, String clientName,String clientTel,Integer startNum, Integer pageSize);
    
    
	/**
	 * 店铺获取待接单的实物订单
	 * @param storeId 店铺ID
	 * @param offset 上一次加载的位移
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的实物订单列表
	 */
    public List<OrderModel> getOnePage4Accept(String storeId,Integer offset, Integer pageSize);
    
    /**
     * 获取店铺待接单的实物订单数
     * @param storeId 经销商ID
     * @return 经销商待分配的实物订单数
     */
    public Integer get2AcceptCount(String storeId);
    
    
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param orderCode 订单编码
     * @return 成功返回200
     */
    public int accept(String acceptorId, String orderCode);
    
    /**
     * 确认发货
     * @param model
     * @return 成功返回200
     */
    public int deliver(String orderCode);
 
    
    /**
     * 获取导购员已接单的一页实物订单信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return 导购员已接单的一页实物订单信息
     */
    public List<OrderModel> getOnePage4Acceptor2Followup(String acceptorId,Integer offset, Integer pageSize);
    
    /**
     * 获取导购员已结单的一页实物订单信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return 导购员已结单的一页实物订单信息
     */
    public List<OrderModel> getOnePage4AcceptorClosed(String acceptorId,Integer startItemId, Integer pageSize);
}
