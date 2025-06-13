package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Test_Member_05 {
	
	@Autowired
	Test_MemberRepository test_MemberRepository;
	
	@Test
	void delete95() {
		Optional<Test_Member> om = test_MemberRepository.findById(195);
		Test_Member member = new Test_Member();
		if (om.isPresent()) {
			member = om.get();
		}
		
		test_MemberRepository.delete(member);
				
		
	}

}
