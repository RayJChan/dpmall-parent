package com.dpmall.api.bean;

import java.io.Serializable;

/**
 * 用户对象
 * @author river
 * @date 2017-07-19
 */
public class UserModel implements Serializable {
	private static final long serialVersionUID = -8212307574511449520L;

	/**逻辑主键*/
	public Long id;
	
	/**用户名*/
    public String username;
    
    /**中文名*/
    public String cnName;
    
    /**角色编码*/
    public String roleCode;
    
    /**经销商ID*/
    public Long agencyId;
    
    /**门店ID*/
    public Long storeId;
}
