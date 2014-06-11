package cn.com.xb.service.impl;

import java.util.List;

import cn.com.xb.daox.IUserRoleDaox;
import cn.com.xb.domain.base.UserRole;
import cn.com.xb.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {

	private IUserRoleDaox userRoleDaox;
	
	public void setUserRoleDaox(IUserRoleDaox userRoleDaox) {
		this.userRoleDaox = userRoleDaox;
	}

	public List<UserRole> getUserRoleByUserId(String userId) throws Exception {
		return userRoleDaox.loadUserRoleByUserId(userId);
	}

}
