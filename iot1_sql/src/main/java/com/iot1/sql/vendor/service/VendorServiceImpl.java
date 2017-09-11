package com.iot1.sql.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int insertVendorList(VendorInfo[] vendorlist) {
		int rCnt = 0;
		for (VendorInfo vi : vendorlist) {
			rCnt += vDao.insertVendorList(vi);
		}
		return rCnt;
	}

	@Override
	public int updateVendorList(VendorInfo[] vendorlist) {
		int rCnt = 0;
		for (VendorInfo vi : vendorlist) {
			rCnt += vDao.updateVendorList(vi);
		}
		return rCnt;
	}

	@Override
	public int deleteVendorList(VendorInfo[] vendorlist) {
		int rCnt = 0;
		for (VendorInfo vi : vendorlist) {
			rCnt += vDao.deleteVendorList(vi);
		}
		return rCnt;
	}

	@Override
	public int insertVendor(VendorInfo vi) {
		return vDao.insertVendorList(vi);
	}

	@Override
	public int updateVendor(VendorInfo vi) {
		return vDao.updateVendorList(vi);
	}

	@Override
	public int deleteVendor(VendorInfo vi) {
		return vDao.deleteVendorList(vi);
	}
}
