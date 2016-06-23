package com.qline.util.event.listener;

public enum EventType {

	INVIATION_MAIL("invitationMail");
	
	private String eventId;
	
	private EventType(String eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return this.eventId;
	}
}
