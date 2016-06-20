package com.startup.qline.service.impl;

import org.springframework.stereotype.Component;

import com.startup.qline.service.InvitationService;

@Component
public class DefaultInvitationServiceImpl implements InvitationService {

	@Override
	public void inviteFriends(String quizCode, String inviteByEmail) {
		String[] emailAdd = inviteByEmail.split(";");

		for (int i = 0; i < emailAdd.length; i++) {
			System.err.println("Send Email to : " + emailAdd[i]
					+ " with Quiz Code :" + quizCode);
		}

	}

}
