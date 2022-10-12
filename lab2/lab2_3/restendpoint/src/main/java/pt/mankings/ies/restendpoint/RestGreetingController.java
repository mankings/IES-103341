package pt.mankings.ies.restendpoint;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RestGreetingController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "user", defaultValue = "World") String user) {
        return new Greeting(counter.incrementAndGet(), String.format(template, user));
    }
}
