package com.iot.sp.user.dao;

import com.iot.sp.user.dto.UserInfo;

public interface UserDao {

	UserInfo selectUser(UserInfo user);

}
