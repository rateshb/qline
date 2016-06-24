package com.startup.qline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qline.orm.domain.AbstractEntity;

@Entity
@Table(name="CATEGORY")
public class Category extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6949978773592804328L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="CATEGORY_CODE")
	private String categoryCode;
	
	@Column(name="CATEGORY_DESCRIPTION")
	private String categoryDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
}
