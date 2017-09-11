package com.iot1.sql.maria.dao;

import java.util.List;

import com.iot1.sql.maria.dto.MariaInfo;

public interface MariaDao {

	public List<MariaInfo> selectMaria(MariaInfo mi);
}
