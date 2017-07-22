package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.BoardInfo;
import com.test.service.BoardService;

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		BoardInfo bi = new BoardInfo();

		String bNum = req.getParameter("binum");
		String bTitle = req.getParameter("bititle");
		String bContent = req.getParameter("bicontent");
		String bPwd = req.getParameter("bipwd");
		String creusr = req.getParameter("creusr");
		String datetime = req.getParameter("datetime");
		if (bNum != null) {
			bi.setBinum(Integer.parseInt(bNum));
		}
		bi.setBititle(bTitle);
		bi.setBicontent(bContent);
		bi.setBipwd(bPwd);
		bi.setCreusr(creusr);
		bi.setDatetime(datetime);

		String command = req.getParameter("command");

		if (command == null) {
			return;
		}
		if (command.equals("MAIN")) {
			System.out.println(command + "<<--시작");

			List<BoardInfo> boardlist = bs.searchBoard();
			String result = "";
			String menu = "번호{/}제목{/}내용{/}글쓴이{/}날짜{+}";
			result += menu;
			result += "dis{/}en{/}en{/}en{/}dis{+}";
			for (BoardInfo bi1 : boardlist) {
				result += bi1.getBinum() + "{/}"+bi1.getBititle()+ "{/}"+bi1.getBicontent()+"{/}"+ bi1.getCreusr()+ "{/}"+bi1.getDatetime()+"{+}";
			}
			result=result.substring(0,result.length()-3);
			doProcess(resq, result);
			System.out.println(command + "끝--->>");
		}else if(command.equals("DELETE")) {
			System.out.println(command + "<<--시작");
			
			if (bs.isUserPwd(bi)) {
				doProcess(resq, "비밀번호가 맞네요");
				bs.deleteBoard(bi);
			}else {
				doProcess(resq, "비밀번호를 확인해주세요.");
			}
			
			System.out.println(command + "끝--->>");
		}else if(command.equals("UPDATE")) {
			System.out.println(command + "<<--시작");
//			bs.selectUser(bi);
			if (bs.isUserPwd(bi)) {
				doProcess(resq, "비밀번호가 맞네요");
				bs.updateBoard(bi);
			}else {
				doProcess(resq, "비밀번호를 확인해주세요.");
			}
			
			System.out.println(command + "끝--->>");
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