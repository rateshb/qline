package com.qline.orm.domain.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import com.qline.orm.domain.AbstractEntity;

public class QlineEntityListener {

	@PrePersist
	public void auditCreate(AbstractEntity persistent) {
		persistent.setCreatedDate(new Date());
		persistent.setUpdatedDate(new Date());
		String loggedInUserName = getLoggedInUsername();
		if(StringUtils.hasText(loggedInUserName)){
			persistent.setCreatedBy(loggedInUserName);
			persistent.setUpdatedBy(loggedInUserName);
		}else{
			persistent.setCreatedBy("SYSTEM");
			persistent.setUpdatedBy("SYSTEM");
		}
	}

	@PreUpdate
	public void auditUpdate(AbstractEntity persistent) {
		persistent.setUpdatedDate(new Date());
		String loggedInUserName = getLoggedInUsername();
		if(StringUtils.hasText(loggedInUserName)){
			persistent.setUpdatedBy(loggedInUserName);
		}else{			
			persistent.setUpdatedBy("SYSTEM");
		}
	}
	
	
	private String getLoggedInUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof UserDetails ) {
			return ((User) auth.getPrincipal()).getUsername();
		}
		return null;
	}
}
