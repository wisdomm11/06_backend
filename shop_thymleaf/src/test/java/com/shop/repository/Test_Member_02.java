package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Test_Member_02 {
	
	@Autowired
	Test_MemberRepository test_MemberRepository;
	
	@Test
	void allPrint() {
		List<Test_Member> test_Members = test_MemberRepository.findAll();
		System.out.println("모두 출력하기");
		for (Test_Member member : test_Members) {
			System.out.println(member.getName());
			System.out.println(member.getPhone());
			System.out.println(member.getAge());
			System.out.println(member.getCreateDate());
		}
		
	}
	
	

}
