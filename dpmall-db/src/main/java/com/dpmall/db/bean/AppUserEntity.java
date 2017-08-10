package com.dpmall.db.bean;

/**
 * @author xiecong
 *
 */
public class AppUserEntity {
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
    
    /**手机号码**/
    public String telePhone;
    
    /**店铺名称**/
    public String storeName;
    
    /**店铺（经销商）地址**/
    public String storeAddress;
}
