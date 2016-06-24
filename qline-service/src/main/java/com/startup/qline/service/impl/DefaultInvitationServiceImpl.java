package com.startup.qline.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.qline.util.date.DateUtils;
import com.qline.util.event.InvitationMailEvent;
import com.startup.qline.domain.Invitation;
import com.startup.qline.domain.Quiz;
import com.startup.qline.domain.dao.InvitationDao;
import com.startup.qline.service.InvitationService;
import com.startup.qline.service.QuizService;

@Component
public class DefaultInvitationServiceImpl implements InvitationService, ApplicationEventPublisherAware {

	@Autowired
	private InvitationDao invitationDao;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private PasswordEncoder jasyptPasswordEncoder;

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
			cal.add(Calendar.DATE, 1);
			invitation.setValidTo(cal.getTime());
			
			invitation.setInvitationCode(jasyptPasswordEncoder.encodePassword(emailAdd[i] + quizCode, null));
			invitationDao.create(invitation);
			
			InvitationMailEvent event = new InvitationMailEvent(invitation);
			applicationEventPublisher.publishEvent(event);
		}
	}

	@Override
	public Invitation loadInvitationByInvitationCode(String invitationCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("invitationCode", invitationCode);
		Invitation invitation = (Invitation) invitationDao.findObjectByNamedQuery("invitation.findByInvitationCode", params);
		return invitation;
	}
	
	@Override
	public boolean validateInviationCode(String invitationCode) {
		Invitation invitation = loadInvitationByInvitationCode(invitationCode);
		if(!invitation.isUsed()) {
			if(DateUtils.isCurrentDateBetween(invitation.getValidFrom(), invitation.getValidTo())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Quiz loadQuiz(String invitationCode) {
		Invitation invitation = loadInvitationByInvitationCode(invitationCode);
		return quizService.loadQuiz(invitation.getQuizCode());
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
	}
}
