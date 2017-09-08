package com.iot1.sql.goods.dao;

import java.util.List;

import com.iot1.sql.goods.dto.GoodsInfo;

public interface GoodsDAO {
	public GoodsInfo selectGoodsInfo(GoodsInfo gi);

	public List<GoodsInfo> selectGoodInfoList(GoodsInfo gi);

	public int saveGoodsInfo(GoodsInfo goodsList);

	public int updateGoodsInfo(GoodsInfo goodsList);

	public int deleteGoodsInfo(GoodsInfo goodsList);

}
