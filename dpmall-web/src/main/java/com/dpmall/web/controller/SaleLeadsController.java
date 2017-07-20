package com.dpmall.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.api.param.SaleLeadStatisticForm;
import com.dpmall.web.controller.form.AcceptBatchForm;
import com.dpmall.web.controller.form.RejectBatchForm;
import com.dpmall.web.controller.form.Response;
import com.dpmall.web.mock.SaleLeadsServiceMock;

/**
 * 销售线索
 * @author river
 * @date 2017-7-14
 */
@Controller
@RequestMapping("/saleLeads")
public class SaleLeadsController {
	private static final Logger LOG = LoggerFactory.getLogger(SaleLeadsController.class);
	
	private ISaleLeadsService saleLeadsServiceMock = new SaleLeadsServiceMock();
	
	@Autowired
	private ISaleLeadsService saleLeadsService;


	
	/**
	 * 经销商获取待分配的销售线索
	 * @param distributorId 经销商Id
	 * @param startItemId 上一次加载的最后项ID
	 * @param pageSize 页的大小
	 * @return 经销商获取待分配的销售线索列表
	 */
    @RequestMapping(value="/getOnePage4Distribute",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePage4Distribute(String distributorId,Integer startNum, Integer pageSize,String token){
    	Response res = new Response();
    	List<SaleLeadsModel> data = null;
        try{
    	    data = saleLeadsServiceMock.getOnePage4Distribute(distributorId, startNum, pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
    }
    
    /**
     * 获取经销商待分配的线索数
     * @param distributorId 经销商ID
     * @return 经销商待分配的线索数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2DistributeCount(String distributorId,String token){
    	Response res = new Response();
    	Integer data = null;
        try{
    	    data = saleLeadsServiceMock.get2DistributeCount(distributorId);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
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
    public Response distribute(String distributorId,String saleLeadsId, String shopId,String token){
    	Response res = new Response();
    	if (StringUtils.isEmpty(distributorId)||StringUtils.isEmpty(saleLeadsId)||StringUtils.isEmpty(shopId)) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
        else {
        	try{
            	res.data = saleLeadsService.distribute(distributorId, saleLeadsId, shopId);
            	res.resultCode=ErrorCode.SUCCESS;
            } catch(Throwable e){
            	LOG.error(e.getMessage(),e);
        	}
		}
        
    	return res;
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
    public Response reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark,String token){
    	Response res = new Response();
        try{
        	res.resultCode = saleLeadsServiceMock.reject(distributorId, saleLeadsId, rejectType, rejectRemark);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
        
    	return res;
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
    public Response getOnePage4Followup(String distributorId,Integer startNum, Integer pageSize,String token){
    	Response res = new Response();
    	List<SaleLeadsModel> data = null;
        try{
    	    data = saleLeadsServiceMock.getOnePage4Followup(distributorId, startNum, pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
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
    public Response getOnePageClosedSaleLeads(String distributorId,String distributeTimeBegin, String distributeTimeEnd,String storeId,String saleLeadId, String clientName,String clientTel,Integer startNum, Integer pageSize,String token){
    	Response res = new Response();
    	List<SaleLeadsModel> data = null;
    	TimeScope distributeTime = null;
        try{
    	    data = saleLeadsServiceMock.getOnePageClosedSaleLeads(distributorId, distributeTime, storeId, saleLeadId, clientName, clientTel, startNum, pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
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
    public Response getOnePage4Accept(String storeId,Integer startNum, Integer pageSize,String token){

    	Response res = new Response();
    	List<SaleLeadsModel> data = null;
        try{
    	    data = saleLeadsServiceMock.getOnePage4Accept(storeId, startNum, pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
    }
    
    /**
     * 获取店铺待接单的线索数
     * @param storeId 经销商ID
     * @return 经销商待分配的线索数
     */
    @RequestMapping(value="/get2AcceptCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2AcceptCount(String storeId,String token){

    	Response res = new Response();
    	Integer data = null;
        try{
    	    data = saleLeadsServiceMock.get2AcceptCount(storeId);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
    }
    
    
    
    /**
     * 导购员接单
     * @param acceptorId 导购员ID
     * @param saleLeadsId 线索ID
     * @return
     */
    @RequestMapping(value="/accept",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response accept(String acceptorId, String saleLeadsId,String token){

    	Response res = new Response();
        try{
        	res.resultCode = saleLeadsServiceMock.accept(acceptorId, saleLeadsId);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    }
    
    /**
     * 编辑销售线索订单信息
     * @param model
     * @return
     */
    @RequestMapping(value="/edit",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response edit(SaleLeadsModel model,String token){
    	Response res = new Response();
        try{
        	res.data = saleLeadsService.edit(model);
        	res.resultCode=ErrorCode.SUCCESS;
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
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
    public Response getOnePage4Acceptor2Followup(String acceptorId,Integer startNum, Integer pageSize,String token){ 	
    	Response res = new Response();
    	if (StringUtils.isEmpty(acceptorId)||startNum==null||pageSize==null) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
    	else {
    		List<SaleLeadsModel> data = null;
            try{
        	    data = saleLeadsService.getOnePage4Acceptor2Followup(acceptorId, startNum, pageSize);
            } catch(Throwable e){
            	LOG.error(e.getMessage(),e);
        	}
        	
        	res.data = data;
		}

    	return res;
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
    public Response getOnePage4AcceptorClosed(String acceptorId,Integer startNum, Integer pageSize,String token){
    	Response res = new Response();
    	if (StringUtils.isEmpty(acceptorId)||startNum==null||pageSize==null) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
		}
    	else {
    		List<SaleLeadsModel> data = null;
            try{
        	    data = saleLeadsService.getOnePage4AcceptorClosed(acceptorId, startNum, pageSize);
            } catch(Throwable e){
            	LOG.error(e.getMessage(),e);
        	}
        	
        	res.data = data;
		}
    	return res;
    }
    
    /**
     * 获取根据form条件查询一页的成功结单的数据
     * @param form
     * @param startNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getOnePageSuccessOrders",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getOnePageSuccessOrders(SaleLeadStatisticForm form,Integer startNum, Integer pageSize,String token){

    	Response res = new Response();
    	List<SaleLeadsModel> data = null;
        try{
    	    data = saleLeadsServiceMock.getOnePageSuccessOrders(form, startNum, pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	
    	res.data = data;

    	return res;
    	
    }
    
    
    /**
     * 获取根据form条件查询成功结单的金额
     * @param form
     * @param startNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getSuccessOrdersTtlAmount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response getSuccessOrdersTtlAmount(SaleLeadStatisticForm form,String token){
    	Response res = new Response();
        try{
        	res.data = saleLeadsServiceMock.getSuccessOrdersTtlAmount(form);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    }
    
    /**
     * 经销商批量下派到店铺
     * @param saleLeadsId2shopId 经销商ID=>shopId
     * @return
     */
    @RequestMapping(value="/distributeBatch",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response distributeBatch(String distributorId, Map<String,String> saleLeadsId2shopId,String token){
    	Response res = new Response();
    	if (StringUtils.isEmpty(distributorId)) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数distributorId错误";
		}
    	else {
    		for(Entry<String, String> entity:saleLeadsId2shopId.entrySet()) {
    			if (StringUtils.isEmpty(entity.getKey())||StringUtils.isEmpty(entity.getValue())) {
    				res.resultCode=ErrorCode.INVALID_PARAM;
    				res.message="参数错误";
				}
    			else {
    				try{
    		        	res.data = saleLeadsService.distributeBatch(distributorId, saleLeadsId2shopId);
    		        	res.resultCode=ErrorCode.SUCCESS;
    		        } catch(Throwable e){
    		        	LOG.error(e.getMessage(),e);
    		    	}
				}
    		}
    	}
        

    	return res;
    
    }
    
    /**
     * 经销商拒单
     * @param distributorId 经销商ID
     * @param saleLeadsId 销售线索ID
     * @param rejectType 拒单类型
     * @param rejectRemark 拒单备注
     * @return
     */
    @RequestMapping(value="/rejectBatch",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response rejectBatch(RejectBatchForm form,String token){
    	Response res = new Response();
    	
        try{
        	res.resultCode = saleLeadsServiceMock.rejectBatch(form.distributorId, form.saleLeadsIdList, form.rejectType, form.rejectRemark);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    }

    /**
     * 导购员批量接单
     * @param acceptorId 导购员ID
     * @param saleLeadsId 线索ID
     * @return
     */
    @RequestMapping(value="/acceptBatch",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response acceptBatch(AcceptBatchForm form,String token){
    	Response res = new Response();
    	
        try{
        	res.resultCode = saleLeadsServiceMock.acceptBatch(form.acceptorId, form.saleLeadsId);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    
    }
    
	/**
	 * <p>
	 * 根据sealLeadsId 获取详情
	 * @param saleLeadsId
	 * @return
	 */
    @RequestMapping(value="/getSaleLeads",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Response getSaleLeads(String saleLeadsId,String token){
    	Response res = new Response();
        try{
        	res.data = saleLeadsServiceMock.getSaleLeads(saleLeadsId);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	return res;
    }
}
