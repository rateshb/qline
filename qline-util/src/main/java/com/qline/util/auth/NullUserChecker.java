package com.qline.util.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

public class NullUserChecker implements UserDetailsChecker {

	@Override
	public void check(UserDetails toCheck) {
		
	}

}
