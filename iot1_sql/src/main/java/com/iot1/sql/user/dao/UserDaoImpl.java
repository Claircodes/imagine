package com.iot1.sql.user.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;
import com.iot1.sql.user.dto.UserInfo;

@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public UserInfo selectUser(UserInfo user){
		return this.getSqlSession().selectOne("userinfo.SELECT_USER2",user);
	}
	@Override
	public List<UserInfo> selectUserList(UserInfo user){
		return this.getSqlSession().selectList("userinfo.SELECT_USER_LIST",user);
	}

	@Override
	public int insertUserList(UserInfo[] userList) {
		return this.getSqlSession().insert("userinfo.INSERT_USER",userList);
	}
	@Override
	public int insertUser(UserInfo user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
