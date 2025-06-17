package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.Question;
import com.shop.entity.Test_Member;
import com.shop.repository.QuestionRepository;
import com.shop.repository.Test_MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestMemberService {
	
	private final Test_MemberRepository testMemberRepository;
		
	// 퀘스천 테이블의 모든 값을 출력하는 메소드
	// 질문 리스트를 처리하는 메소드
	public List<Test_Member> getList() {
		System.out.println("question 서비스 잘 요청됨");
		return testMemberRepository.findAll();
	}

}
