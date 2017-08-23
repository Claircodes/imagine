package com.test.service;

import java.util.List;
import com.test.dto.Vendor;

public interface VendorService {
	public Vendor selectVendor(Vendor vendor);
	public List<Vendor> selectVendorList(Vendor vendor);
	public int getTotalCount(Vendor vendor);
	public int deleteVendor(Vendor vendor);
	public int insertVendor(Vendor vendor);
	public int updateVendor(Vendor vendor);	
}
