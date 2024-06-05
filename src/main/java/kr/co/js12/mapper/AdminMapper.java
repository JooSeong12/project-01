package kr.co.js12.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.js12.dto.AdminDto;

@Mapper
public interface AdminMapper {
	
	int adminInsert(@Param("adminDto")AdminDto adminDto);

	AdminDto loginConfirm(@Param("adminDto")AdminDto adminDto);

	List<AdminDto> adminList();

	int updateAdminAccount(String id);

	int modifyAccountConfirm(@Param("adminDto")AdminDto adminDto);

	List<AdminDto> searchId(Map<String, Object> params);

	
	
		
}
