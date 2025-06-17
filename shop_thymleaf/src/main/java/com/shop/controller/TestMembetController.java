package com.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.entity.Question;
import com.shop.entity.Test_Member;
import com.shop.service.QuestionService;
import com.shop.service.TestMemberService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequestMapping("/testmember")
@RequiredArgsConstructor
@Controller
public class TestMembetController {

	private final TestMemberService testMemberService;
	
	// 1번 // 클라이언트 요청
	@GetMapping("/list") // localhost:8082/testmember/list
	public String list(Model model) {
		
		// 2번 // 비즈니스 로직을 처리하는것
//		List<Question> questionList = questionRepository.findAll();
		List<Test_Member> testMemberList = testMemberService.getList();

		
		model.addAttribute("testMemberList", testMemberList);
//		System.out.println(testMemberList.get(1));
		
		for ( Test_Member t : testMemberList) {
			System.out.println(t.getName());
		}
		
		System.out.println("컨트롤러 요청 성공!!!!!");
		return "Lab/TestMemberList"; // 3번 뷰 페이지를 전송하는것
	}
	
}
