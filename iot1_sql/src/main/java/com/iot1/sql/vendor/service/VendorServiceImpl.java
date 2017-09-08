package com.iot1.sql.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.goods.dto.GoodsInfo;
import com.iot1.sql.vendor.dao.VendorDAO;
import com.iot1.sql.vendor.dto.VendorInfo;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorDAO vDao;
	@Override
	public VendorInfo getVendor(VendorInfo vi) {
		return vDao.selectVendor(vi);
	}

	@Override
	public List<VendorInfo> getVendorList(VendorInfo vi) {
		return vDao.selectVendorList(vi);
	}
	@Override
	public List<VendorInfo> getVendorComboList() {
		return vDao.selectVendorComboList();
	}

	@Override
	public int insertVendorList(VendorInfo[] vendorList) {
		int rCnt = 0;
		for (VendorInfo gi : vendorList) {
			rCnt += vDao.insertVendorList(gi);
		}
		return rCnt;
	}
}
