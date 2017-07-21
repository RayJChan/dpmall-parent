package com.dpmall.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.api.param.SaleLeadStatisticParam;
import com.dpmall.common.DateUtils;
import com.dpmall.web.Constants;
import com.dpmall.web.controller.form.AcceptBatchForm;
import com.dpmall.web.controller.form.DistributeForm;
import com.dpmall.web.controller.form.RejectBatchForm;
import com.dpmall.web.controller.form.Response;
import com.dpmall.web.controller.form.SaleLeadForm;
import com.dpmall.web.controller.form.SaleLeadOrderForm;

/**
 * 销售线索
 * @author river
 * @date 2017-7-14
 */
@Controller
@RequestMapping("/saleLeads")
public class SaleLeadsController {
	private static final Logger LOG = LoggerFactory.getLogger(SaleLeadsController.class);
	
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
    public Response getOnePage4Distribute(@RequestBody DistributeForm form){
    	LOG.info("{method:'SaleLeadsController::getOnePage4Distribute',in:" + JSON.toJSONString(form) + "}");

    	Response res = new Response();
        try{
        	res.data = saleLeadsService.getOnePage4Distribute(form.distributorId, form.startNum, form.pageSize);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'SaleLeadsController::getOnePage4Distribute',out:{res:'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 获取经销商待分配的线索数
     * @param distributorId 经销商ID
     * @return 经销商待分配的线索数
     */
    @RequestMapping(value="/get2DistributeCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2DistributeCount(@RequestBody DistributeForm form){
    	LOG.info("{method:'SaleLeadsController::get2DistributeCount',in:" + JSON.toJSONString(form) + "}");

    	Response res = new Response();
        try{
        	res.data  = saleLeadsService.get2DistributeCount(form.distributorId);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'SaleLeadsController::get2DistributeCount',out:{res:'" + JSON.toJSONString(res) + "'}}");
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
    public Response distribute(@RequestBody DistributeForm form){
    	return this.distributeBatch(form);
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
    public Response reject(@RequestBody RejectBatchForm form){
    	return this.rejectBatch(form);
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
    public Response getOnePage4Followup(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::getOnePage4Followup',in:" + JSON.toJSONString(form) + "}");

		Response res = new Response();
		try {
			res.data = saleLeadsService.getOnePage4Followup(form.distributorId, form.startNum, form.pageSize);
		} catch (Throwable e) {
			res.resultCode = ErrorCode.INTERNAL_ERR;
			LOG.error(e.getMessage(), e);
		}

    	LOG.info("{method:'SaleLeadsController::getOnePage4Followup',out:{res:'" + JSON.toJSONString(res) + "'}}");
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
    public Response getOnePageClosedSaleLeads(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::getOnePageClosedSaleLeads',in:" + JSON.toJSONString(form) + "}");
	
    	Response res = new Response();
        try{
          	TimeScope distributeTime = null;
        	if(form.distributeTimeBegin != null && form.distributeTimeEnd != null){
        		distributeTime = new TimeScope();
        		distributeTime.begin = DateUtils.parse(form.distributeTimeBegin, DateUtils.YYYY_MM_DD_HH_MM_SS);
        		distributeTime.end = DateUtils.parse(form.distributeTimeEnd, DateUtils.YYYY_MM_DD_HH_MM_SS);
        	}
        	res.data = saleLeadsService.getOnePageClosedSaleLeads(form.distributorId, distributeTime, String.valueOf(form.storeId), form.saleLeadsId, form.clientName, form.clientTel, form.storeName,form.startNum, form.pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}

    	LOG.info("{method:'SaleLeadsController::getOnePageClosedSaleLeads',out:{res:'" + JSON.toJSONString(res) + "'}}");
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
    public Response getOnePage4Accept(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::getOnePage4Accept',in:" + JSON.toJSONString(form) + "}");
    	
		Response res = new Response();
		if (form.storeId == null) {
			res.resultCode = ErrorCode.INVALID_PARAM;
			return res;
		}

        try{
        	res.resultCode = ErrorCode.SUCCESS;
        	res.data = saleLeadsService.getOnePage4Accept(String.valueOf(form.storeId), form.startNum == null ? 0:form.startNum, form.pageSize == null ? Constants.DEFAULT_PAGESIZE : form.pageSize);
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'SaleLeadsController::getOnePage4Accept',out:{res:'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 获取店铺待接单的线索数
     * @param storeId 经销商ID
     * @return 经销商待分配的线索数
     */
    @RequestMapping(value="/get2AcceptCount",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response get2AcceptCount(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::get2AcceptCount',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
    	 if(form.storeId == null){
          	res.resultCode = ErrorCode.INVALID_PARAM;
      		return res;
      	}
        try{
        	res.data = saleLeadsService.get2AcceptCount(String.valueOf(form.storeId));
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'SaleLeadsController::get2AcceptCount',out:{res:'" + JSON.toJSONString(res) + "'}}");
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
    public Response accept(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::accept',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
        try{
        	res.data = saleLeadsService.accept(form.acceptorId, form.saleLeadsId);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
		LOG.info("{method:'SaleLeadsController::accept',out:{res'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    /**
     * 编辑销售线索订单信息
     * @param model
     * @return
     */
    @RequestMapping(value="/edit",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response edit(@RequestBody SaleLeadOrderForm form){
    	LOG.info("{method:'SaleLeadsController::edit',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
    	try{
    		SaleLeadsModel saleLeadsModel = this.convert(form);       
        	res.data = saleLeadsService.edit(saleLeadsModel);
        	res.resultCode=ErrorCode.SUCCESS;
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
    	LOG.info("{method:'SaleLeadsController::edit',out:{res'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    private SaleLeadsModel convert(SaleLeadOrderForm form ){
    	//TODO xiecong
    	return null;
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
    public Response getOnePage4Acceptor2Followup(@RequestBody SaleLeadForm form){     	
    	LOG.info("{method:'SaleLeadsController::getOnePage4Acceptor2Followup',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
    	if (StringUtils.isEmpty(form.acceptorId)) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
			return res;
		}
    	
		try {
			res.data = saleLeadsService.getOnePage4Acceptor2Followup(form.acceptorId, form.startNum == null?0:form.startNum, form.pageSize == null ? Constants.DEFAULT_PAGESIZE : form.pageSize);
		} catch (Throwable e) {
			LOG.error(e.getMessage(), e);
		}

		LOG.info("{method:'SaleLeadsController::getOnePage4Acceptor2Followup',out:{res'" + JSON.toJSONString(res) + "'}}");
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
    public Response getOnePage4AcceptorClosed(@RequestBody SaleLeadForm form){    	
    	LOG.info("{method:'SaleLeadsController::getOnePage4AcceptorClosed',in:" + JSON.toJSONString(form) + "}");
    
    	Response res = new Response();
    	if (StringUtils.isEmpty(form.acceptorId)) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数错误";
			return res;
		}
    	
		try {
			res.data = saleLeadsService.getOnePage4AcceptorClosed(form.acceptorId, form.startNum == null?0:form.startNum, form.pageSize == null ? Constants.DEFAULT_PAGESIZE : form.pageSize);
		} catch (Throwable e) {
			res.resultCode = ErrorCode.INTERNAL_ERR;
			LOG.error(e.getMessage(), e);
		}
		
		LOG.info("{method:'SaleLeadsController::getOnePage4AcceptorClosed',out:{res'" + JSON.toJSONString(res) + "'}}");

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
    public Response getOnePageSuccessOrders(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::getOnePageSuccessOrders',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
    	SaleLeadStatisticParam param = this.convert(form);
        try{
        	res.data = saleLeadsService.getOnePageSuccessOrders(param, form.startNum, form.pageSize);
    	    res.resultCode = ErrorCode.SUCCESS;
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'SaleLeadsController::getOnePageSuccessOrders',out:{res'" + JSON.toJSONString(res) + "'}}");
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
    public Response getSuccessOrdersTtlAmount(@RequestBody SaleLeadForm form){
    	LOG.info("{method:'SaleLeadsController::getSuccessOrdersTtlAmount',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
    	SaleLeadStatisticParam param = this.convert(form);
        try{
        	res.data = saleLeadsService.getSuccessOrdersTtlAmount(param);
    	    res.resultCode = ErrorCode.SUCCESS;
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
    	LOG.info("{method:'SaleLeadsController::getSuccessOrdersTtlAmount',out:{res'" + JSON.toJSONString(res) + "'}}");
    	return res;
    }
    
    private SaleLeadStatisticParam convert(SaleLeadForm in){
    	SaleLeadStatisticParam param = new SaleLeadStatisticParam();
    	param.acceptorName = in.acceptorName;
    	param.fromTime = in.fromTime;
    	param.toTime = in.toTime;
    	param.productCatelog = in.productCatelog;
    	param.storeId = in.storeId;
    	return param;
    	
    }
    
    /**
     * 经销商批量下派到店铺
     * @param saleLeadsId2shopId 经销商ID=>shopId
     * @return
     */
    @RequestMapping(value="/distributeBatch",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
    public Response distributeBatch(@RequestBody DistributeForm form){
    	LOG.info("{method:'SaleLeadsController::distributeBatch',in:" + JSON.toJSONString(form) + "}");
    	
    	Response res = new Response();
    	if (StringUtils.isEmpty(form.distributorId) || form.saleLeadsId2shopId == null || form.saleLeadsId2shopId.isEmpty()) {
			res.resultCode=ErrorCode.INVALID_PARAM;
			res.message="参数distributorId错误";
			return res;
		}

		try{
        	res.data = saleLeadsService.distributeBatch(form.distributorId, form.saleLeadsId2shopId);
        	res.resultCode=ErrorCode.SUCCESS;
        } catch(Throwable e){
        	LOG.error(e.getMessage(),e);
    	}
		LOG.info("{method:'SaleLeadsController::distributeBatch',out:{res:'" + JSON.toJSONString(res) + "'}}");
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
    public Response rejectBatch(@RequestBody RejectBatchForm form){
    	LOG.info("{method:'SaleLeadsController::rejectBatch',in:" + JSON.toJSONString(form) + "}");
	
    	Response res = new Response();
        try{
        	res.data = saleLeadsService.rejectBatch(form.distributorId, form.saleLeadsIdList, form.rejectType, form.rejectRemark);
        	res.resultCode = ErrorCode.SUCCESS;
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        LOG.info("{method:'SaleLeadsController::rejectBatch',out:{res:'" + JSON.toJSONString(res) + "'}}");
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
    public Response acceptBatch(@RequestBody AcceptBatchForm form){
    	Response res = new Response();
    	
    	LOG.info("{method:'SaleLeadsController::acceptBatch',in:" + JSON.toJSONString(form) + "}");
        try{
        	res.data = saleLeadsService.acceptBatch(form.acceptorId, form.saleLeadsId);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
        if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::acceptBatch',out:"+JSON.toJSONString(res.data)+"}");
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
	public Response getSaleLeads(@RequestBody SaleLeadForm form){
    	Response res = new Response();
    	if (LOG.isInfoEnabled()) {
			LOG.info("{method:'SaleLeadsServiceFacade::getSaleLeads',in:" + JSON.toJSONString(form) +"}");
		}
        try{
        	res.data = saleLeadsService.getSaleLeads(form.saleLeadsId);
        } catch(Throwable e){
        	res.resultCode = ErrorCode.INTERNAL_ERR;
        	LOG.error(e.getMessage(),e);
    	}
        
        if(LOG.isDebugEnabled()){
			LOG.info("{method:'SaleLeadsServiceFacade::getSaleLeads',out:"+JSON.toJSONString(res.data)+"}");
		}

        LOG.info(com.alibaba.fastjson.JSON.toJSONString(res));
    	return res;
    }
}
