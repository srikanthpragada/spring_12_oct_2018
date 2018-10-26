package restdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication 
public class GitUserInfo implements CommandLineRunner {

	private RestTemplate restTemplate;
	
	public GitUserInfo(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GitUserInfo.class,args);
	}

	@Override
	public void run(String... args) {
		  GitUser user = restTemplate.getForObject
				     ("https://api.github.com/users/srikanthpragada",
				     GitUser.class);
		  System.out.println("Name     : " + user.getName());
		  System.out.println("Location : " + user.getLocation());
		  System.out.println("Company  : " + user.getCompany());
	}
}