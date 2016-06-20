package com.qline.web.controller.ajax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qline.web.json.JsonRpc;
import com.startup.qline.domain.Quiz;
import com.startup.qline.service.QuizService;

@Controller
public class QuizController extends AbstractAjaxController {

	@Autowired
	private QuizService quizService;

	/*@RequestMapping(value="/start", method={RequestMethod.POST}) //,RequestMethod.GET
	public String startCreating(HttpServletRequest request,Model model) {
		Quiz quiz = new Quiz();
		model.addAttribute("quiz", quiz);
		return "create";
	}*/
	
	@RequestMapping(value="/submitQuiz", method=RequestMethod.POST) //, produces = "application/json"
	@ResponseBody
	public JsonRpc<Quiz> submitQuiz(HttpServletRequest request,Model model,
			  @RequestBody Quiz quiz) {
		System.out.println("Running.....................");
		Quiz updatedQuiz = quizService.createQuiz(quiz);
		/*QuestionAnswerModel questionModel = new QuestionAnswerModel();
		questionModel.getQuestion().setQuiz(updatedQuiz);
		model.addAttribute("quiz", updatedQuiz);
		model.addAttribute("questionModel", questionModel);*/
		return new JsonRpc<Quiz>(updatedQuiz);
	}
}
