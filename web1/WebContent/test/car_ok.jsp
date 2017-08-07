<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.test.common.DBConn"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	JSONObject j = new Gson().fromJson(request.getReader(), JSONObject.class);

	int nowPage=0;
	if (j != null) {
		String np = j.get("nowPage").toString();
		nowPage = Integer.parseInt(np);
	}


	int rowCnt = 10; //rowCnt는 내가 보여줄 데이터 수 

	int blockCnt =10; //블럭 보여지는 수 
	
	int totalPageCnt = 0; //토탈 페이지 숫자
	int totalBlockCnt = 0;	//토탈 블럭 숫자
	
	int totalCnt = 0;
	

	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, Object>> vendorList = new ArrayList<Map<String, Object>>();
	ArrayList<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();

	try {
		con = DBConn.getCon();
		String sql = "select vinum, viname from VENDOR_INFO;";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Map<String, Object> rhm = new HashMap<String, Object>();
			rhm.put("vinum", rs.getString("vinum"));
			rhm.put("viname", rs.getString("viname"));
			vendorList.add(rhm);
		}

		sql = "SELECT count(1) FROM goods_info AS gi INNER JOIN vendor_info AS vi ON vi.vinum=gi.vinum where 1=1 ";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()){
			totalCnt = rs.getInt(1); //totalCnt는 총 수 
		}	
		
		if (totalCnt!=0){
			int mod = totalCnt % rowCnt; //totalCnt는 총 수 , rowCnt는 내가 보여줄 데이터 수 
			totalPageCnt = totalCnt/rowCnt; //totalCnt는 총 수 , rowCnt는 내가 보여줄 데이터 수 
			if(mod!=0){
				totalPageCnt+=1;
			}
		}
		if (totalPageCnt!=0){
			int mod = totalPageCnt % blockCnt;
			totalBlockCnt = totalBlockCnt/blockCnt;
			if (mod!=0){
				totalBlockCnt +=1;
			}
		}

		sql = "SELECT vi.viname,gi.giname,gi.gidesc,gi.gicredat,gi.gicretim FROM goods_info AS gi ";
		sql += "INNER JOIN vendor_info AS vi ON vi.vinum=gi.vinum where 1=1 ";
		sql += "order by gi.ginum limit ?,? ";
		ps = con.prepareStatement(sql);
		ps.setInt(1, (nowPage-1) * rowCnt);
		ps.setInt(2,rowCnt);
		rs = ps.executeQuery();
		while (rs.next()) {
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("vname", rs.getString("vi.viname"));
			hm.put("cname", rs.getString("gi.giname"));
			hm.put("desc", rs.getString("gi.gidesc"));
			hm.put("credat", rs.getString("gi.gicredat"));
			hm.put("cretim", rs.getString("gi.gicretim"));
			goodsList.add(hm);
		}
		System.out.println(totalCnt);
	} catch (Exception e) {
		System.out.println(e);
	} finally {
		if (ps != null) {
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
	HashMap<String, Integer> pageHm = new HashMap <String, Integer>();
	pageHm.put("nowPage", nowPage);
	
	pageHm.put("totalPageCnt", totalPageCnt);
	pageHm.put("totalBlockCnt", totalBlockCnt);
	
	pageHm.put("blockCnt", blockCnt);
	pageHm.put("totalCnt", totalCnt);
	
	HashMap resultHm = new HashMap();
	resultHm.put("vendorList", vendorList);
	resultHm.put("goodsList", goodsList);
	resultHm.put("pageinfo", pageHm);

	String json = new Gson().toJson(resultHm);
	System.out.println(json);
	System.out.println(totalCnt);
	out.write(json);
%>