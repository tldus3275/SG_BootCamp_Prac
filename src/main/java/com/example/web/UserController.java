package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	private List<User> users=new ArrayList<>();
	
	@PostMapping("create")
	public String create(User user){
		users.add(user);
		
		log.debug("users size : " + users.size());
		//System.out.println("users size : " + users.size());
		//System.out.println("users size : " + users);
		
		return "redirect:/";
	}
	
	@GetMapping("list2")
	public String list(Model model) {
		model.addAttribute("users",users);
		return "/user/list";	
	}
}
