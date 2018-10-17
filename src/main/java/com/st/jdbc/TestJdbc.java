package com.st.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class TestJdbc implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TestJdbc.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		listJobObjects();
	}

	public void updateSalary() {
		int count = jdbcTemplate.update("update employees set salary = salary * 1.1 where employee_id = 111");
		;
		System.out.println("Count = " + count);
	}

	public void listJobs() {
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select job_id id, job_title title from jobs");

		for (Map<String, Object> row : result) {
			System.out.printf("%-10s %s\n", row.get("id"), row.get("title"));
		}
	}


	public void listJobObjects() {
		List<Job> jobs = jdbcTemplate.query("select * from jobs", 
				 (rs, index) -> {
			      return new Job(rs.getString("job_id"), rs.getString("job_title"));
		         }
	    );

		for (Job job : jobs) {
			System.out.printf("%-10s %s\n", job.getId(), job.getTitle());
		}
	}

}
