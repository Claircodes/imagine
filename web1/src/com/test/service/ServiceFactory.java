package com.test.service;

import com.test.service.Impliment.VendorServiceImpl;

public class ServiceFactory {

	private static VendorService vendorService = new VendorServiceImpl();
	public static VendorService getVendorService(){
		return vendorService;
	}
}
