package com.gg.springbootvuejs.service.impl;

import com.gg.springbootvuejs.base.dao.UpmsUserMapper;
import com.gg.springbootvuejs.base.entity.UpmsUser;
import com.gg.springbootvuejs.base.entity.UpmsUserExample;
import com.gg.springbootvuejs.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;



@Service("upmsUserService")
public class
UpmsUserServiceImpl implements UpmsUserService {
	@Autowired
	private UpmsUserMapper upmsUserMapper;

	@Override
	public List<UpmsUser> queryUserList() {
		return upmsUserMapper.selectByExample(new UpmsUserExample());
	}

	@Override
	public int queryUserCount() {
		return (int) upmsUserMapper.countByExample(new UpmsUserExample());
	}

	@Override
	public UpmsUser queryUserInfoByLoginId(String loginId) {
		UpmsUserExample example = new UpmsUserExample();
		example.createCriteria().andLoginIdEqualTo(loginId);
		List<UpmsUser> list = upmsUserMapper.selectByExample(example);

		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public void updateUserPassword(UpmsUser upmsUser) {
		// TODO Auto-generated method stub

	}
}
