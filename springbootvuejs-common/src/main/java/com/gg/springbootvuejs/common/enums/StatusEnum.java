package com.gg.springbootvuejs.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum StatusEnum {
	STATUS_IN_USE("1", "生效中"), STATUS_UN_USE("0", "未生效"), ;
	private final String code;
	private final String desc;

	private StatusEnum(String code, String desc) {
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
		StatusEnum[] array = StatusEnum.values();
		for (StatusEnum e : array) {
			map.put(e.getCode(), e.getDesc());
		}
		return map;
	}

	public static List<String> getList() {
		List<String> list = new ArrayList<>();
		StatusEnum[] array = StatusEnum.values();
		for (StatusEnum e : array) {
			list.add(e.getCode());
		}
		return list;
	}

	public static boolean isContain(String code) {
		return getMap().containsKey(code);
	}
}
