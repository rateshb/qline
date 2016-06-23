package com.qline.util.event;

import com.qline.util.event.listener.EventType;

public class InvitationMailEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static String INVIATION_MAIL = "invitationMail";
	
	public InvitationMailEvent(Object eventContext) {
		super(EventType.INVIATION_MAIL, eventContext);
	} 
	
//	public InvitationMailEvent(String eventId, Object eventContext) {
//		super(eventId, eventContext);
//	}

}
