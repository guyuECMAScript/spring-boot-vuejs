package com.gg.springbootvuejs.service;

import com.alibaba.fastjson.JSONArray;

import java.util.List;



public interface UpmsPermissionService {
	/**
	 * 根据登录账号查询用户菜单
	 * 
	 * @param loginId
	 * @return
	 */
	JSONArray queryUserMenusByLoginId(String loginId);

	/**
	 * 根据登录账号查询用户权限
	 * 
	 * @param loginId
	 *
	 * @return
	 */
	List<String> queryPermissionsByLoginId(String loginId);
}
