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

	public Long id;
	
    public String username;
    
    public String cnName;
    
    public String roleCode;
    
    public Long agencyId;
    
    public Long storeId;
    
    public String token;
    
    public Set<String> funcList;
}
