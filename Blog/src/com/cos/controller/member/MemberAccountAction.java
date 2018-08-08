package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.action.Action;
import com.cos.dao.MemberDAO;
import com.cos.dto.MemberVO;
import com.cos.util.SHA256;
import com.cos.util.Script;

public class MemberAccountAction implements Action{
	private static String naming ="MemberAccountAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/accountForm.jsp";
		HttpSession session = request.getSession();
		
		MemberVO member = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		String id = null;	
		
		
		if(session.getAttribute("id") != null){
			id = (String)session.getAttribute("id");
		}	
				
		
		member = dao.account(id);
		
		if(member !=null) {
			request.setAttribute("member", member);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else {
			Script.moving(response, "잘못된 접근입니다.");
		}
	}

}
