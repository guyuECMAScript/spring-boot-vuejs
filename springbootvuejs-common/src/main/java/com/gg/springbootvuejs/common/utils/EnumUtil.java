package com.gg.springbootvuejs.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class EnumUtil {
//	private static Logger logger = LoggerFactory.getLogger(EnumUtil.class);

	/**
	 * 存放单个枚举对象 map常量定义
	 */
	private static Map<String, String> SINGLE_ENUM_MAP = null;
	/**
	 * 存放单个枚举对象 list常量定义
	 */
	private static List<String> SINGLE_ENUM_LIST = null;
	/**
	 * 枚举类map
	 */
	private static final Map<String, Map<String, String>> ENUM_MAP = new HashMap<String, Map<String, String>>();
	/**
	 * 枚举类list
	 */
	private static final Map<String, List<String>> ENUM_LIST = new HashMap<String, List<String>>();

	/**
	 * getMap 锁
	 */
	private static ReentrantLock mapLock = new ReentrantLock();
	/**
	 * getList 锁
	 */
	private static ReentrantLock listLock = new ReentrantLock();

	/**
	 * 枚举类
	 * 
	 * @param clazz
	 * @return
	 */
	public static Map<String, String> getMap(
			@SuppressWarnings("rawtypes") Class clazz) {
		if (ENUM_MAP.containsKey(clazz.getName())) {
			return ENUM_MAP.get(clazz.getName());
		}

		if (clazz.isEnum()) {
			try {
				mapLock.lock();
				SINGLE_ENUM_MAP = new HashMap<String, String>();
				Object[] array = clazz.getEnumConstants();
				for (Object o : array) {
					Method method1 = null;
					Method method2 = null;
					try {
						method1 = o.getClass().getDeclaredMethod("getCode");
						method2 = o.getClass().getDeclaredMethod("getDesc");
					} catch (NoSuchMethodException | SecurityException e) {
						throw new RuntimeException(
								"com.gg.springbootvuejs.common.utils.EnumUtil.getMap failed, Exception:\n",
								e);
					}

					try {
						SINGLE_ENUM_MAP.put(method1.invoke(o).toString(),
								method2.invoke(o).toString());
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						throw new RuntimeException(
								"com.gg.springbootvuejs.common.utils.EnumUtil.getMap failed, Exception:\n",
								e);
					}
				}
				ENUM_MAP.put(clazz.getName(), SINGLE_ENUM_MAP);

			} finally {
				mapLock.unlock();
			}
		}

		return SINGLE_ENUM_MAP;
	}

	/**
	 * 获取枚举类 code list 集合
	 * 
	 * @return
	 */
	public static List<String> getList(@SuppressWarnings("rawtypes") Class clazz) {

		if (ENUM_LIST.containsKey(clazz.getName())) {
			return ENUM_LIST.get(clazz.getName());
		}

		if (clazz.isEnum()) {
			try {
				listLock.lock();
				SINGLE_ENUM_LIST = new ArrayList<>();
				Object[] array = clazz.getEnumConstants();
				for (Object o : array) {
					Method method1 = null;
					try {
						method1 = o.getClass().getDeclaredMethod("getCode");
					} catch (NoSuchMethodException | SecurityException e) {
						throw new RuntimeException(
								"com.gg.springbootvuejs.common.utils.EnumUtil.getList failed, Exception:\n",
								e);
					}

					try {
						SINGLE_ENUM_LIST.add(method1.invoke(o).toString());
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						throw new RuntimeException(
								"com.gg.springbootvuejs.common.utils.EnumUtil.getList failed, Exception:\n",
								e);
					}
				}
				ENUM_LIST.put(clazz.getName(), SINGLE_ENUM_LIST);
			} finally {
				listLock.unlock();
			}
		}

		return SINGLE_ENUM_LIST;
	}

	/**
	 * 判断传入枚举类是否包含传入code
	 * 
	 * @param clazz
	 * @param code
	 * @return true 包含| false 不包含
	 */
	public static boolean isContain(@SuppressWarnings("rawtypes") Class clazz,
			String code) {
		if (ENUM_MAP.containsKey(clazz.getName())) {
			return ENUM_MAP.get(clazz.getName()).containsKey(code);
		}
		return getMap(clazz).containsKey(code);
	}
}
