package com.example.demo_gradle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
	
	private String name;
	private String nickName;
	private String age;
	private double weight;
	private String addr;
	
	// DTO // 데이터를 전송해주는 역할을 하는것
		// 기본생성자, 모든 필드의 값을 할당하는 생성자
		// getter() setter() 
}
