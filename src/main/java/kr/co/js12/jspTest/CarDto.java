package kr.co.js12.jspTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
	private String number;
	private String model;
	private int engine;
	
}
