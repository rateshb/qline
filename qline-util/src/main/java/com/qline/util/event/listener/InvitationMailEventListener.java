package com.qline.util.event.listener;

import com.qline.util.event.InvitationMailEvent;

public class InvitationMailEventListener extends AbstractApplicationListener<InvitationMailEvent> {

	@Override
	public void onEvent(InvitationMailEvent event) throws Exception {
		//TODO: Retrieve the Message Template base on the eventType
		//Create the EmailMessage and persist
	}
}
