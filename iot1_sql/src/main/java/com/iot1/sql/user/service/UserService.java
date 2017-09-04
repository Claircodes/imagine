package com.iot1.sql.user.service;

import java.util.List;
import java.util.Map;

import com.iot1.sql.user.dto.UserInfo;

public interface UserService {
	public UserInfo getUser(UserInfo pUser);

	public List<UserInfo> getUserList(Map<String, Object> hm);
}
