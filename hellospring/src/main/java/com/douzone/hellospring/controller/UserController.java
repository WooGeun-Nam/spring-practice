package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 * @RequestMapping 클래스 + 메소드 매핑
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo userVo) {
		// 스프링은 절때 Null을 주지 않는다.
		System.out.println(userVo);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value="n") String name) {
		// 만일 n이라는 이름의 URL 파라미터가 없으면 400 Bad Request Error 가 발생한다.
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=true, defaultValue="") String name) {
		// 추천하는 방식 -> default 값을 세팅하세욧
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) {
		// p로 들어오는 parameter를 pageNo로 넣어줌
		// defaultValue 는 String으로 해야함 , required -> false : 값이 없어도 됨, true : 값이 꼭 있어야 됨
		return "UserController.list(" + pageNo + ")";
	}
}
