package kr.co.js12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDto {
	private String a_id;
	private String a_pw;
	private String a_name;
	private String a_phone;
	private int a_approval;
}
