package com.st.hb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobsManager implements CommandLineRunner {

	@Autowired
	private JobRepository jobRepo;

	public static void main(String[] args) {
		SpringApplication.run(JobsManager.class, args);
	}

	@Override
	public void run(String... args) {
	    System.out.println("Class : " + jobRepo.getClass());
	   //updateJobTitle("SD_DEV","Spring MVC Developer");
	   //deleteJob("SP_DEV");
	   countByJobId();
	}
	
	public void countByJobId() {
       System.out.println("No. of employees for IT_PROG  : " +  
	         jobRepo.countById("IT_PROG"));
	}
	
	public void listJobs() {
		List<Job> jobs = (List<Job>) jobRepo.findAll();
		for (Job j : jobs) {
			System.out.println(j.getTitle());
		}
	}
	public void updateJobTitle(String id, String title)
	{
		// Update a job title
		Optional<Job> job = jobRepo.findById(id);
		if (!job.isPresent()) {
			System.out.println(id + " Job Id Not Found");
			return;
		}
		
		Job sj = job.get();
		sj.setTitle(title);
		jobRepo.save(sj);  // Update 
	}
	
	public void deleteJob(String id)
	{
		jobRepo.deleteById(id);
	}
}
