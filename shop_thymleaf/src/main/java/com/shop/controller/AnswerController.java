package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.AnswerForm;
import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.service.AnswerService;
import com.shop.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	// 클라이언트 // 컨트롤러 // 서비스 // 레파지토리 // 엔티티 // 디비
	
	// 빈 주입
	private final AnswerService answerService;
	private final QuestionService questionService;
	

	
	
	// 답변 등록
	@PostMapping("/create/{id}")
	public String createAnswer(
			Model model,
			@PathVariable("id") Integer id,
			// @RequestParam("content") String content
			@Valid AnswerForm answerForm, 
			BindingResult bindingResult
			) {
		
		// 해당 질문을 가져오는것
		Question question = questionService.getQuestion(id);
		
//		System.out.println("답글 등록 요청 성공");
//		System.out.println("답글을 위한 퀘스천 아이디 : " + id);
//		System.out.println("답글 내용 : " + content);
		
		if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
		
		// 답변을 db에 저장하는것
		answerService.create(question, answerForm.getContent());
		
		
		return String.format("redirect:/question/detail/%s", id);
	}
	
	
	
	
}
