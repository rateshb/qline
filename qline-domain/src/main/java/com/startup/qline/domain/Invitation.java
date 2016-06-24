package com.startup.qline.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.qline.orm.domain.AbstractEntity;

@Entity
@Table(name="INVITATION")
@NamedQueries(value={
		@NamedQuery(name="invitation.findByInvitationCode", query="select i from Invitation i where i.invitationCode=:invitationCode")
})
public class Invitation extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994452837614107800L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="QUIZ_CODE")
	private String quizCode;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="INVITATION_CODE")
	private String invitationCode;
	
	@Column(name="VALID_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validFrom;
	
	@Column(name="VALID_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validTo;
	
	@Column(name="IS_USED")
	private boolean isUsed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuizCode() {
		return quizCode;
	}

	public void setQuizCode(String quizCode) {
		this.quizCode = quizCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	
	
}
