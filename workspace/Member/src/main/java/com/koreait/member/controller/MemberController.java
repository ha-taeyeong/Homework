 package com.koreait.member.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.member.command.EmailAuthCommand;
import com.koreait.member.command.IdCheckCommand;
import com.koreait.member.command.JoinCommand;

@Controller
public class MemberController {
	
	private SqlSession sqlSession;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	
	@Autowired
	public MemberController(SqlSession sqlSession,
													IdCheckCommand idCheckCommand,
													EmailAuthCommand emailAuthCommand,
													JoinCommand joinCommand) {
		super();
		this.sqlSession = sqlSession;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
	}
	
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "member/join";
	}
}
