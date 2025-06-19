package com.shop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
    // 스프링 프레임워크 도메인 // 페이지 !!
    // 질문 리스트 // 페이징 처리
    public Page<Answer> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
    	
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.answerRepository.findAll(pageable);
    }
	
}
