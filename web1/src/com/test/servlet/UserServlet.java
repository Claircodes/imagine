package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.UserInfo;
import com.test.service.UserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		UserService us = new UserService();
		UserInfo ui = new UserInfo();

		String userNum = req.getParameter("usernum");
		String userId = req.getParameter("userid");
		String userPwd = req.getParameter("userpwd");
		String userName = req.getParameter("username");
		String address = req.getParameter("address");

		String age = req.getParameter("age");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");

		if (userNum != null) {
			ui.setUserNum(Integer.parseInt(userNum));
		}
		ui.setUserId(userId);
		ui.setUserPwd(userPwd);
		ui.setUserName(userName);
		ui.setAddress(address);
		if (age != null) {
			ui.setAge(Integer.parseInt(age));
		}
		ui.setHp1(hp1);
		ui.setHp2(hp2);
		ui.setHp3(hp3);

		String command = req.getParameter("command");

		if (command == null) {
			return;
		}

		if (command.equals("SIGNIN")) {
			System.out.println("id= " + userId + ", pwd= " + userPwd + ", name= " + userName + ", address= " + address
					+ ", age= " + age + ", hp= " + hp1 + "-" + hp2 + "-" + hp3 + " ★회원가입 완료★ ");
			if (us.insertUser(ui)) {
				doProcess(resq, " 회원가입이 되었구나! ");
			} else {
				doProcess(resq, " 너를 받아줄 수 없구나. ");
			}

		} else if (command.equals("DELETE")) {
			boolean isDelete = us.deleteUser(ui);
			String result = "";
			if (isDelete) {
				result = " ★삭제 완료★ ";
			} else {
				result = " 삭제할 수 없구나. ";
			}
			doProcess(resq, result);

		} else if (command.equals("UPDATE")) {
			System.out.println(userNum + " 번 =UPDATE= ");

			if (us.updateUser(ui)) {
				doProcess(resq, userNum + ", " + userId + " ★수정 완료★ ");
			} else {
				doProcess(resq, "값 입력해야지 업데이트하지 짜식아");
			}

		} else if (command.equals("SELECT")) {
			System.out.println("이름 : " + userName);
			if (userName != null && !userName.equals("")) {
				ui.setUserName("%" + userName + "%");
			}
			List<UserInfo> userList = us.selectUser(ui);
			String result = "번호{/}이름{/}아이디{/}나이{+}";
			result += "dis{/}en{/}en{/}en{+}";
			for (UserInfo ui2 : userList) {
				result += ui2.getUserNum() + "{/}" + ui2.getUserName() + "{/}" + ui2.getUserId() + "{/}" + ui2.getAge()
						+ "{+}";
			}
			result = result.substring(0, result.length() - 3);
			doProcess(resq, result);

		} else if (command.equals("LOGIN")) {
			System.out.println("id= " + userId + ", pwd= " + userPwd + " ★로그인 완료★ ");
			if (us.loginUser(ui)) {
				doProcess(resq, userId );
				}
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