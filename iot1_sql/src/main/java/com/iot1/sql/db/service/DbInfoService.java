package com.iot1.sql.db.service;

import java.util.List;

import com.iot1.sql.db.dto.Column;
import com.iot1.sql.db.dto.DataBase;
import com.iot1.sql.db.dto.DbInfo;
import com.iot1.sql.db.dto.Table;

public interface DbInfoService {
	public List<DbInfo> getDbInfoList(DbInfo di);

	public boolean isConnecteDB(DbInfo pDi) throws Exception;

	public List<DataBase> getDataBaseList() throws Exception;

	public List<Table> getTableList(DataBase di) throws Exception;


	public List<Column> getColumnList(Column c);

}
