package com.startup.qline.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserDetails extends org.springframework.security.core.userdetails.User {

	public UserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5923335560990369278L;
	
}
