package com.iot1.sql.maria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.maria.dao.MariaDao;
import com.iot1.sql.maria.dto.MariaInfo;

@Service
public class MariaServiceImpl implements MariaService {

	@Autowired
	MariaDao mDao;
	@Override
	public List<MariaInfo> getMariaInfoList(MariaInfo mi) {
		return mDao.selectMaria(mi);
	}

}
