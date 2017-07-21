package com.dpmall.web.controller.form;

import java.util.Map;

public class DistributeForm extends RequestForm {
	/**经销商账户ID*/
	public String distributorId;
	
	/**线索ID=》店铺ID*/
	public Map<String,String> saleLeadsId2shopId;
}
