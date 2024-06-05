package kr.co.js12.controller;





import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.js12.dto.AdminDto;
import kr.co.js12.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AdminService adminService;
	@GetMapping("")
	public String mainView() {
		return "/admin/main";
	}
	
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		return "/admin/create_account_form";
	}
	
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminDto adminDto) {
		System.out.println("createAccountConfirm : " + adminDto.toString());
		adminService.adminInsert(adminDto);
		return "/admin/create_account_form";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/admin/login_form";
	}
	
	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminDto adminDto, HttpSession session) {
		String nextPage = "/admin/login_ok";
		
		AdminDto adminLoginedDto = adminService.loginConfirm(adminDto);
		
		if(adminLoginedDto == null) {
			nextPage = "/admin/login_ng";
			return nextPage;
		}
		
		if(passwordEncoder.matches(adminDto.getA_pw(), adminLoginedDto.getA_pw())){
			session.setAttribute("adminLoginedDto", adminLoginedDto);
			session.setMaxInactiveInterval(60*30); //60초 * 30    즉 30분
			return nextPage;
		} else {
			System.out.println("유저 존재하지 않음.");
			nextPage = "/admin/login_ng";
			return nextPage;
		}	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
	
	@GetMapping("listupAdmin")
	public String listupAdmin(Model model) {
		String nextPage = "/admin/admin_list";
		
		List<AdminDto> adminDtos = adminService.adminList();
		model.addAttribute("adminDtos", adminDtos);
		return nextPage;
	}
	
	@GetMapping("/setAdminApproval")
	public String setAdminApproval(@RequestParam("id")String id) {
		String nextPage = "redirect:/admin/listupAdmin";
		int result = adminService.updateAdminAccount(id);
		return nextPage;
	}
	
	@GetMapping("/modifyAccountForm")
	public String modifyAccountForm(HttpSession session) {
		String nextPage = "/admin/modify_account_form";
		AdminDto adminDto = (AdminDto) session.getAttribute("adminLoginedDto");
		//현재 로그인 상태인지 확인
		if(adminDto == null) {
			nextPage = "redirect:/admin/loginForm";
		}
		// 로그인상태 : 수정 페이지로 이동
		
		// 로그아웃 상태(세션만료) : 로그인 페이지로 이동
		return nextPage;
	}
	
	@PostMapping("/modifyAccountConfirm")
	public String modifyAccountConfirm(AdminDto adminDto, HttpSession session) {
		String nextPage = "redirect:/admin/listupAdmin";
		//수정 후 관리자 리스트 페이지로 이동
		int result = adminService.modifyAccountConfirm(adminDto);
		if(result > 0) {
			session.setAttribute("adminLoginedDto", adminDto);
			session.setMaxInactiveInterval(60*30);
		}
		return nextPage;
	}
	
	@GetMapping("/searchAdminConfirm")
	public String searchAdminConfirm(@RequestParam("category")String category,
			@RequestParam("keyword")String keyword, Model model) {
		String nextPage = "/admin/search_admin_confirm";
		List<AdminDto> list = adminService.searchId(category, keyword);
		model.addAttribute("list", list);
		return nextPage;
	}
	
	@GetMapping("/handlerInterceptor")
	public String handlerInterceptor() {
		
		return "/admin/handlerInterceptor";
	}
}
