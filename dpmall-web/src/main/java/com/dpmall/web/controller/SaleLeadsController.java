package com.dpmall.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.web.mock.SaleLeadsServiceMock;

/**
 * 销售线索
 * @author river
 * @date 2017-7-14
 */
@Controller
@RequestMapping("/saleLeads")
public class SaleLeadsController {
	
	private ISaleLeadsService saleLeadsServiceMock = new SaleLeadsServiceMock();
	
	@Autowired
	private ISaleLeadsService saleLeadsService;

	
	/**
	 * 经销商获取待分配的销售线索
	 * @param distributorId 经销商Id
	 * @param startNum 上一次加载的最后项偏移
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的销售线索列表
	 */
    @RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<SaleLeadsModel> getOnePage4Distribute(String distributorId,Integer startNum, Integer pageSize){
    	return saleLeadsServiceMock.getOnePage4Distribute(distributorId, startNum, pageSize);
    }
    
    /**
     * 获取经销商待分配的线索数
     * @param distributorId 经销商ID
     * @return 经销商待分配的线索数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Integer get2DistributeCount(String distributorId){
    	return saleLeadsServiceMock.get2DistributeCount(distributorId);
    }
    
    
    /**
     * 经销商下派到店铺
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param shopId 店铺ID
     * @return
     */
    @RequestMapping(value="/distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int distribute(String distributorId,String saleLeadsId, String shopId){
		return saleLeadsServiceMock.distribute(distributorId, saleLeadsId, shopId);
    }
    
    /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return
     */
    @RequestMapping(value="/reject",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark){
		return saleLeadsServiceMock.reject(distributorId, saleLeadsId, rejectType, rejectRemark);
    }
    
    
    /**
     * 经销商获取待跟进的一页线索订单数据
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
     * @return
     */
    @RequestMapping(value="/getOnePage4Followup",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<SaleLeadsModel> getOnePage4Followup(String distributorId,Integer startNum, Integer pageSize){
    	return saleLeadsServiceMock.getOnePage4Followup(distributorId, startNum, pageSize);
    }
    
    /**
     * 根据条件查询已完结的销售线索订单
     * @param distributorId 经销商Id
     * @param distributeTime 订单下派时间
     * @param storeId
     * @param saleLeadId
     * @param clientName
     * @param clientTel
     * @param startNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getOnePageClosedSaleLeads",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId,TimeScope distributeTime, String storeId,String saleLeadId, String clientName,String clientTel,Integer startNum, Integer pageSize){
    	return saleLeadsServiceMock.getOnePageClosedSaleLeads(distributorId, distributeTime, storeId, saleLeadId, clientName, clientTel, startNum, pageSize);
    }
    
    
	/**
	 * 店铺获取待接单的销售线索
	 * @param storeId 店铺ID
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 店铺获取待接单的销售线索列表
	 */
    @RequestMapping(value="/getOnePage4Accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<SaleLeadsModel> getOnePage4Accept(String storeId,Integer startNum, Integer pageSize){
    	return saleLeadsServiceMock.getOnePage4Accept(storeId, startNum, pageSize);
    }
    
    /**
     * 获取店铺待接单的线索数
     * @param storeId 经销商ID
     * @return 经销商待分配的线索数
     */
    @RequestMapping(value="/get2AcceptCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Integer get2AcceptCount(String storeId){
    	return saleLeadsServiceMock.get2AcceptCount(storeId);
    }
    
    
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param saleLeadsId 线索ID
     * @return
     */
    @RequestMapping(value="/accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int accept(String acceptorId, String saleLeadsId){
    	return saleLeadsServiceMock.accept(acceptorId, saleLeadsId);
    }
    
    /**
     * 编辑销售线索订单信息
     * @param model
     * @return
     */
    @RequestMapping(value="/edit",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public int edit(SaleLeadsModel model){
    	return saleLeadsServiceMock.edit(model);
    }
 
    
    /**
     * 获取导购员已接单的一页销售线索信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value="/getOnePage4Acceptor2Followup",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<SaleLeadsModel> getOnePage4Acceptor2Followup(String acceptorId,Integer startNum, Integer pageSize){
    	return saleLeadsServiceMock.getOnePage4Acceptor2Followup(acceptorId, startNum, pageSize);
    }
    
    /**
     * 获取导购员已结单的一页销售线索信息
     * @param acceptorId 导购员ID
     * @param startItemId 上一次加载的最后项ID
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value="/getOnePage4AcceptorClosed",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId,Integer startNum, Integer pageSize){
    	return saleLeadsServiceMock.getOnePage4AcceptorClosed(acceptorId, startNum, pageSize);
    }

}
