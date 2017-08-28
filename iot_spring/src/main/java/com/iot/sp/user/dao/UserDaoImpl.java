package com.iot.sp.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.iot.sp.user.dto.UserInfo;

@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public UserInfo selectUser(UserInfo user){
		return this.getSqlSession().selectOne("userinfo.SELECT_USER2",user);
	}
	public List<UserInfo> selectUserList(Map hm){
		return this.getSqlSession().selectList("userinfo.SELECT_USER_LIST",hm);
	}
}
