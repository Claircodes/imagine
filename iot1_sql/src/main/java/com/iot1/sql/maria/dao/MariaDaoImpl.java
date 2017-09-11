package com.iot1.sql.maria.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.iot1.sql.maria.dto.MariaInfo;

@Service
public class MariaDaoImpl extends SqlSessionDaoSupport implements MariaDao {

	@Override
	public List<MariaInfo> selectMaria(MariaInfo mi) {
		return this.getSqlSession().selectList("SELECT_MARIA",mi);
	}

}
