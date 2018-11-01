package webdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webdemo.hb.Job;
import webdemo.hb.JobRepository;

// Supports   GET - URL,  GET - URL/id, POST - URL , DELETE - URL/id,
//            GET - URL/search


@RestController
@RequestMapping("restjobs")
public class JobsRestController {

	@Autowired
	private JobRepository jobRepo;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Job> listJobs() {
		return jobRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Job> getJob(@PathVariable("id") String id) {
		Optional<Job> opJob = jobRepo.findById(id);
		if (opJob.isPresent())
			return ResponseEntity.ok(opJob.get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Job> deleteJob(@PathVariable("id") String id) {
		Optional<Job> opJob = jobRepo.findById(id);
		if (opJob.isPresent()) {
			Job job = opJob.get(); 
			jobRepo.delete(job);
			return ResponseEntity.ok(job);
		}
		else
		{
			System.out.println("Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addJob(@RequestBody Job job) {
		try {
			jobRepo.save(job); // Insert
		} catch (Exception ex) {
			System.out.println("Error in addJob() -> " + ex.getMessage());
		}
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public Iterable<Job> searchJobs(@RequestParam("title") String title) {
		System.out.println("Searching for " + title);
		List<Job> jobs = jobRepo.getJobsByTitle("%" + title.toUpperCase() + "%");
		return jobs;
	}

}

