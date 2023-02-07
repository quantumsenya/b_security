package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.MemberVO;
import com.jafa.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	// 로그인 페이지
	@RequestMapping("/login")
	public String loginForm() {
		return "member/login";
	}
	
	@GetMapping("/all")
	public void doAll() {
		// 모든 사용자 허용
	}
	
	@GetMapping("/member")
	public void doMember() {
		// 로그인 사용자 허용
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		// 관리자만 허용
	}
	
	// 접근 거부 처리
	@GetMapping("/accessError")
	public void accessError() {
		
	}
	
	// 회원가입 폼
	@GetMapping("/join")
	public void joinForm() {
		
	}
	
	// 회원가입 처리
	@PostMapping("/join")
	public String join(MemberVO vo, RedirectAttributes rttr) {
		memberService.join(vo);
		rttr.addFlashAttribute("message", "회원가입성공");
		return "redirect:/";
		
	}
}
