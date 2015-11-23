package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
class DefaultGreetingService implements GreetingService {

	private final List<Greeting> greetings = new ArrayList<>();

	public Greeting saveGreeting(Greeting greeting) {

		greetings.add(greeting);
		return greeting;
	}

	public Iterable<Greeting> getGreetings() {
		return greetings;
	}

}
