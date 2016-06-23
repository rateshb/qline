package com.qline.util.event;

import java.util.Map;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.userdetails.User;

import com.qline.util.event.listener.EventType;

/**
 * The Class AbstractEvent.
 */
public abstract class AbstractEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -289739728295798723L;

	/** The event id. */
	protected EventType eventType;

	/** The event context. */
	protected Object eventContext;
	
	/** Event initiator details in case event is raised because of an activity by a logged in user */
	protected User initiatedBy;

	/**
	 * Instantiates a new abstract event.
	 *
	 * @param eventId the event id
	 * @param eventContext the event context
	 */
	public AbstractEvent(EventType eventType, Object eventContext) {
		super(eventType.name());
		this.eventType = eventType;
		this.eventContext = eventContext;
	
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null && auth.getPrincipal() instanceof User) {
//			this.initiatedBy = (User) auth.getPrincipal();
//		}
	}

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * Gets the event context.
	 *
	 * @return the event context
	 */
	public Object getEventContext() {
		return eventContext;
	}

	public User getInitiatedBy() {
		return initiatedBy;
	}

	/**
	 * Gets the context params.
	 *
	 * @param paramName the param name
	 * @return the context params
	 */
	@SuppressWarnings("unchecked")
	public Object getContextParams(String paramName) {
		if(eventContext == null || !(eventContext instanceof Map)) {
			return null;
		}
		return ((Map<String, Object>)eventContext).get(paramName);
	}
}
