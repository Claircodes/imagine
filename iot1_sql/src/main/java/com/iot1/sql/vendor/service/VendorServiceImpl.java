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

}
