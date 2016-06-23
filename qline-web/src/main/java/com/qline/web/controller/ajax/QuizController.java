package com.qline.web.controller.ajax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qline.web.json.JsonRpc;
import com.qline.web.model.InvitationModel;
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
		request.getParameter("stn");
		return "create";
	}
	
	@RequestMapping(value="/submitQuiz", method=RequestMethod.POST)
	@Transactional
	public @ResponseBody JsonRpc<Quiz> submitQuiz(HttpServletRequest request,
			@RequestBody Quiz quiz) {
		Quiz updatedQuiz = quizService.createQuiz(quiz);
		//QuestionAnswerModel questionModel = new QuestionAnswerModel();
		//questionModel.getQuestion().setQuiz(updatedQuiz);
		//model.addAttribute("quiz", updatedQuiz);
		//model.addAttribute("questionModel", questionModel);
		return new JsonRpc<Quiz>(updatedQuiz);
	}
	
	@RequestMapping(value="/submitQuizN", method=RequestMethod.POST)
	@Transactional
	public String submitQuiz(HttpServletRequest request, Model model,
			@ModelAttribute("quiz") Quiz quiz) {
		Quiz updatedQuiz = quizService.createQuiz(quiz);
//		request.setAttribute("quiz", updatedQuiz);
//		request.setAttribute("questionModel", questionModel);
		return "redirect:/addQuestion?quizCode="+updatedQuiz.getQuizCode();
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
	
	@RequestMapping(value="/getQuizById", method=RequestMethod.GET)
	@Transactional
	public @ResponseBody JsonRpc<Quiz> getQuizById(HttpServletRequest request,
			@RequestParam String id) {
		
		Quiz quiz = quizService.load(Long.parseLong(id));
		return new JsonRpc<Quiz>(quiz);
	} 
	
}
