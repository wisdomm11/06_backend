package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.AnswerForm;
import com.shop.dto.QuestionForm;
import com.shop.entity.Question;
import com.shop.repository.QuestionRepository;
import com.shop.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//ioc 컨테이너에 빈(객체) 등록하는 어노테이션
		// 앳 컴포넌트 // 일반 클래스를 빈으로 등록하는것
		// 앳 컨트롤러 // 컨트롤러 클래스를 빈으로 등록하는것
		// 앳 서비스 // 서비스 클래스를 빈으로 등록하는것
		// 앳 레파지토리 // 레파지토리 클래스를 빈으로 등록하는것
	
	// di // 디펜던시 인젝션 // 의존성 주입 // ioc 컨테이너 빈을 변수에 주입하는것
		// 앳 오토와이어 // 타입을 가져와서 주입하는것 // 테스트 코드에서 사용하는것
	
		// 앳 리콰이어드 아그스 컨스트트럭터 // 생성자 주입 // 보안이 강한것
			// private final QuestionRepository questionRepository;


// 컨트롤러 역할 // 클라이언트 요청을 받는것 // 비즈니스 로직을 처리하는것 // 뷰 페이지 전송하는것

@RequestMapping("/question") // 겟 포스트
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
//	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	// 1번 // 클라이언트 요청
	@GetMapping("/list") // localhost:8082/question/list
	public String list(Model model) {
		
		// 2번 // 비즈니스 로직을 처리하는것
//		List<Question> questionList = questionRepository.findAll();
		List<Question> questionList = questionService.getList();

		
		model.addAttribute("questionList", questionList);
		
		System.out.println("컨트롤러 요청 성공");
		return "question_list"; // 3번 뷰 페이지를 전송하는것
	}
	
	// 질문 상세 페이지
		@GetMapping("/detail/{id}") // 중괄호 아이디는 변수!!
		public String detail(
				Model model,
				@PathVariable("id") Integer id,
				AnswerForm answerForm
				) {
			
//			System.out.println("id 변수 값 : " + id);
			
			// 넘겨받는 id값을 가지고 퀘스천 레파지토리 파인드바이아이디
			Question question =	questionService.getQuestion(id);
			
//			System.out.println(question.getSubject());
//			System.out.println(question.getContent());
//			System.out.println(question.getId());
			
			model.addAttribute("question", question);
			
			return "question_detail";
			
		}
		
		// 질문 등록 // 뷰 페이지 처리
	    @GetMapping("/create")
	    public String questionCreate(
	    		QuestionForm questionForm
	    		) {
	        return "question_form";
	    }
	    
	    // 질문 등록을 받아서 db에 저장하는것
	    @PostMapping("/create")
	    public String questionCreate (
	    		// @RequestParam(value="subject") String subject, 
	    		// @RequestParam(value="content") String content
	    		@Valid QuestionForm questionForm,
	    		BindingResult bindingResult
	    		) 
	    {
	    	
//	    	System.out.println("질문 등록 post 요청 성공");
//	    	System.out.println(subject);
//	    	System.out.println(content);
	    	System.out.println(questionForm.getSubject());
	    	System.out.println(questionForm.getContent());
	    	
	    	if(bindingResult.hasErrors()) {
	    		return "question_form";
	    	}

	        // TODO 질문을 저장한다.
	        questionService.create(questionForm.getSubject(), questionForm.getContent());


	        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
	    }
	    
	    
	    
	   

	    
	}

	    
	    

	
	
	
	

