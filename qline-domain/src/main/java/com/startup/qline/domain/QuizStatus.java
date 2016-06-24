package com.startup.qline.domain;

public enum QuizStatus {

	START("Start"),
	IN_PROGRESS("In Progress"),
	COMPLETE("Complete");
	
	private String displayString;
	
	private QuizStatus(String display) {
		this.displayString = display;
	}
	
	public String getDisplayString() {
		return this.displayString;
	}
}
