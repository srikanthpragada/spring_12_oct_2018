package webdemo.hb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Table(name = "jobs")
@Entity
public class Job {

	@Id
	@Column(name = "Job_id")
	@Size(min=2, message = "Job Id must have a mininum of 2 chars")
	private String id;

	@Column(name = "Job_title")
	@Size(min=5, message = "Job title must have a mininum of 5 chars")
	private String title;

	@Column(name = "min_salary")
	@Min(2000)
	private int minsal;

	@Column(name = "max_salary")
	@Min(1000)
	@Max(100000)
	private int maxsal;

	public int getMaxsal() {
		return maxsal;
	}

	public void setMaxsal(int maxsal) {
		this.maxsal = maxsal;
	}

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
