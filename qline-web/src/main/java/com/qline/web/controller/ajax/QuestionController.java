package com.qline.web.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qline.web.model.QuestionAnswerModel;
import com.startup.qline.domain.Question;
import com.startup.qline.domain.Quiz;
import com.startup.qline.service.QuestionarieService;
import com.startup.qline.service.QuizService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionarieService questionarieService;
	
	@Autowired
	private QuizService quizService;
	
	//private QuestionarieService questionarieService;
	
	@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public String submitQuestion(HttpServletRequest request,Model model,
			@ModelAttribute(value="questionModel") QuestionAnswerModel questionAnswerModel) {
		
		Question question = questionAnswerModel.getQuestion();
		question.setOptions(questionAnswerModel.getOptions());

		Quiz attachQuiz = quizService.load(question.getQuiz().getId());
		question.setQuiz(attachQuiz);
		questionarieService.createQuestion(question);
		
		List<Question> questions = questionarieService.loadQuestions(attachQuiz.getId());
		
		QuestionAnswerModel questionModel = new QuestionAnswerModel();
		questionModel.getQuestion().setQuiz(attachQuiz);
		
		model.addAttribute("quiz", attachQuiz);
		model.addAttribute("questionModel", questionModel);
		model.addAttribute("questions", questions);
		
		return "addQuestion";
	}
}
