package webdemo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webdemo.hb.Job;
import webdemo.hb.JobRepository;

@Controller
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobRepository jobRepo;

	@RequestMapping("/list")
	public String list(ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		model.addAttribute("jobs", jobs);
		return "list_jobs";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		Job j = new Job();
		j.setMinsal(1000);
		j.setMaxsal(5000);
		model.addAttribute("job", j);
		return "add_job";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addJob(@Valid @ModelAttribute Job job, 
			             BindingResult result,  // Must follow model 
			             ModelMap model) {
		try {
			if (!result.hasErrors()) {
				jobRepo.save(job);
				model.addAttribute("message", "Job has been added successfully!");
				return "redirect:list";
			}
		} catch (Exception ex) {
			model.addAttribute("message", "Job could not be added!");
		}

		return "add_job";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteJob(@PathVariable("id") String id, ModelMap model) {
		System.out.println("Deleting " + id);

		try {
			Optional<Job> opjob = jobRepo.findById(id);
			if (opjob.isPresent()) {
				jobRepo.delete(opjob.get());
				return "redirect:/jobs/list";
			} else {
				model.addAttribute("message", "Job not found!");
				return "delete";
			}
		} catch (Exception ex) {
			System.out.println("Error during delete : " + ex.getMessage());
			model.addAttribute("message", "Job could not be deleted!");
			return "delete";
		}
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editJob(@PathVariable("id") String id, ModelMap model) {
		try {
			Optional<Job> opjob = jobRepo.findById(id);
			if (opjob.isPresent()) {
				model.addAttribute("job", opjob.get());
				return "edit_job";
			} else {
				return "id_not_found";
			}
		} catch (Exception ex) {
			System.out.println("Error in edit -->" + ex.getMessage());
			return "id_not_found";
		}
	}
		
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateJob(@PathVariable("id") String id,
			@Valid @ModelAttribute Job job,
			BindingResult result,
			ModelMap model) {
		try {
			if (result.hasErrors())
				return "edit_job";
			
			Optional<Job> opjob = jobRepo.findById(id);
			if (opjob.isPresent()) {
       		    Job dbJob = opjob.get();
       		    dbJob.setTitle(job.getTitle());
       		    dbJob.setMinsal(job.getMinsal());
       		    dbJob.setMaxsal(job.getMaxsal());
       		    jobRepo.save(dbJob);
       		    model.addAttribute("message","Updated Job Successfully!");
				return "edit_job";
			} else {
				return "id_not_found";
			}
		} catch (Exception ex) {
			System.out.println("Error in update -->" + ex.getMessage());
			model.addAttribute("message","Sorry! Could not update job!");
			return "edit_job";
		}
	}

	@RequestMapping("/search")
	public String search() {
		return "search_jobs";
	}
}
