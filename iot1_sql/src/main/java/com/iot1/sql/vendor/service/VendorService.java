package com.iot1.sql.vendor.service;

import java.util.List;

import com.iot1.sql.vendor.dto.VendorInfo;

public interface VendorService {

	public VendorInfo getVendor(VendorInfo vi);

	public List<VendorInfo> getVendorList(VendorInfo vi);

	List<VendorInfo> getVendorComboList();

	public int insertVendorList(VendorInfo[] vendorList);

	int updateVendorList(VendorInfo[] vendorlist);

	int deleteVendorList(VendorInfo[] vendorlist);

	int insertVendor(VendorInfo vi);

	int updateVendor(VendorInfo vi);

	int deleteVendor(VendorInfo vi);

}
