package com.iot1.sql.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.goods.dao.GoodsDAO;
import com.iot1.sql.goods.dto.GoodsInfo;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDAO gdao;

	@Override
	public GoodsInfo getGoodsInfo(GoodsInfo gi) {
		return gdao.selectGoodsInfo(gi);
	}

	@Override
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo gi) {
		return gdao.selectGoodInfoList(gi);
	}

	@Override
	public int insertGoodsList(GoodsInfo[] goodsList) {
		int rCnt = 0;
		for (GoodsInfo gi : goodsList) {
			rCnt += gdao.saveGoodsInfo(gi);
		}
		return rCnt;
	}

	@Override
	public int updateGoodsList(GoodsInfo[] goodsList) {
		int rCnt = 0;
		for (GoodsInfo gi : goodsList) {
			rCnt += gdao.updateGoodsInfo(gi);
		}
		return rCnt;
	}

	@Override
	public int deleteGoodsList(GoodsInfo[] goodsList) {
		int rCnt = 0;
		for (GoodsInfo gi : goodsList) {
			rCnt += gdao.deleteGoodsInfo(gi);
		}
		return rCnt;
	}

	@Override
	public int insertGoods(GoodsInfo gi) {
		return gdao.saveGoodsInfo(gi);
	}

	@Override
	public int updateGoods(GoodsInfo gi) {
		return gdao.updateGoodsInfo(gi);
	}

	@Override
	public int deleteGoods(GoodsInfo gi) {
		return gdao.deleteGoodsInfo(gi);
	}
}
