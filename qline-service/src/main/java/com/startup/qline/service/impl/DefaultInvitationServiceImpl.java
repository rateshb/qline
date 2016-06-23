package com.startup.qline.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.qline.util.event.InvitationMailEvent;
import com.startup.qline.domain.Invitation;
import com.startup.qline.domain.dao.InvitationDao;
import com.startup.qline.service.InvitationService;

@Component
public class DefaultInvitationServiceImpl implements InvitationService, ApplicationEventPublisherAware {

	@Autowired
	private InvitationDao invitationDao;
	
	protected ApplicationEventPublisher applicationEventPublisher;
	
	@Transactional
	@Override
	public void inviteFriends(String quizCode, String inviteByEmail) {
		String[] emailAdd = inviteByEmail.split(";");

		for (int i = 0; i < emailAdd.length; i++) {
			Invitation invitation = new Invitation();
			invitation.setEmailAddress(emailAdd[i]);
			invitation.setQuizCode(quizCode);
			
			Calendar cal = Calendar.getInstance();
			
			invitation.setValidFrom(cal.getTime());
			cal.add(Calendar.MONTH, 1);
			
			invitation.setValidTo(cal.getTime());
			
			//TODO: create Invitation code
			invitationDao.create(invitation);
			
			//TODO: send event for Email creation
			InvitationMailEvent event = new InvitationMailEvent(invitation);
			applicationEventPublisher.publishEvent(event);
		}

	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
	}

}
