package com.st.hb;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends  CrudRepository<Job, String>{
	int countById(String id);
	
	@Query(value="from Job j where j.minsal > 5000")
	List<Job>  getCostlyJobs();
	
	@Query(value="select * from jobs where min_salary > ?1",
		   nativeQuery=true)
	List<Job>  getCostlyJobs(int minSal);
	
}
