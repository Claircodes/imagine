package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.ClassinfoService;
import com.test.service.CommentService;
import com.test.service.UserService;

public class ClassinfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		ClassinfoService cs = new ClassinfoService();

		String command = req.getParameter("command");
		List<Map> list;
		
		if (command.equals("입력")) {

			HashMap hm = new HashMap();
			String classNameInsert = req.getParameter("classname_insert");
			System.out.println(classNameInsert + "class info insert");
			hm.put("classNameInsert", classNameInsert);

			if (cs.insertClass(hm)) {
				doProcess(resq, "저장이 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 짜식아");
			}
		} else if (command.equals("삭제")) {

			HashMap hm = new HashMap();
			String deleteComNum = req.getParameter("com_Num");
			System.out.println(deleteComNum + "번 삭제한다잉");
			// us.deleteUser(deleteNum);
			hm.put("deleteComNum", deleteComNum);
			if (cs.deleteComment(hm)) {
				// doProcess(resq, "삭제했다");
				list = new ArrayList<Map>();
				list.add(hm);
				// for (Map m : list) {
				doProcess(resq, list + "");
				// }
			} else {
				doProcess(resq, "값 입력해야지 삭제하지 짜식아");
			}
		} else if (command.equals("업데이트")) {
			HashMap hm = new HashMap();
			String comNum = req.getParameter("com_Num");
			String comContent = req.getParameter("com_Content");
			System.out.println(comNum + "업데이트");
			// us.deleteUser(deleteNum);

			hm.put("comNum", comNum);
			hm.put("comContent", comContent);
			if (cs.updateComment(hm)) {
				list = new ArrayList<Map>();
				list.add(hm);
				// for (Map m : list) {
				doProcess(resq, list + "");
				// }
			} else {
				doProcess(resq, "값 입력해야지 업데이트하지 짜식아");
			}
		} else if (command.equals("검색")) {
			String searchNum = req.getParameter("com_Num");
			HashMap hm = new HashMap();
			System.out.println(searchNum + "select board");

			hm.put("searchNum", searchNum);
			List<Map> selectList = cs.searchComment(hm);
			String result = "";
			for (Map m : selectList) {
				result += m.toString();
			}
			doProcess(resq, result);

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}