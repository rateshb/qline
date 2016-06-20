package com.startup.qline.domain.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.startup.qline.domain.Quiz;

@Transactional(value="transactionManager",readOnly=false)
public class QuizDaoImpl extends GenericDAOImpl<Quiz> implements QuizDao {

	@Override
	public Quiz loadByQuizCode(String quizCode) {
     org.hibernate.Query query = ((Session) entityManager.getDelegate()).getNamedQuery("quiz.findByQuizCode");
   	 query.setParameter("quizCode", quizCode);
   	 return (Quiz) query.uniqueResult();
	}
	
}
