package demo;

interface GreetingService {

	Greeting saveGreeting(Greeting greeting);

	Iterable<Greeting> getGreetings();

}
