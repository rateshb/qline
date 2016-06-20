package com.startup.qline.service;

import java.util.List;

import com.startup.qline.domain.Question;

public interface QuestionarieService {

	Question createQuestion(Question question);
	
	List<Question> loadQuestions(Long quizId);
	
	Question loadQuestion(Long questionId);
}
