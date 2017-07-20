package com.dpmall.api.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * 登录返回结果
 * @author river
 * @date 2017-7-19-
 */
public class LoginResModel implements Serializable {
	
	private static final long serialVersionUID = 2238092228853902778L;

	/**用户逻辑主键*/
	public Long id;
	
	/**账户*/
    public String username;
    
    /**中文名称*/
    public String cnName;
    
    /**角色编码*/
    public String roleCode;
    
    /**代理商ID*/
    public Long agencyId;
    
    /**门店ID*/
    public Long storeId;
    
    /**登录token*/
    public String token;
    
    /**功能列表*/
    public Set<String> funcList;
}
