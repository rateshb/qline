package com.startup.qline.domain;

public enum TypeOfAnswer {

	SUBJECTIVE("Subjective"),
	OBJECTIVE_SINGLE_CHOICE("Single Option"),
	OBJECTIVE_MULTIPLE_CHOICE("Mutiple Option"),
	MIXED("Subjective With Options Mixed");
	
	private String displayString;
	
	private TypeOfAnswer(String display) {
		this.displayString = display;
	}

	@Override
	public String toString() {
		return this.displayString;
	}
	
	public String getDisplayString() {
		return this.displayString;
	}
}
