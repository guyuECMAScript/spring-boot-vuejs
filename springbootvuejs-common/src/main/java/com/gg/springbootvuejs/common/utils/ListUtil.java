package com.gg.springbootvuejs.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
//	private static Logger logger = LoggerFactory.getLogger(ListUtil.class);

	public static void main(String[] args) {
		List<User> userlist = new ArrayList<User>();
		userlist.add(new User("xiaom", 10));
		userlist.add(new User("xxx", 20));
		copy(userlist, Teahcer.class);
	}

	@SuppressWarnings("rawtypes")
	public static <T> List copy(List srcList, Class<T> clazz) {
		if (CollectionUtils.isEmpty(srcList)) {
			return null;
		}
		List<T> result = new ArrayList<T>(srcList.size());
		for (Object o : srcList) {
			try {
				T t = clazz.newInstance();
				BeanUtils.copyProperties(o, t);
				result.add(t);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(
						"com.gg.springbootvuejs.common.utils.ListUtil.copy failed, Exception:\n",
						e);
			}
		}
		return result;
	}
}

class User {

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Teahcer {
	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Teahcer [name=" + name + ", age=" + age + "]";
	}

}
