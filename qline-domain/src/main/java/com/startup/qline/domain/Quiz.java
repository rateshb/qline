package com.startup.qline.domain;

import java.io.Serializable;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.qline.orm.domain.AbstractEntity;

@Entity
@Table(name="QUIZ")
@NamedQueries(value = {
	@NamedQuery(name="quiz.findByQuizCode", query="select q from Quiz q where q.quizCode=:quizCode")
})
public class Quiz extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -858296577417913788L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="QUIZ_NAME", length=60)
	private String name;
	
	@Column(name="CATEGORY", length=100)
	private String category;
	
	@Column(name="SUB_CATEGORY", length=100)
	private String subCategory;
	
	@Column(name="TYPE_OF_QUIZ")
	private String typeOfQuiz;

	@Column(name="NUMBER_OF_QUESTION")
	private Long noOfQuestions;
	
	@Column(name="IS_MARKING_REQ")
	private Boolean markingRequired;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", insertable=false, updatable=false)
	private User owner;
	
	@Column(name="QUIZ_CODE")
	private String quizCode;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private QuizStatus status = QuizStatus.START;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getTypeOfQuiz() {
		return typeOfQuiz;
	}

	public void setTypeOfQuiz(String typeOfQuiz) {
		this.typeOfQuiz = typeOfQuiz;
	}

	public Long getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(Long noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public Boolean getMarkingRequired() {
		return markingRequired;
	}

	public void setMarkingRequired(Boolean markingRequired) {
		this.markingRequired = markingRequired;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getQuizCode() {
		return quizCode;
	}

	public void setQuizCode(String quizCode) {
		this.quizCode = quizCode;
	}

	public QuizStatus getStatus() {
		return status;
	}

	public void setStatus(QuizStatus status) {
		this.status = status;
	}
	
	
}
