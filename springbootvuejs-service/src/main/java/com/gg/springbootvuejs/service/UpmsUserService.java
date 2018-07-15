package com.gg.springbootvuejs.service;


import com.gg.springbootvuejs.base.entity.UpmsUser;

import java.util.List;

public interface UpmsUserService {
	List<UpmsUser> queryUserList();

	int queryUserCount();

	/**
	 * 根据登录账号查询用户信息
	 * 
	 * @param loginId
	 * @return
	 */
	UpmsUser queryUserInfoByLoginId(String loginId);

	/**
	 * 更新用户密码
	 * 
	 * @param upmsUser
	 */
	void updateUserPassword(UpmsUser upmsUser);

}
