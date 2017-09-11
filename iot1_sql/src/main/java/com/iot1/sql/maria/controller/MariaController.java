package com.iot1.sql.maria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot1.sql.maria.dto.MariaInfo;
import com.iot1.sql.maria.service.MariaService;

@Controller
public class MariaController {
	@Autowired
	MariaService ms;

	@RequestMapping(value = "/maria/treelist", method = RequestMethod.POST)
	public @ResponseBody List<MariaInfo> getGoodsInfoList(@RequestBody MariaInfo mi) {
		return ms.getMariaInfoList(mi);
	}
}
