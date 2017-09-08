package com.iot1.sql.vendor.service;

import java.util.List;

import com.iot1.sql.vendor.dto.VendorInfo;

public interface VendorService {

	public VendorInfo getVendor(VendorInfo vi);

	public List<VendorInfo> getVendorList(VendorInfo vi);

	List<VendorInfo> getVendorComboList();

	public int insertVendorList(VendorInfo[] vendorList);

}
