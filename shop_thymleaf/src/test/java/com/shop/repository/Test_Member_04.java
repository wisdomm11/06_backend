package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Test_Member_04 {
	
	@Autowired
	Test_MemberRepository test_MemberRepository;
	
	@Test
	void update99() {
		Optional<Test_Member> om = test_MemberRepository.findById(199);
		Test_Member member = new Test_Member();
		if (om.isPresent()) {
			member = om.get();
		}
		
		member.setName("apple");
		member.setPhone("010-1111-2222");
		member.setAge(20);
				
		System.out.println(member.getName());
		System.out.println(member.getPhone());
		System.out.println(member.getAge());
		System.out.println(member.getCreateDate());
		
		test_MemberRepository.save(member);
	}
	
	

}
