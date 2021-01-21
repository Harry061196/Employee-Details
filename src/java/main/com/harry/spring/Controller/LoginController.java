package com.harry.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harry.spring.Model.Login;

@Controller
public class LoginController {
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg","Please enter your login credentials");
		return "login";
	}
	
//Still Work in Progress for Login 
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String submit(Model model, @ModelAttribute("loginbean") Login loginbean) {
//		if(loginbean != null && loginbean.getUserName()!=null && loginbean.getPassword()!=null) {
//			if(loginbean.getUserName().equals("admin") && loginbean.getPassword().equals("admin123")) {
////				model.addAttribute("msg", loginbean.getUserName());
//				return "redirect:employees";
//			}else {
//				model.addAttribute("error","Invalid details");
//				return "login";
//			}
//		}else {
//			model.addAttribute("error","Please enter details");
//			return "login";
//		}
//	}

}
