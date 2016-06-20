package com.startup.qline.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.startup.qline.domain.Question;
import com.startup.qline.domain.dao.QuestionDao;
import com.startup.qline.service.QuestionarieService;

@Component
public class DefaultQuestionaireService implements QuestionarieService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	@Transactional
	public Question createQuestion(Question question) {
		return questionDao.create(question);
	}

	@Override
	public List<Question> loadQuestions(Long quizId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("quizId", quizId);
		return questionDao.findByNamedQuery("questions.findByQuizID", params);
	}

	@Override
	public Question loadQuestion(Long questionId) {
		return questionDao.get(Question.class, questionId);
	}

}
