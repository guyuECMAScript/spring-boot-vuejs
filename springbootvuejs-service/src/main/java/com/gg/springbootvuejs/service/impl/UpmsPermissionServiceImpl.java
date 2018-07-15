package com.gg.springbootvuejs.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gg.springbootvuejs.base.entity.UpmsPermission;
import com.gg.springbootvuejs.biz.dao.UpmsPermissionBizMapper;
import com.gg.springbootvuejs.common.enums.PermissionTypeEnum;
import com.gg.springbootvuejs.service.UpmsPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service("upmsPermissionService")
public class UpmsPermissionServiceImpl implements UpmsPermissionService {
	@Autowired
	private UpmsPermissionBizMapper upmsPermissionBizMapper;

	@Override
	public JSONArray queryUserMenusByLoginId(String loginId) {
		List<UpmsPermission> list = upmsPermissionBizMapper.queryUserMenusByLoginId(loginId);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		Map<Integer, JSONArray> directoryArrayMap = new LinkedHashMap<Integer, JSONArray>();
		Map<Integer, JSONObject> directoryMap = new LinkedHashMap<Integer, JSONObject>();
		for (UpmsPermission up : list) {
			// 目录
			if (PermissionTypeEnum.TYPE_1.getCode().equals(up.getType().toString())) {
				directoryMap.put(up.getPermissionId(), (JSONObject) JSON.toJSON(up));
				continue;
			}
			// 菜单
			if (PermissionTypeEnum.TYPE_2.getCode().equals(up.getType().toString())) {
				JSONArray menuTempArray = directoryArrayMap.get(up.getPid());
				if (null == menuTempArray) {
					menuTempArray = new JSONArray();
				}
				menuTempArray.add(up);
				directoryArrayMap.put(up.getPid(), menuTempArray);
			}
		}

		JSONArray directoryArray = new JSONArray();
		Set<Map.Entry<Integer, JSONObject>> entrys = directoryMap.entrySet();
		JSONObject up = null;
		for (Map.Entry<Integer, JSONObject> entry : entrys) {
			up = entry.getValue();
			up.put("permissions", directoryArrayMap.get(entry.getKey()));
			directoryArray.add(up);
		}
		return directoryArray;
	}

	@Override
	public List<String> queryPermissionsByLoginId(String loginId) {
		List<UpmsPermission> list = upmsPermissionBizMapper.queryUserMenusByLoginId(loginId);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		List<String> values = new ArrayList<String>();
		for (UpmsPermission p : list) {
			values.add(p.getPermissionValue());
		}
		return values;
	}
}
