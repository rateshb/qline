package com.qline.util.event.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.qline.util.security.SystemAuthenticationToken;

public abstract class AbstractApplicationListener<E extends ApplicationEvent> implements
		ApplicationListener<E> {

	/** System authentication object. */
	private static Authentication authentication;
	private static Logger logger = LoggerFactory.getLogger(AbstractApplicationListener.class);
	
	/**
	 * Initializing the Authentication object 
	 */
	static{
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_SYSTEM"); 
		SystemAuthenticationToken systemAuthenticationToken = new SystemAuthenticationToken(authorities);
		authentication = systemAuthenticationToken;
	}
	
	/**
	 * Overriding the default callback method on event occurrence and setting SYSTEM authentication object,
	 * and calling onEvent function which will be implemented by the sub classes.
	 * It comes with a declarative transaction support.
	 */
	@Override
	@Transactional
	public final void onApplicationEvent(E event) {
		if (event != null) {
			logger.debug("*** Raised Event *** " + getClass().getName());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			try {
				onEvent(event);
			} catch (Exception e) {
				logger.error("Exception occured while listening to EmployerStatusChangeEventListener!", e);
			}
		}
	}
	
	
	/**
	 * Callback method on event occurrence
	 * @param event
	 */
	public abstract void onEvent(E event) throws Exception; 
	
}
