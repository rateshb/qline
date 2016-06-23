package com.startup.qline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.qline.orm.domain.AbstractEntity;
import com.qline.util.event.listener.EventType;

@Entity
@Table(name="EMAIL_TEMPLATE")
public class EmailTemplate extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3889020796753870891L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="EVENT_TYPE")
	@Enumerated(EnumType.STRING)
	private EventType eventType;
	
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	@Column(name="MESSAGE_TYPE")
	private String type;
	
	@Lob
	@Column(name = "EMAIL_TEMPLATE_DOCUMENT")
	private byte[] templatedocument;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getTemplatedocument() {
		return templatedocument;
	}

	public void setTemplatedocument(byte[] templatedocument) {
		this.templatedocument = templatedocument;
	}
}
