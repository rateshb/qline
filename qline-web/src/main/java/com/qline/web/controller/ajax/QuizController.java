package com.qline.web.controller.ajax;

import java.util.List;

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
import com.startup.qline.domain.Question;
import com.startup.qline.domain.Quiz;
import com.startup.qline.domain.QuizStatus;
import com.startup.qline.service.InvitationService;
import com.startup.qline.service.QuestionarieService;
import com.startup.qline.service.QuizService;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private InvitationService invitationService;
	
	@Autowired
	private QuestionarieService questionarieService;

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
	
	@RequestMapping(value="/completeQuiz", method=RequestMethod.POST)
	@Transactional
	public String completeQuiz(HttpServletRequest request, Model model,
			@RequestBody String quizId) {
		Quiz quiz = quizService.load(Long.getLong(quizId));
		quizService.markCompleteQuiz(quiz);
//		request.setAttribute("quiz", updatedQuiz);
//		request.setAttribute("questionModel", questionModel);
		return "redirect:/addQuestion?quizCode="+quiz.getQuizCode();
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
	
	@RequestMapping(value="/takeAQuiz", method=RequestMethod.POST)
	@Transactional
	public String takeAQuiz(HttpServletRequest request,Model model) {
		String invitationCode = request.getParameter("invitationCode");
		
		boolean isValid = invitationService.validateInviationCode(invitationCode);
		
		if(isValid) {
		    Quiz quiz = invitationService.loadQuiz(invitationCode);
		    List<Question> questions = questionarieService.loadQuestions(quiz.getId());
		    model.addAttribute("quiz", quiz);
		    model.addAttribute("questions", questions);
		    model.addAttribute("invitationCode", invitationCode);
			return "showQuiz";
		} else {
			//TODO: Add Error Message and return to the same page
			return "redirect:/";
		}
		
		
	}
	
	@RequestMapping(value="/startQuiz", method=RequestMethod.GET)
	@Transactional
	public String startQuiz(HttpServletRequest request,Model model) {
		String invitationCode = request.getParameter("ic");
		
		boolean isValid = invitationService.validateInviationCode(invitationCode);
		
		if(isValid) {
		    Quiz quiz = invitationService.loadQuiz(invitationCode);
		    List<Question> questions = questionarieService.loadQuestions(quiz.getId());
		    model.addAttribute("quiz", quiz);
		    model.addAttribute("questions", questions);
		    model.addAttribute("invitationCode", invitationCode);
			return "showQuiz";
		} else {
			//TODO: Add Error Message and return to the same page
			return "redirect:/";
		}
		
		
	}
	@RequestMapping(value="/getQuizById", method=RequestMethod.GET)
	@Transactional
	public @ResponseBody JsonRpc<Quiz> getQuizById(HttpServletRequest request,
			@RequestParam String id) {
		
		Quiz quiz = quizService.load(Long.parseLong(id));
		return new JsonRpc<Quiz>(quiz);
	} 
	
}
