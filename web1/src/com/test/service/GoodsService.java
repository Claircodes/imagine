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
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class GoodsService {
	public List<Vendor> selectVendorsList(){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname from vendor_info";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendorList.add(vendor);
			}
			return vendorList;

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
		return null;
	}
	public Goods selectGoods(Goods pGoods) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname "
					+ " from goods_info as gi, vendor_info as vi "
					+ " where gi.vinum=vi.vinum and gi.ginum=?";
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				pGoods.setGiNum(rs.getInt("ginum"));
				pGoods.setGiName(rs.getString("giname"));
				pGoods.setGiDesc(rs.getString("gidesc"));
				pGoods.setViNum(rs.getInt("vinum"));
				pGoods.setViName(rs.getString("viname"));
			}
			System.out.println("goods==>"+pGoods.toString());
			return pGoods;
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
	public List<Goods> selectGoodsList(Goods pGoods) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum"; 
		if (pGoods.getViNum()>0 && pGoods.getGiName()!=null){
			sql += " and gi.giname like ?";
		}
		if ( pGoods.getViNum()>0){
			sql += " and vi.vinum=? ";
		}
		sql += " order by gi.ginum desc limit ?,?";
		int i =0;
			Page page = pGoods.getPage();
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
		if (pGoods.getViNum()>0&&pGoods.getGiName()!=null){
			i+=1;
			String a ="%"+pGoods.getGiName()+"%";
			ps.setString(i, a);
		}
		if (pGoods.getViNum()>0){
			i+=1;
			ps.setInt(i, pGoods.getViNum());
		}
			i+=1;
			ps.setInt(i, page.getStartRow());
			i+=1;
			ps.setInt(i, page.getRowCnt());

			System.out.println(i);
			System.out.println("page.getStartRow()  =>"+page.getStartRow()+"page.getBlockCnt() =>"+page.getBlockCnt());
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("ginum"));
				goods.setGiName(rs.getString("giname"));
				goods.setGiDesc(rs.getString("gidesc"));
				goods.setViNum(rs.getInt("vinum"));
				goods.setViName(rs.getString("viname"));
				goodsList.add(goods);
			}
			return goodsList;
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

	public int getTotalCount(Goods pGoods) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(1) " + " from goods_info as gi, vendor_info as vi " + " where gi.vinum=vi.vinum";
			if (pGoods.getViNum()>0 && pGoods.getGiName()!=null){
				sql += " and gi.giname like ?";
			}
			if ( pGoods.getViNum()>0){
				sql += " and vi.vinum=? ";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			int i=0;
			if (pGoods.getViNum()>0&&pGoods.getGiName()!=null){
				i+=1;
				String a ="%"+pGoods.getGiName()+"%";
				ps.setString(i, a);
			}
			if (pGoods.getViNum()>0){
				i+=1;
				ps.setInt(i, pGoods.getViNum());
			}
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
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
	public int deleteGoods(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from goods_info where  ginum=?";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, pGoods.getGiNum());
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
	public int insertGoods(Goods goods) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO goods_info (giname,gidesc,vinum,gicredat,gicretim) ";
			sql+= "VALUES (?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, goods.getGiName());
			ps.setString(2, goods.getGiDesc());
			ps.setInt(3, goods.getViNum());
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
	public int updateGoods(Goods goods) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "update goods_info set giname=?, gidesc=?,vinum=?, ";
			sql+= "gicredat=DATE_FORMAT(NOW(),'%Y%m%d'), gicretim=DATE_FORMAT(NOW(),'%H%i%s') ";
			sql+= "where ginum=? ";
			
			con = DBConn.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, goods.getGiName());
			ps.setString(2, goods.getGiDesc());
			ps.setInt(3, goods.getViNum());
			ps.setInt(4, goods.getGiNum());
			
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