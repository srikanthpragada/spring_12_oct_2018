package com.st.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@SpringBootApplication
public class TestJdbc implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;
	
	private SimpleJdbcInsert sji;
	
	public TestJdbc(DataSource ds) {
		this.sji = new SimpleJdbcInsert(ds);
		sji.setTableName("jobs");
	}

	public static void main(String[] args) {
		SpringApplication.run(TestJdbc.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// listJobObjects();
		listEmpsByDept(80);
		//addJob("SP_DEV","Spring Developer");
	}

	public void updateSalary() {
		int count = jdbcTemplate.
				update("update employees set salary = salary * 1.1 where employee_id = 111");
		System.out.println("Count = " + count);
	}

	public void listJobs() {
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select job_id id, job_title title from jobs");

		for (Map<String, Object> row : result) {
			System.out.printf("%-10s %s\n", row.get("id"), row.get("title"));
		}
	}
	
	// Map row to Job object 
    class JobMapper implements RowMapper<Job> {
		@Override
		public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Job(rs.getString("job_id"), rs.getString("job_title"));
		}
    }


	public void listJobObjects() {
		List<Job> jobs = jdbcTemplate.query("select * from jobs", 
				 (rs, index) -> {
			      return new Job(rs.getString("job_id"), rs.getString("job_title"));
		         }
	    );
		
		// List<Job> jobs = jdbcTemplate.query("select * from jobs",new JobMapper()); 

		for (Job job : jobs) {
			System.out.printf("%-10s %s\n", job.getId(), job.getTitle());
		}
	}
	
	public void listEmpsByDept(int dept) {
		Map<String,Integer> params = new HashMap<>();
		params.put("dept",dept);
		
		List<String> emps = namedTemplate.queryForList
		 ("select first_name from employees where department_id = :dept",
		 params,
		 String.class);
		for (String name : emps) {
			System.out.println(name);
		}
	}
	
	
	public void addJob(String id,String title) {
		Map<String,String> cols = new HashMap<>();
		cols.put("job_id",id);
		cols.put("job_title",title);
		
		int count = sji.execute(cols);
		System.out.printf("\nInserted %d rows\n",count);
	}
	
	

}
