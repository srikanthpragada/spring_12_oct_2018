package com.st.hb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jobs")
@Entity
public class Job {

	@Id
	@Column(name = "Job_id")
	private String id;

	@Column(name = "Job_title")
	private String title;
	
	@Column(name = "min_salary")
	private int minsal;

	public int getMinsal() {
		return minsal;
	}

	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}

	public Job() {
		super();
	}

	public Job(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
