package com.startup.qline.domain.dao;

import com.startup.qline.domain.Quiz;

public interface QuizDao extends GenericDAO<Quiz>{

	Quiz loadByQuizCode(String quizCode);

}
