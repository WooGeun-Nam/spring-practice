package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestBookRepository;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookRepository GuestBookRepository = new GuestBookRepository();
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestBookVo> list = GuestBookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/add")
	public String add(GuestBookVo vo) {
		GuestBookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/delete.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVo vo) {
		GuestBookRepository.deleteByPassword(vo.getNo(), vo.getPassword());
		return "redirect:/";
	}
}
