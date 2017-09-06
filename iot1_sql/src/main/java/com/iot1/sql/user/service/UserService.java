package com.iot1.sql.user.service;

import java.util.List;

import com.iot1.sql.user.dto.UserInfo;

public interface UserService {
	public UserInfo getUser(UserInfo pUser);
	public List<UserInfo> selectUserList(UserInfo hm);
	public int insertUserList(UserInfo[] userList);
	public int insertUser(UserInfo user);
}
