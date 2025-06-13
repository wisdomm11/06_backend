package com.shop.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;
import com.shop.entity.Test_Member;

@SpringBootTest
public class Test_Member_01 {
	
	@Autowired
	Test_MemberRepository test_MemberRepository;
	
	@Test
	void insert100Test_Member() {
		
		for (int i=1; i<=100; i++) {
			Test_Member test_member = new Test_Member();
			
			test_member.setName("이름" + i);
			test_member.setPhone("111" + i );
			test_member.setAge(10 + i);
			test_member.setCreateDate(LocalDateTime.now());
	
			System.out.println(test_member.getName());
			test_MemberRepository.save(test_member);
		}
	}
	
	
	
	
}
