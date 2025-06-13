package com.shop;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;
import com.shop.repository.QuestionRepository;

@SpringBootTest
class ShopThymleafApplicationTests {

	@Autowired
	QuestionRepository questionRepository;
	
	
	@Test
	void contextLoads() {
		
		// 객체 생성
		Question q = new Question();
		
		
		// setter 메소드를 호출해서 값을 입력하는것
		q.setSubject("Junit 테스트입니다 - 제목");
		q.setContent("Junit 테스트입니다 - 내용");
		q.setCreateDate(LocalDateTime.now());
		
		// 레파지토리를 사용해서 db에 저장하는것
		questionRepository.save(q);
		
		
	}

}
