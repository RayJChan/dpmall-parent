package com.dpmall.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpmall.api.bean.PrepayModel;
import com.dpmall.api.bean.SaleLeadsGoodsModel;
import com.dpmall.api.common.TimeScope;

@Controller
@RequestMapping("/saleLeads")
public class PrepayController {

    
	/**
	 * 核销
	 * @param prepayCode 核销码
	 * @param ttlAmount 核销订单总金额
	 * @param goodsList 订单数据
	 * @return
	 */
    @RequestMapping(value="/writeoff",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public Integer writeoff(String prepayCode,Double ttlAmount,List<SaleLeadsGoodsModel> goodsList){
		return 0;
	}
	
	
	/**
	 * 获取待核销的一页特权定金
	 * @param storeId 门店ID
	 * @param prepayTime 预付时间
	 * @param clientName 客户名称
	 * @param clientTel 客户电话
	 * @param startNum 开始数
	 * @param pageSize 页码
	 * @return
	 */
    @RequestMapping(value="/getOnePage2WriteOff",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public List<PrepayModel> getOnePage2WriteOff(String storeId,TimeScope prepayTime, String clientName, String clientTel,Integer startNum, Integer pageSize){
		return null;
	}
	
	/**
	 * 获取待核销的一页特权定金
	 * @param storeId 门店ID
	 * @param prepayTime 预付时间
	 * @param clientName 客户名称
	 * @param clientTel 客户电话
	 * @param startNum 开始数
	 * @param pageSize 页码
	 * @return
	 */
    @RequestMapping(value="/getOnePageClosedPrepay",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json") 
    @ResponseBody
	public List<PrepayModel> getOnePageClosedPrepay(String storeId,TimeScope prepayTime, String clientName, String clientTel,Integer startNum, Integer pageSize){
    	return null;
    }

}
