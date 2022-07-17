package com.fatihtoker.Login.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fatihtoker.Login.domain.Login;
import com.fatihtoker.Login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService userService;
	
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Login login){
		Login oauthUser = userService.login(login.getUsername(), login.getPassword());
		userService.getInfo();
		
		
		if (Objects.nonNull(oauthUser)) {
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse reponse){
		return "redirect:/login";
	}
}
