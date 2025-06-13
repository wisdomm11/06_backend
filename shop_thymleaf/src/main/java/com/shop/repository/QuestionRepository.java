package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// 레파지토리
	// dao // 데베 접근하는것
	// dto // 데이터 전달해주는것
	
	// jpa 레파지토리
}
