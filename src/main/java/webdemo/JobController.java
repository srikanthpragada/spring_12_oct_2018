package webdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import webdemo.hb.Job;
import webdemo.hb.JobRepository;

@Controller 
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobRepository jobRepo;
	
	@RequestMapping("/list")
	public String  list(ModelMap model)
	{
		 Iterable<Job> jobs =  jobRepo.findAll();
		 model.addAttribute("jobs",jobs);
		 return "list_jobs";
	}
	
	@RequestMapping("/add")
	public String add()
	{
		 return "add_job";
	}

}
