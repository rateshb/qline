package com.qline.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qline.web.model.InvitationModel;
import com.qline.web.model.QuestionAnswerModel;
import com.startup.qline.domain.Quiz;
import com.startup.qline.service.QuizService;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;

	@RequestMapping(value="/start", method={RequestMethod.POST,RequestMethod.GET})
	public String startCreating(HttpServletRequest request,Model model) {
		Quiz quiz = new Quiz();
		model.addAttribute("quiz", quiz);
		return "create";
	}
	
	@RequestMapping(value="/submitQuiz", method=RequestMethod.POST)
	@Transactional
	public String submitQuiz(HttpServletRequest request,Model model,
			@ModelAttribute(value="quiz") Quiz quiz) {
		Quiz updatedQuiz = quizService.createQuiz(quiz);
		QuestionAnswerModel questionModel = new QuestionAnswerModel();
		questionModel.getQuestion().setQuiz(updatedQuiz);
		model.addAttribute("quiz", updatedQuiz);
		model.addAttribute("questionModel", questionModel);
		return "addQuestion";
	}
	
	
	@RequestMapping(value="/findQuiz", method=RequestMethod.POST)
	@Transactional
	public String findQuiz(HttpServletRequest request,Model model) {
		String quizCode = request.getParameter("quizCode");
		Quiz quiz = quizService.loadQuiz(quizCode);
		model.addAttribute("loadedQuiz", quiz);
		model.addAttribute("invitationModel", new InvitationModel());
		return "showQuiz";
	}
}
