package com.startup.qline.service;

import com.startup.qline.domain.Quiz;

public interface QuizService {

	Quiz createQuiz(Quiz quiz);
	
	Quiz load(Long id);

	Quiz loadQuiz(String quizCode);

	Quiz markCompleteQuiz(Quiz quiz);
}
