package com.dpmall.web.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dpmall.api.ISaleLeadsService;
import com.dpmall.api.bean.SaleLeadsModel;
import com.dpmall.api.common.TimeScope;
import com.dpmall.api.enums.ESaleLeadsOrderStatus;
import com.dpmall.api.err.ErrorCode;
import com.dpmall.api.param.SaleLeadStatisticParam;
import com.dpmall.common.DateUtils;

public class SaleLeadsServiceMock implements ISaleLeadsService {

	@Override
	public List<SaleLeadsModel> getOnePage4Distribute(String distributorId, Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = null;
			tmp.distributeTime = null;
			tmp.distributorId = null;
			tmp.distributorOperateTime = null;
			tmp.distributorUserName = null;
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTE_PEND.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate = null;
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = null;
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public Integer get2DistributeCount(String distributorId) {
		return 15;
	}

	@Override
	public int distribute(String distributorId, String saleLeadsId, String shopId) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public int reject(String distributorId, String saleLeadsId, String rejectType, String rejectRemark) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public List<SaleLeadsModel> getOnePage4Followup(String distributorId, Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = null;
			tmp.distributeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorId = distributorId == null? 123 : Long.valueOf(distributorId);
			tmp.distributorOperateTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorUserName = "zhangsan";
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTED.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate = null;
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = null;
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public List<SaleLeadsModel> getOnePageClosedSaleLeads(String distributorId,TimeScope distributeTime, String storeId,String saleLeadId, String clientName,String clientTel,String storeName,String acceptorId,Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorId = distributorId == null? 123 : Long.valueOf(distributorId);
			tmp.distributorOperateTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorUserName = "zhangsan";
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.SUCCESS.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate =  DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.storeAcceptor="12345";
			tmp.storeAcceptorName="zhangsan";
			tmp.storeAcceptorRemark ="这个客户买了很多东西";
			tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public List<SaleLeadsModel> getOnePage4Accept(String storeId, Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorId = 123456l;
			tmp.distributorOperateTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorUserName = "zhangsan";
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTED.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate =  DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = null;
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.storeAcceptor="12345";
			tmp.storeAcceptorName="zhangsan";
			tmp.storeAcceptorRemark ="这个客户买了很多东西";
			tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public Integer get2AcceptCount(String storeId) {
		return 13;
	}

	@Override
	public int accept(String acceptorId, String saleLeadsId) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public int edit(SaleLeadsModel model) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public List<SaleLeadsModel> getOnePage4Acceptor2Followup(String acceptorId, Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorId = 123456l;
			tmp.distributorOperateTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorUserName = "zhangsan";
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTED.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate =  DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = null;
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.storeAcceptor="12345";
			tmp.storeAcceptorName="zhangsan";
			tmp.storeAcceptorRemark ="这个客户买了很多东西";
			tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public List<SaleLeadsModel> getOnePage4AcceptorClosed(String acceptorId, Integer startNum, Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorId = 123456l;
			tmp.distributorOperateTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorUserName = "zhangsan";
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTED.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate =  DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = null;
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.storeAcceptor="12345";
			tmp.storeAcceptorName="zhangsan";
			tmp.storeAcceptorRemark ="这个客户买了很多东西";
			tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public List<SaleLeadsModel> getOnePageSuccessOrders(SaleLeadStatisticParam form, Integer startNum,
			Integer pageSize) {
		List<SaleLeadsModel> mockResults = new ArrayList<SaleLeadsModel>();
		if(pageSize == null){
			pageSize = 20;
		}
		for(int i = 0; i<pageSize ;i++){
			SaleLeadsModel tmp = new SaleLeadsModel();
			tmp.appointmentTime = null;
			tmp.budget = 10000.86;
			tmp.callServiceRemark="购买花洒两件，设计服务";
			tmp.callServiceTel = "18655645528";
			tmp.clientAddr = "广东省佛山市江南区38路192花园";
			tmp.clientName = "张三";
			tmp.clientRemark = "希望设计师和我具体沟通";
			tmp.clientTel = "18566754854";
			tmp.closeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributeTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorId = 123456l;
			tmp.distributorOperateTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.distributorUserName = "zhangsan";
			tmp.id = (long)(123456+i);
			tmp.recommendstoreId = (long)(123456+i);
			tmp.recommendstoreName = "广东省佛山市江南区直营店";
			tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTED.getCode();
			tmp.serviceAddress= "广东省佛山市江南区38路192花园";
			tmp.serviceCatelog = "A1";
			tmp.serviceDate =  DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.serviceTitle = "购买花洒两件，设计服务";
			tmp.storeAcceptTime = null;
			tmp.style = "欧式";
			tmp.total = 0.0;
			tmp.storeAcceptor="12345";
			tmp.storeAcceptorName="zhangsan";
			tmp.storeAcceptorRemark ="这个客户买了很多东西";
			tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
			tmp.brand="东鹏";
			tmp.agencyRemark="这个客户是VIP客户，请有待";
			mockResults.add(tmp);
		}
		return mockResults;
	}

	@Override
	public Double getSuccessOrdersTtlAmount(SaleLeadStatisticParam form) {
		return 168.888;
	}

	@Override
	public int distributeBatch(String distributorId, Map<String, String> saleLeadsId2shopId) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public int rejectBatch(String distributorId, List<String> saleLeadsIdList, String rejectType, String rejectRemark) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public int acceptBatch(String acceptorId, List<String> saleLeadsId) {
		return ErrorCode.SUCCESS;
	}

	@Override
	public SaleLeadsModel getSaleLeads(String saleLeadsId) {

		SaleLeadsModel tmp = new SaleLeadsModel();
		tmp.appointmentTime = null;
		tmp.budget = 10000.86;
		tmp.callServiceRemark="购买花洒两件，设计服务";
		tmp.callServiceTel = "18655645528";
		tmp.clientAddr = "广东省佛山市江南区38路192花园";
		tmp.clientName = "张三";
		tmp.clientRemark = "希望设计师和我具体沟通";
		tmp.clientTel = "18566754854";
		tmp.closeTime = null;
		tmp.distributeTime = null;
		tmp.distributorId = null;
		tmp.distributorOperateTime = null;
		tmp.distributorUserName = null;
		tmp.id = (long)(123456+142);
		tmp.recommendstoreId = (long)(123456+142);
		tmp.recommendstoreName = "广东省佛山市江南区直营店";
		tmp.saleLeadsStatus = ESaleLeadsOrderStatus.DISTRIBUTE_PEND.getCode();
		tmp.serviceAddress= "广东省佛山市江南区38路192花园";
		tmp.serviceCatelog = "A1";
		tmp.serviceDate = null;
		tmp.serviceTitle = "购买花洒两件，设计服务";
		tmp.storeAcceptTime = null;
		tmp.style = "欧式";
		tmp.total = 0.0;
		tmp.storeAcceptor="12345";
		tmp.storeAcceptorName="zhangsan";
		tmp.storeAcceptorRemark ="这个客户买了很多东西";
		tmp.storeAcceptTime = DateUtils.format(new Date(),DateUtils.YYYY_MM_DD_HH_MM_SS);
		tmp.brand="东鹏";
		tmp.agencyRemark="这个客户是VIP客户，请有待";
		return tmp;
	}

}
