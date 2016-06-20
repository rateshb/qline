package com.startup.qline.service;

import java.util.List;

import com.startup.qline.domain.AnswerOption;

public interface AnswersService {

	List<AnswerOption> findAnswerOptions(Long questionId);
	
	Long createAnswerOption(AnswerOption option, Long questionId);
	
	void createAnswerOptions(List<AnswerOption> options, Long questionId);
	
	void addAnswerOption(AnswerOption option, Long questionId);
	
}
