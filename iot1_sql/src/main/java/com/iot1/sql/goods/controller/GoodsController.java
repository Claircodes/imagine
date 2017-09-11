package com.iot1.sql.goods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

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
	public @ResponseBody List<GoodsInfo> getGoodsInfoList(@RequestBody GoodsInfo gi) {
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

    @RequestMapping(value="/goods/excel", method=RequestMethod.POST)
    public @ResponseBody
    void save(String fileName, String base64, String contentType, HttpServletResponse response) throws IOException {

        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.setContentType(contentType);

        byte[] data = DatatypeConverter.parseBase64Binary(base64);

        response.setContentLength(data.length);
        response.getOutputStream().write(data);
        response.flushBuffer();
    }
}
