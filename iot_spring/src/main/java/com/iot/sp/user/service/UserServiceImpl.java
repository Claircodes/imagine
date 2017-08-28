package com.iot.sp.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.sp.user.dao.UserDao;
import com.iot.sp.user.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public UserInfo getUser(UserInfo pUser) {
		UserInfo user = (UserInfo) userDao.selectUser(pUser);
		if (user != null && user.getUserPwd().equals(pUser.getUserPwd())) {
			return user;
		}
		return null;
	}

	@Override
	public List<UserInfo> getUserList(Map hm) {
		return userDao.selectUserList(hm);
	}

}
