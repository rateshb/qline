package com.startup.qline.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.startup.qline.domain.Quiz;
import com.startup.qline.domain.QuizStatus;
import com.startup.qline.domain.dao.QuizDao;
import com.startup.qline.service.QuizService;

@Component
public class DefaultQuizService implements QuizService {

	@Autowired
	private QuizDao quizDao;
	
	@Override
	@Transactional
	public Quiz createQuiz(Quiz quiz) {
		String quizCode = UUID.randomUUID().toString();
		quiz.setQuizCode(quizCode);
		return quizDao.create(quiz);
	}

	@Override
	@Transactional
	public Quiz load(Long id) {
		return quizDao.get(Quiz.class, id);
	}

	@Override
	public Quiz loadQuiz(String quizCode) {
		return quizDao.loadByQuizCode(quizCode);
	}

	@Override
	public Quiz markCompleteQuiz(Quiz quiz) {
		quiz.setStatus(QuizStatus.COMPLETE);
		quizDao.update(quiz);
		
		return quiz;
	}
	
}
