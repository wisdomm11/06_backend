package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.entity.Question;
import com.shop.exception.DataNotFoundException;
import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	// 퀘스천 테이블의 모든 값을 출력하는 메소드
	// 질문 리스트를 처리하는 메소드
	public List<Question> getList() {
		System.out.println("question 서비스 잘 요청됨");
		return questionRepository.findAll();
	}
	
	// 질문 상세를 처리하는 메소드
	public Question getQuestion(Integer id) {
		
		Optional<Question> question = questionRepository.findById(id);
		
		// Optional의 퀘스천 객체를 끄집어낼때 null이 아닌 경우 끄집어내기 // null인 경우 예외처리 필요
		if (question.isPresent()) {
			return question.get();
		} else {
			// 예외를 강제로 발생시키는것 // 프로그램이 종료되지않도록 예외를 처리하는것
			throw new DataNotFoundException("질문 데이터를 찾지 못했습니다  11122333");
		}
		
		
	}
	
	
	
	
}
