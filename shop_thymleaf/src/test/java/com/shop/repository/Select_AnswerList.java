package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

import jakarta.transaction.Transactional;

@SpringBootTest
public class Select_AnswerList {
	// 퀘스천 객체에서 앤서 리스트 출력
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	@Transactional // 퀘스천 앤서를 하나의 트랜잭션에서 처리하는것 // 묶어서 하는것
	void selectAnswerList() {
		// 1번 질문에 대한 답변들을 출력하기
		Optional<Question> oq = questionRepository.findById(3);
		
		Question q = new Question();
		if(oq.isPresent()) {
			q = oq.get();
		}
		
		// 끄집어낸 퀘스천 출력 
		System.out.println(q.getId());
		System.out.println(q.getContent());
		System.out.println(q.getSubject());
		System.out.println(q.getCreateDate());
		
		List<Answer> answerList = q.getAnswerList();
		System.out.println("=== 답변 내용 출력 ===");
		for(int i=0; i<answerList.size(); i++) {
			Answer a = new Answer();
			a = answerList.get(i);
			
			System.out.println("아이디" + a.getId() + "\t");
			System.out.println("내용" +a.getContent() + "\t");
			System.out.println("날짜" +a.getCreateDate() + "\t");
			System.out.println();
			
			
		}
	}
	
	
}
