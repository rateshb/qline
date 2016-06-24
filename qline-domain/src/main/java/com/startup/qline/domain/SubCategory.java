package com.startup.qline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qline.orm.domain.AbstractEntity;

@Entity
@Table(name="SUB_CATEGORY")
public class SubCategory extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7650377924651730899L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="category_id", insertable=false, updatable=false)
	private Category category;
	
	@Column(name="SUB_CATEGORY_CODE")
	private String subCategoryCode;
	
	@Column(name="SUB_CATEGORY_DESC")
	private String subCategoryDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}

	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}

}
