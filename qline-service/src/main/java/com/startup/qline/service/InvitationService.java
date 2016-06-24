package com.startup.qline.service;

import com.startup.qline.domain.Invitation;
import com.startup.qline.domain.Quiz;

public interface InvitationService {

	void inviteFriends(String quizCode, String inviteByEmail);

	boolean validateInviationCode(String invitationCode);

	Quiz loadQuiz(String invitationCode);

	Invitation loadInvitationByInvitationCode(String invitationCode);
}
