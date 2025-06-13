package com.shop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Test_Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String phone;
	private int age;
	private LocalDateTime createDate;
	
	// 1번 db 만든것 // 레코드 100개 // for문 사용하기 // 각 필드 값 레코드 100개 추가 // 인서트
	// 2번 // 레코드 전체 출력
	// 3번 // 99번 레코드를 콘솔에 찍어보기 // 셀렉트
	// 4번 // 99번 레코드를 수정하기 // 업데이트
	// 5번 // 95번 레코드를 삭제하기 // 딜리트
	
	
	
}
