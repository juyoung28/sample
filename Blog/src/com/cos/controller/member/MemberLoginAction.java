package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.action.Action;
import com.cos.dao.MemberDAO;
import com.cos.dto.MemberVO;
import com.cos.util.SHA256;
import com.cos.util.Script;

public class MemberLoginAction implements Action{
	private static String naming ="MemberLoginAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		
		MemberVO member = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		String id = null;
		String password = null;
		String salt = null;
		
		
		if(request.getParameter("id") != null){
			id = request.getParameter("id");
		}		
		if(request.getParameter("password") != null){
			password = request.getParameter("password");
			//패스워드를 SHA256으로 해쉬하기
			salt = dao.select_salt(id);
			password = SHA256.getEncrypt(password, salt);			
		}
		
		
		member.setId(id);
		member.setPassword(password);		
		
		
		int result = dao.login(member);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getId());
			Script.moving(response, "로그인되었습니다.", url);
		}else if(result == 2) {
			Script.moving(response, "아이디와 비밀번호가 일치하지 않습니다.");
		}else if(result == -1) {
			Script.moving(response, "데이터베이스 오류");
		}
	}

}
