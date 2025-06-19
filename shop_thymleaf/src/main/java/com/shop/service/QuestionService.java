package com.shop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.exception.DataNotFoundException;
import com.shop.repository.AnswerRepository;
import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	
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
	
	// 질문 등록
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    
    // 스프링 프레임워크 도메인 // 페이지 !!
    // 질문 리스트 // 페이징 처리
    public Page<Question> getList(int page) {
        
    	
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
    	
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }
    
    
    public Page<Answer> getList(int page, Question question) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
    	
        Pageable pageable = PageRequest.of(page, 3, Sort.by(sorts));
        return this.answerRepository.findAll(pageable);
    }
    
    

	
	
	
	
}
