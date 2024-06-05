package kr.co.js12.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.js12.dto.AdminDto;
import kr.co.js12.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	AdminMapper mapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public int adminInsert(AdminDto adminDto) {
		adminDto.setA_pw(passwordEncoder.encode(adminDto.getA_pw()));
		if(adminDto.getA_id().equals("admin")) {
			adminDto.setA_approval(1);
		}
		
		return mapper.adminInsert(adminDto);
	}
	public AdminDto loginConfirm(AdminDto adminDto) {
		AdminDto dto = new AdminDto();
		
		
		dto = mapper.loginConfirm(adminDto);
		return dto;
	}
	public List<AdminDto> adminList() {
		return mapper.adminList();
	}
	public int updateAdminAccount(String id) {
		return mapper.updateAdminAccount(id);
	}

	public int modifyAccountConfirm(AdminDto adminDto) {
		return mapper.modifyAccountConfirm(adminDto);
	}
	public List<AdminDto> searchId(String category, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("category", category);
		params.put("keyword", keyword);
		return mapper.searchId(params);
	}
	
}
