package com.shop.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 객체 주입
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	// 답글 등록 
	// insert // update // delete // 리턴이 없다
	// 셀렉트 // 셀렉트 값을 돌려줘야하는것
	public void create(Question question, String content) {
		Answer answer = new Answer();
		
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		answerRepository.save(answer);
		
	}
	
}
