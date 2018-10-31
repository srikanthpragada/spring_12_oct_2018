package webdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webdemo.hb.Job;
import webdemo.hb.JobRepository;

@RestController 
@RequestMapping("restjobs")
public class JobsRestController{
	
	@Autowired 
	private JobRepository jobRepo ;
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Job> listJobs () {
		return jobRepo.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Job getJob (@PathVariable("id") String id) {
		return jobRepo.findById(id).get();
	}
	
	@RequestMapping(value="searchjobs", method=RequestMethod.GET)
	public Iterable<Job> searchJobs (@RequestParam("title") String title) {
	     System.out.println("Searching for " + title);
	     List<Job>  jobs = jobRepo.getJobsByTitle("%" + title.toUpperCase() + "%");
	     return jobs;
	}
	
}
