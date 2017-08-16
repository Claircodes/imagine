package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;
import com.test.dto.Vendor;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class VendorService {

	public Vendor selectVendor(Vendor vendor) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "SELECT vinum, viname, videsc, viaddress, viphone FROM vendor_info where vinum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vendor.getViNum());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
			}
			System.out.println("vendor==>"+vendor.toString());
			return vendor;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Vendor> selectVendorList(Vendor vendor) {
	Connection con = null;
	PreparedStatement ps = null;
	try {
		String sql = "select vinum,viname, videsc, viaddress, viphone from vendor_info order by vinum desc limit ?,?";
		int i =0;
		Page page = vendor.getPage();
		con = DBConn.getCon();
		ps = con.prepareStatement(sql);

		i+=1;
		ps.setInt(i, page.getStartRow());
		i+=1;
		ps.setInt(i, page.getRowCnt());

		System.out.println(i);
		System.out.println("page.getStartRow()  =>"+page.getStartRow()+"page.getBlockCnt() =>"+page.getBlockCnt());
		ResultSet rs = ps.executeQuery();
		List<Vendor> vendorList = new ArrayList<Vendor>();
		while (rs.next()) {
			Vendor vendor1 = new Vendor();
			vendor1.setViNum(rs.getInt("vinum"));
			vendor1.setViName(rs.getString("viname"));
			vendor1.setViDesc(rs.getString("videsc"));
			vendor1.setViAddress(rs.getString("viaddress"));
			vendor1.setViPhone(rs.getString("viphone"));
			vendorList.add(vendor1);
		}
		return vendorList;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			ps.close();
			DBConn.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}
	
	
//	public List<Vendor> selectVendorList(Vendor vendor) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum"; 
//		if (vendor.getViNum()>0 && vendor.getGiName()!=null){
//			sql += " and gi.giname like ?";
//		}
//		if ( vendor.getViNum()>0){
//			sql += " and vi.vinum=? ";
//		}
//		sql += " order by gi.ginum desc limit ?,?";
//		int i =0;
//			Page page = vendor.getPage();
//			con = DBConn.getCon();
//			ps = con.prepareStatement(sql);
//		if (vendor.getViNum()>0&&vendor.getGiName()!=null){
//			i+=1;
//			String a ="%"+vendor.getGiName()+"%";
//			ps.setString(i, a);
//		}
//		if (vendor.getViNum()>0){
//			i+=1;
//			ps.setInt(i, vendor.getViNum());
//		}
//			i+=1;
//			ps.setInt(i, page.getStartRow());
//			i+=1;
//			ps.setInt(i, page.getRowCnt());
//
//			System.out.println(i);
//			System.out.println("page.getStartRow()  =>"+page.getStartRow()+"page.getBlockCnt() =>"+page.getBlockCnt());
//			ResultSet rs = ps.executeQuery();
//			List<Vendor> goodsList = new ArrayList<Vendor>();
//			while (rs.next()) {
//				Vendor goods = new Vendor();
//				goods.setGiNum(rs.getInt("ginum"));
//				goods.setGiName(rs.getString("giname"));
//				goods.setGiDesc(rs.getString("gidesc"));
//				goods.setViNum(rs.getInt("vinum"));
//				goods.setViName(rs.getString("viname"));
//				goodsList.add(goods);
//			}
//			return goodsList;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//				DBConn.closeCon();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

	public int getTotalCount(Vendor vendor) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(1) from vendor_info as gi, vendor_info as vi where gi.vinum=vi.vinum";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			int i=0;
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
//	public int deleteGoods(Vendor vendor){
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			String sql = "delete from vendor_info where vinum=?";
//			con = DBConn.getCon(); 
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, vendor.getViNum());
//			int result = ps.executeUpdate();
//			con.commit();
//			return result;
//		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				ps.close();
//				DBConn.closeCon();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return 0;
//
//}

//	public int updateGoods(Vendor vendor) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			String sql = "update vendor_info set giname=?, gidesc=?,vinum=?, ";
//			sql+= "gicredat=DATE_FORMAT(NOW(),'%Y%m%d'), gicretim=DATE_FORMAT(NOW(),'%H%i%s') ";
//			sql+= "where ginum=? ";
//			
//			con = DBConn.getCon(); 
//			ps = con.prepareStatement(sql);
//			ps.setString(1, vendor.getGiName());
//			ps.setString(2, vendor.getGiDesc());
//			ps.setInt(3, vendor.getViNum());
//			ps.setInt(4, vendor.getGiNum());
//			
//			int result = ps.executeUpdate();
//			con.commit();
//			return result;
//		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				ps.close();
//				DBConn.closeCon();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return 0;
//	}
	
	public int insertVendor(Vendor vendor) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO vendor_info (viname, videsc, viaddress, viphone, vicredat, vicretim)";
			sql+= "VALUES (?,?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, vendor.getViName());
			ps.setString(2, vendor.getViDesc());
			ps.setString(3, vendor.getViAddress());
			ps.setString(4, vendor.getViPhone());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int vendorInsertGoods(Vendor vendor) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO vendor_info (viname, videsc, viaddress, viphone, vicredat, vicretim)";
			sql+= "VALUES (?,?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, vendor.getViName());
			ps.setString(2, vendor.getViDesc());
			ps.setString(3, vendor.getViAddress());
			ps.setString(4, vendor.getViPhone());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}