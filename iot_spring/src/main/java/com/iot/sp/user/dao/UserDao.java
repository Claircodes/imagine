package com.iot.sp.user.dao;

import java.util.List;
import java.util.Map;

import com.iot.sp.user.dto.UserInfo;

public interface UserDao {

	UserInfo selectUser(UserInfo user);
	List<UserInfo> selectUserList(Map hm);
}
