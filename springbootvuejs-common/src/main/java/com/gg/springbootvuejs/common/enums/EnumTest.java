package com.gg.springbootvuejs.common.enums;


import com.gg.springbootvuejs.common.utils.EnumUtil;

public class EnumTest {
	public static void main(String[] args) {
		// System.out.println(StatusEnum.getList());
		// System.out.println(StatusEnum.getMap());
		// System.out.println(StatusEnum.isContain("2"));
		// System.out.println(StatusEnum.isContain("1"));
		System.out.println(EnumUtil.getMap(StatusEnum.class));
		System.out.println(EnumUtil.getList(StatusEnum.class));
		System.out.println(EnumUtil.isContain(StatusEnum.class, "1"));
		System.out.println(EnumUtil.isContain(StatusEnum.class, "2"));
	}
}
