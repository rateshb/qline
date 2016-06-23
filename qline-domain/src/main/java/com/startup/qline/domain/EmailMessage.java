package com.startup.qline.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.qline.orm.domain.AbstractEntity;

/**
 * The persistent class for the NS_EMAIL database table.
 */
@Entity
@Table(name = "EMAIL_MESSAGE")
public class EmailMessage extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "BCC_EMAIL")
	private String bccEmail;

	@Lob
	@Column(name = "MESSAGE_BODY")
	private byte[] body;

	@Column(name = "CC_EMAIL")
	private String ccEmail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_RECEIVED")
	private Date dateReceived = Calendar.getInstance().getTime();

	@Column(name = "FROMEMAIL")
	private String fromEmail;

	@Column(name = "FROMNAME")
	private String fromName;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "TO_EMAIL")
	private String toEmail;

	@Column(name="EMAIL_TEMPLATE_ID")
	private Long emailTemplateId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBccEmail() {
		return bccEmail;
	}

	public void setBccEmail(String bccEmail) {
		this.bccEmail = bccEmail;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

	public String getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public Long getEmailTemplateId() {
		return emailTemplateId;
	}

	public void setEmailTemplateId(Long emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

}