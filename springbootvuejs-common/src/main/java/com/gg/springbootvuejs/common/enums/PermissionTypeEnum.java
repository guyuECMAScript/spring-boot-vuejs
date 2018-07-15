package com.gg.springbootvuejs.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PermissionTypeEnum {
	TYPE_1("1", "目录"), TYPE_2("2", "菜单"), TYPE_3("3", "按钮");
	private final String code;
	private final String desc;

	private PermissionTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<>();
		PermissionTypeEnum[] array = PermissionTypeEnum.values();
		for (PermissionTypeEnum e : array) {
			map.put(e.getCode(), e.getDesc());
		}
		return map;
	}

	public static List<String> getList() {
		List<String> list = new ArrayList<>();
		PermissionTypeEnum[] array = PermissionTypeEnum.values();
		for (PermissionTypeEnum e : array) {
			list.add(e.getCode());
		}
		return list;
	}

	public static boolean isContain(String code) {
		return getMap().containsKey(code);
	}
}
