package com.startup.qline.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.qline.orm.domain.AbstractEntity;

@Entity
@Table(name="QUESTION")
@NamedQueries(value={
		@NamedQuery(name="questions.findByQuizID", query="select q from Question q where q.quiz.id=:quizId")
})
public class Question extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4518019502201866802L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="QUESTION_CONTENT", length=2000)
	private String questionContent;
	
	@Column(name="COMMENTS", length=2000)
	private String comments;
	
	@Column(name="ANSWER_TYPE")
	@Enumerated(EnumType.STRING)
	private TypeOfAnswer answerType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinTable(name = "question_answer_mapping", joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "id", insertable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "answer_id", referencedColumnName = "id", insertable = false, updatable = false)})
	private List<AnswerOption> options;

	@Column(name="ATTACHMENT_PATH", length=400)
	private String attachmentPath;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="quiz_id", referencedColumnName="id",insertable=true)
	private Quiz quiz;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public TypeOfAnswer getAnswerType() {
		return answerType;
	}

	public void setAnswerType(TypeOfAnswer answerType) {
		this.answerType = answerType;
	}

	public List<AnswerOption> getOptions() {
		return options;
	}

	public void setOptions(List<AnswerOption> options) {
		this.options = options;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
	
}
