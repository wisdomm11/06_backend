package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Test_Member_03 {
	
	@Autowired
	Test_MemberRepository test_MemberRepository;
	
	
	@Test
	void print99() {
		Optional<Test_Member> om = test_MemberRepository.findById(199);
		Test_Member member = new Test_Member();
		if (om.isPresent()) {
			member = om.get();
		}
		
		System.out.println(member.getName());
		System.out.println(member.getPhone());
		System.out.println(member.getAge());
		System.out.println(member.getCreateDate());
	}
	

	

}
