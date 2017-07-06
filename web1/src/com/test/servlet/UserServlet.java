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

import com.test.service.UserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		UserService us = new UserService();

		String command = req.getParameter("command");
		HashMap hm = new HashMap();
		List<Map> list = new ArrayList<Map>();

		if (command.equals("SIGNIN")) {

			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");

			System.out.println(id + "," + pwd + "," + name + "," + class_num + ", " + age + "회원가입");
			hm.put("id", id);
			hm.put("pwd", pwd);
			hm.put("name", name);
			hm.put("class_num", class_num);
			hm.put("age", age);
			// us.insertUser(hm);
			if (us.insertUser(hm)) {
				doProcess(resq, "저장이 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 회원가입하지 짜식아");
			}
		} else if (command.equals("DELETE")) {
			String deleteNum = req.getParameter("user_num");
			System.out.println(deleteNum + "번 삭제한다잉");
			// us.deleteUser(deleteNum);
			hm.put("num", deleteNum);
			if (us.deleteUser(hm)) {
				// doProcess(resq, "삭제했다");
				list.add(hm);
				// for (Map m : list) {
				doProcess(resq, list + "");
				// }
			} else {
				doProcess(resq, "값 입력해야지 삭제하지 짜식아");
			}
		} else if (command.equals("UPDATE")) {
			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");
			String updateNum = req.getParameter("user_num");
			System.out.println(updateNum + "업데이트");
			// us.deleteUser(deleteNum);

			hm.put("name", name);
			hm.put("class_num", class_num);
			hm.put("age", age);
			hm.put("num", updateNum);
			if (us.updateUser(hm)) {
				list.add(hm);
				// for (Map m : list) {
				doProcess(resq, list + "");
				// }
			} else {
				doProcess(resq, "값 입력해야지 업데이트하지 짜식아");
			}
		} else if (command.equals("SELECT")) {
			String searchNum = req.getParameter("name");
			System.out.println(searchNum + " 검색한다잉");

			if (!searchNum.equals("")) {
				hm.put("name", "%" + searchNum + "%");
			} else {
				hm.put("name", searchNum);
			}
			List<Map> selectList = us.searchUser(hm);
			doProcess(resq, selectList + "");
		
		}
	}

	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}