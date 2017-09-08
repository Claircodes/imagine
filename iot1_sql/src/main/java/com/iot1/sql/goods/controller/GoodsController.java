package com.iot1.sql.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot1.sql.goods.dao.GoodsDAO;
import com.iot1.sql.goods.dto.GoodsInfo;
import com.iot1.sql.goods.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService gs;
	@Autowired
	private GoodsDAO gDao;

	@RequestMapping(value = "/goods/list", method = RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> getGoodsInfoList(GoodsInfo gi) {
		return gs.getGoodsInfoList(gi);
	}

	@RequestMapping(value = "/goods/create", method = RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> saveGoodsInfoList(@RequestBody GoodsInfo[] goodsList) {
		int rCnt = gs.insertGoodsList(goodsList);
		for (GoodsInfo gi : goodsList) {
			System.out.println(gi);
		}
		System.out.println("----------rCnt--->"+rCnt);
		return getGoodsInfoList(null);
	}
	
	@RequestMapping(value="/goods/update", method = RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> updateGoodsInfoList(@RequestBody GoodsInfo[] goodsList){
		int rCnt = gs.updateGoodsList(goodsList);
		for (GoodsInfo gi : goodsList) {
			System.out.println(gi);
		}
		System.out.println("----------rCnt--->"+rCnt);
		return getGoodsInfoList(null);
	}
	
	@RequestMapping(value="/goods/delete", method = RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> deleteGoodsInfoList(@RequestBody GoodsInfo[] goodsList){
		int rCnt = gs.deleteGoodsList(goodsList);
		for (GoodsInfo gi : goodsList) {
			System.out.println(gi);
		}
		System.out.println("----------rCnt--->"+rCnt);
		return getGoodsInfoList(null);
	}
	@RequestMapping(value = "/goods/createone", method = RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> saveGoodsInfo(@RequestBody GoodsInfo gi) {
		gs.insertGoods(gi);
		return getGoodsInfoList(gi);
	}
	
	@RequestMapping(value="/goods/deleteone", method = RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> deleteGoodsInfo(@RequestBody GoodsInfo gi){
		gDao.deleteGoodsInfo(gi);
		return gs.getGoodsInfoList(gi);
	}
	
	@RequestMapping(value="/goods/updateone", method=RequestMethod.POST)
	public @ResponseBody List<GoodsInfo> updateGoodsInfo(@RequestBody GoodsInfo gi){
		gDao.updateGoodsInfo(gi);
		return gs.getGoodsInfoList(gi);
	}
}
