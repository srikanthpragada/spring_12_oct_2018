package webdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String addJob(@ModelAttribute Job job, ModelMap model) {
		try {
			jobRepo.save(job);
			model.addAttribute("message", "Job has been added successfully!");
			return "redirect:list";
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

}
