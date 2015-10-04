package com.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id 
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE_TIME")
	private Date createdDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE_TIME")
	private Date updatedDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
