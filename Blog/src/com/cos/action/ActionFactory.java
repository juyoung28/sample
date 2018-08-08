package com.cos.action;

import com.cos.controller.member.MemberAccountAction;
import com.cos.controller.member.MemberJoinAction;
import com.cos.controller.member.MemberLoginAction;
import com.cos.controller.member.MemberLogoutAction;

public class ActionFactory {
	private static String naming ="ActionFactory : ";
	
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		if(cmd.equals("member_join")) {
			return new MemberJoinAction();
		}else if(cmd.equals("member_login")) {
			return new MemberLoginAction();
		}else if(cmd.equals("member_logout")) {
			return new MemberLogoutAction();
		}else if(cmd.equals("member_account")) {
			return new MemberAccountAction();
		}else if(cmd.equals("member_update")) {
			return new MemberAccountAction();
		}
		return null;
	}
	
	
}
