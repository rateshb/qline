package com.qline.web.model;

import java.util.ArrayList;
import java.util.List;

import com.startup.qline.domain.AnswerOption;
import com.startup.qline.domain.Question;

public class QuestionAnswerModel {

	private Question question;
	
	private List<AnswerOption> options;

	public Question getQuestion() {
		
		if( question == null) {
			 question = new Question();
		}
		
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<AnswerOption> getOptions() {
		
		if(options == null) {
			options = new ArrayList<AnswerOption>(5);
		}
		return options;
	}

	public void setOptions(List<AnswerOption> options) {
		this.options = options;
	}

	
}
