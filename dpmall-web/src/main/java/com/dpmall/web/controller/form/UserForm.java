package com.dpmall.web.controller.form;

public class UserForm extends RequestForm{
	/**逻辑主键*/
	public Long id;
	
	/**用户名*/
    public String username;
    
    /**密码**/
    public String password;
    
    /**中文名*/
    public String cnName;
    
    /**角色编码*/
    public String roleCode;
    
    /**经销商ID*/
    public Long agencyId;
    
    /**门店ID*/
    public Long storeId;
}
