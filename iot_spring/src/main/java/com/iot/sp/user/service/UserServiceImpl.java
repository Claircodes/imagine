package com.iot.sp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.sp.user.dao.UserDao;
import com.iot.sp.user.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public UserInfo getUser(UserInfo pUser) {
		UserInfo user = (UserInfo)userDao.selectUser(pUser);
		if(user!=null && user.getUserpwd().equals(pUser.getUserpwd())){
			return user;
		}
		return null;
	}

}
