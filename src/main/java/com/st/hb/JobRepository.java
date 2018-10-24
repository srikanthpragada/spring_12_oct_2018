package com.st.hb;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends  CrudRepository<Job, String>{
	int countById(String id);
}
