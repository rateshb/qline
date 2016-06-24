package com.startup.qline.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.startup.qline.domain.User;

public interface UserService extends UserDetailsService {

	User create(User user);

}
