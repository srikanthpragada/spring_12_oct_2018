package webdemo.hb;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, String> {

	@Query(value = "from Job j where upper(j.title) like ?1")
	List<Job> getJobsByTitle(String title);
}
