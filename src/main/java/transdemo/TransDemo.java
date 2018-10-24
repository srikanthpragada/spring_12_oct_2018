package transdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class TransDemo implements CommandLineRunner {

	@Autowired 
	private EmployeeManager em;

	public static void main(String[] args) {
		SpringApplication.run(TransDemo.class,args);
	}

	@Override
	public void run(String... args) {
		  em.changeSalaries(143,1444);
	}
}