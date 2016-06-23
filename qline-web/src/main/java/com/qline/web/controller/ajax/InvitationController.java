package com.qline.web.controller.ajax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qline.web.model.InvitationModel;
import com.startup.qline.service.InvitationService;

@Controller
public class InvitationController {

	@Autowired
	private InvitationService invitationService;
	
	@RequestMapping(value="inviteFriends", method=RequestMethod.POST)
	public String inviteFriends(HttpServletRequest request, @ModelAttribute(value="invitationModel") InvitationModel invitationModel) {
		
		invitationService.inviteFriends(invitationModel.getQuizCode(), invitationModel.getInviteByEmail());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="inviteGetFriends", method=RequestMethod.GET)
	public String inviteGetFriends(HttpServletRequest request) {
		
		InvitationModel invitationModel = new InvitationModel();
		invitationModel.setQuizCode("Test");
		invitationModel.setInviteByEmail("test@test.com");
		invitationService.inviteFriends(invitationModel.getQuizCode(), invitationModel.getInviteByEmail());
		
		return "redirect:/";
	}
}
