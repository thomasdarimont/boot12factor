package demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class GreetingController {

	private final GreetingService service;

	@Autowired
	public GreetingController(GreetingService service) {
		this.service = service;
	}

	@RequestMapping("/")
	String index(@RequestParam(value = "person", required = false, defaultValue = "nobody") String person) {

		log.debug("I intend to greet " + person);
		Greeting greeting = service.saveGreeting(new Greeting(person, new Date()));
		return greeting.toString();
	}

	@RequestMapping("/history")
	Iterable<Greeting> greetingList() {
		return service.getGreetings();
	}
}
