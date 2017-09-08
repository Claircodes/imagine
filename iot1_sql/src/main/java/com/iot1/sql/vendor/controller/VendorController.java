package com.iot1.sql.vendor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot1.sql.vendor.dto.VendorInfo;
import com.iot1.sql.vendor.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	VendorService vs;

	@RequestMapping(value = "/vendor/list", method = RequestMethod.POST)
	public @ResponseBody List<VendorInfo> getVendorInfoList(VendorInfo vi) {
		return vs.getVendorList(vi);
	}

	@RequestMapping(value = "/vendor/combo", method = RequestMethod.GET)
	public String getVendorInfoCombo(Model model, HttpServletRequest request) {
		List<VendorInfo> vlist = vs.getVendorComboList();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		for (VendorInfo v : vlist) {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("value", v.getViNum());
			hm.put("text", v.getViName());
			resultList.add(hm);
		}
		model.addAttribute("vendorcombolist", resultList);
		String url = request.getParameter("url");
		if (url == null || url.equals("")) {
			url = "goods/goods_list";
		}
		return url;
	}

	@RequestMapping(value = "/vendor/create", method = RequestMethod.POST)
	public @ResponseBody List<VendorInfo> saveVendorInfo(@RequestBody VendorInfo[] vendorList) {
		int rCnt = vs.insertVendorList(vendorList);
		for (VendorInfo vi : vendorList) {
			System.out.println(vi);
		}
		return getVendorInfoList(null);
	}

}
