package com.iot1.sql.maria.service;

import java.util.List;

import com.iot1.sql.maria.dto.MariaInfo;

public interface MariaService {
	public List<MariaInfo> getMariaInfoList(MariaInfo mi);
}
