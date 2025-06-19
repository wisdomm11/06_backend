package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Answer;
import com.shop.entity.Question;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	Page<Answer> findByQuestion(Question question, Pageable pageable);

	
}
