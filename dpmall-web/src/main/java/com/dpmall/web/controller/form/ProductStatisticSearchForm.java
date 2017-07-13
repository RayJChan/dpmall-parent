package com.dpmall.web.controller.form;

import java.io.Serializable;

/**
 * 统计查询form
 * 
 * @author river
 * @date 2017-07-13
 */
public class ProductStatisticSearchForm implements Serializable {

	private static final long serialVersionUID = 6967677155662274907L;

	public String productCode;
	public String fromTime;
	public String endTime;
	public int start;
	public int pageSize;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
