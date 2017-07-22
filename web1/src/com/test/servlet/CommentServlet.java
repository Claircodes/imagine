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

import com.test.service.CommentService;

public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		CommentService cs = new CommentService();

		String command = req.getParameter("command");
		List<Map> list;
		HashMap<String,String> hm = new HashMap<>();
		if (command.equals("입력")) {


			String comBoardNum = req.getParameter("com_boardnum");
			String comUserNum = req.getParameter("com_usernum");
			String comContent = req.getParameter("com_content");

			System.out.println(comBoardNum + "," + comUserNum + "," + comContent + "comment insert");
			hm.put("comBoardNum", comBoardNum);
			hm.put("comUserNum", comUserNum);
			hm.put("comContent", comContent);

			if (cs.insertComment(hm)) {
				doProcess(resq, "저장이 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 짜식아");
			}
		} else if (command.equals("삭제")) {

			hm = new HashMap<>();
			String deleteComNum = req.getParameter("com_num");
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
			hm = new HashMap<>();
			String comNum = req.getParameter("com_num");
			String comContent = req.getParameter("com_content");
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
			hm = new HashMap<>();
			String searchComNum = req.getParameter("com_num");
			System.out.println(searchComNum  + "searchComNum");

				if (!searchComNum.equals("")) {
					hm.put("searchComNum", "%" + searchComNum + "%");
				} else {
					hm.put("searchComNum", searchComNum);
				}
				List<Map> selectList = cs.searchComment(hm);
				doProcess(resq, selectList + "");
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