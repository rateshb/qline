package com.startup.qline.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.startup.qline.domain.User;
import com.startup.qline.domain.dao.UserDao;
import com.startup.qline.service.UserService;


public class DefaultUserService implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder jasyptPasswordEncoder;
	
	@Override
	public User create(User user) {
		String encodedPassword = jasyptPasswordEncoder.encodePassword(user.getPassword(), null);
		user.setPassword(encodedPassword);
		return userDao.create(user);
	}

	/**** Method for Authentication ***/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("username", username);
		
		User user = (User) userDao.findObjectByNamedQuery("user.findByUsername", queryParameters);
		
		if (user == null) {
			throw new UsernameNotFoundException("User is nor registered");
		}
		
		UserDetails userDetails = convertToUserDetails(user);
		return userDetails;
	}

	private UserDetails convertToUserDetails(User user) {
		UserDetails userDetails = new com.startup.qline.security.model.UserDetails(user.getUsername(), user.getPassword(), true, true, true, true, Collections.EMPTY_LIST);
		return userDetails;
	}


}
