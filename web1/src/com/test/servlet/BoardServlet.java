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

import com.test.service.BoardService;
import com.test.service.UserService;

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		String command = req.getParameter("command");
		HashMap hm = new HashMap();

		if (command.equals("글쓰기")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String userNum = req.getParameter("user_num");

			System.out.println(title + "," + content + "," + userNum + "insert board");
			hm.put("title", title);
			hm.put("content", content);
			hm.put("nserNum", userNum);
			// us.insertUser(hm);
			if (bs.insertBoard(hm)) {
				doProcess(resq, "저장이 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 회원가입하지 짜식아");
			}
		} else if (command.equals("지우기")) {
			String boardNum = req.getParameter("board_num");
			System.out.println(boardNum + "delete board");
			hm.put("boardNum", boardNum);
			if (bs.deleteBoard(hm)) {
				doProcess(resq, "삭제가 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 삭제하지 짜식아");
			}
		} else if (command.equals("검색")) {
			String boardNum = req.getParameter("board_num");
			System.out.println(boardNum  + "select board");
				
				if (boardNum!= null &&!boardNum.equals("")) {
					hm.put("boardNum", "%" + boardNum + "%");
				} else {
					hm.put("boardNum", boardNum);
				}
				List<Map> selectList = bs.searchBoard(hm);
				
				String result="<script>";
				result += "function deleteBoard(boardNum){";
				result += "location.href='delete.board?command=지우기&board_num=' +boardNum;";
				result += "}";
				result += "</script>";
				result += "<form action='/test_web/sign.board'>";
				result += "이름 : <input type='text' name='name' id='name'/> <input type='submit' value='검색'/>";
				result += "<input type='hidden' name='command' value='SELECT'/>";
				result += "</form>";
				result += "<table border='1'>";
				result += "<tr>";
				result += "<td>게시물번호</td>";
				result += "<td>게시물제목</td>";
				result += "<td>게시물내용</td>";
				result += "<td>작성자</td>";
				result += "<td>작성날짜시간</td>";
				result += "<td>삭제버튼</td>";
				result += "</tr>";
				for (Map m : selectList) {
					result += "<tr align='center'>";
					result += "<td>" + m.get("NUM") + "</td>";
					result += "<td>" + m.get("TITLE") + "</td>";
					result += "<td>" + m.get("CONTENT") + "</td>";
					result += "<td>" + m.get("WRITER") + "</td>";
					result += "<td>" + m.get("REG_DATE") + "</td>";
					result += "<td><input type='button' value='삭제' onclick='deleteBoard(" + m.get("NUM") + ")'/></td>";
					result += "</tr>";
				}
				result += "</table>";
				doProcess(resq, result);
				
		} else if (command.equals("업데이트")) {
			String boardTitle = req.getParameter("board_title");
			String boardContent = req.getParameter("board_content");
			String boardNum = req.getParameter("board_num");
			
			System.out.println(boardTitle +boardContent+ "update board");
			hm.put("boardTitle", boardTitle);
			hm.put("boardContent", boardContent);			
			hm.put("boardNum", boardNum);			
			
			if (bs.updateBoard(hm)) {
				doProcess(resq, "수정이 잘 되었구나");
			} else {
				doProcess(resq, "값 입력해야지 수정하지 짜식아");
			}
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