package webdemo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		return "<h1>Hello Spring MVC </h1>";
	}
	
	@RequestMapping(value = "/wish")
	@ResponseBody
	public String wish(@RequestParam(name = "user",required = false) String user) {
		 return "<h1>Good Morning " +
	              (user ==  null ? "Unknown" : user) + "</h1>";  
	}

	@RequestMapping(value = "/greet")
	public String greet(@RequestParam(name = "user") String user,
		                ModelMap model) {
		model.addAttribute("user", user);
		model.addAttribute("today", LocalDate.now().toString());
		return "greet";  // View name 
	}
}
