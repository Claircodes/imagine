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

		if (command == null) {
			return;
		}

		if (command.equals("SIGNIN")) {

			String userid = req.getParameter("userid");
			String userpwd = req.getParameter("userpwd");
			String username = req.getParameter("username");
			String address = req.getParameter("address");
			String hp1 = req.getParameter("hp1");
			String hp2 = req.getParameter("hp2");
			String hp3 = req.getParameter("hp3");
			String age = req.getParameter("age");

			System.out.println(userid + "," + userpwd + "," + username + "," + address + ", " + age + "," + "회원가입");
			hm.put("userid", userid);
			hm.put("userpwd", userpwd);
			hm.put("username", username);
			hm.put("address", address);
			hm.put("hp1", hp1);
			hm.put("hp2", hp2);
			hm.put("hp3", hp3);
			hm.put("age", age);
			// us.insertUser(hm);
			if (us.insertUser(hm)) {
				doProcess(resq, "저장이 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 회원가입하지 짜식아");
			}
		} else if (command.equals("삭제")) {
			String deleteNum = req.getParameter("usernum");
			System.out.println(deleteNum + "번 삭제한다잉");
			// us.deleteUser(deleteNum);
			hm.put("deleteNum", deleteNum);
			if (us.deleteUser(hm)) {
				// doProcess(resq, "삭제했다");
				list.add(hm);
				// for (Map m : list) {
				doProcess(resq, "user의 num "+deleteNum + "번 삭제 하엿습니다.");
				// }
			} else {
				doProcess(resq, "값 입력해야지 삭제하지 짜식아");
			}
		} else if (command.equals("수정")) {
			String username = req.getParameter("username");
			String userid = req.getParameter("userid");
			String age = req.getParameter("age");
			String usernum = req.getParameter("usernum");
			System.out.println(usernum + "업데이트");
			// us.deleteUser(deleteNum);
			
			hm.put("username", username);
			hm.put("userid", userid);
			hm.put("age", age);
			hm.put("usernum", usernum);
			
			if (us.updateUser(hm)) {
				list.add(hm);
				// for (Map m : list) {
				doProcess(resq, list + "");
				// }
			} else {
				doProcess(resq, "값 입력해야지 업데이트하지 짜식아");
			}
		}  else if (command.equals("SELECT")) {
			String name = req.getParameter("username");
			System.out.println("이름 : " + name);
			hm = new HashMap();
			if (name != null && !name.equals("")) {
				hm.put("name", "%" + name + "%");
			}
			List<Map> userList  = us.selectUser(hm);
			String result="번호{/}이름{/}아이디{/}나이{+}";
			result+="dis{/}en{/}en{/}en{+}";
			for(Map m : userList){
				result += m.get("usernum") + "{/}" + m.get("username") + "{/}" + m.get("userid") + "{/}" + m.get("age") + "{+}"; 
			}
			result = result.substring(0, result.length()-3);
			doProcess(resq, result);
			
		} else if (command.equals("LOGIN")) {
			String loginId = req.getParameter("userid");
			String loginPwd = req.getParameter("userpwd");
			System.out.println(loginId + "," + loginPwd + " 검색한다.");

			hm.put("loginId", loginId);
			hm.put("loginPwd", loginPwd);

			doProcess(resq, us.loginUser(hm));
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.println(writeStr);

	}
}