package com.qline.web.controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qline.web.model.UserDetails;
import com.startup.qline.domain.User;
import com.startup.qline.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private RememberMeServices rememberMeServices;
	
	@Autowired
	private AuthenticationEventPublisher authEventPublisher;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String showSignUpPage(HttpServletRequest request, Model model) {
		model.addAttribute("newUser", new UserDetails());
		return "signup";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.GET)
	public String showLoginPage(HttpServletRequest request) {
		return "login";
	}
	
	@RequestMapping(value="/submitUser", method=RequestMethod.POST) 
	@Transactional
	public String submitUser(HttpServletRequest request,
			@ModelAttribute("newUser") UserDetails userDetails, HttpServletResponse response) {
		User user = convertToUser(userDetails);
		User updateUser = userService.create(user);
		autoLogin(updateUser.getUsername(), userDetails.getPassword(), request, response);
		return "redirect:/";
	}

	private User convertToUser(UserDetails userDetails) {
		User user = new User();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmailId(userDetails.getEmailId());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		return user;
	}
	
	protected void autoLogin(String userName, String password, HttpServletRequest request, HttpServletResponse response) {
		Authentication authRequest = new UsernamePasswordAuthenticationToken(userName, password);
		Authentication authResult = authenticationManager.authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(authResult);
		//sessionProtectionStrategy.onAuthentication(authResult, request, response);
		if (rememberMeServices != null) {
			rememberMeServices.loginSuccess(request, response, authResult);
		}
		authEventPublisher.publishAuthenticationSuccess(authResult);
	}
	
	public void setRememberMeServices(RememberMeServices rememberMeServices) {
		this.rememberMeServices = rememberMeServices;
	}
}
